package com.example.a38633.newsapp.networks;

import android.util.SparseArray;

import com.example.a38633.newsapp.app.App;
import com.example.a38633.newsapp.utils.NetUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 38633 on 2016/10/23.
 */

public class RetrofitManager {
    public static final int READ_TIME_OUT = 7000;
    public static final int CONNECT_TIME_OUT=7000;
    ApiService mService;
    Retrofit retrofit;
    /*************************缓存设置*********************/
/*
   1. noCache 不使用缓存，全部走网络

    2. noStore 不使用缓存，也不存储缓存

    3. onlyIfCached 只使用缓存

    4. maxAge 设置最大失效时间，失效则不使用 需要服务器配合

    5. maxStale 设置最大失效时间，失效则不使用 需要服务器配合 感觉这两个类似 还没怎么弄清楚，清楚的同学欢迎留言

    6. minFresh 设置有效时间，依旧如上

    7. FORCE_NETWORK 只走网络

    8. FORCE_CACHE 只走缓存*/


    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached,max-stale="+CACHE_STALE_SEC;
    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    public static final String CACHE_CONTROL_AGE = "max-age=0";

    private static SparseArray<RetrofitManager>sRetrofitManager = new SparseArray<>(HostType.TYPE_COUNT);
    //构造方法是私有的
    private RetrofitManager(int hostType){
        //获得500M的缓存空间
        File file = new File(App.getContext().getCacheDir(),"httpcache");
        Cache mCache = new Cache( file,1024 * 1024 *500);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //增加头部信息
        Interceptor heasderInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request build = chain.request().newBuilder()
                        .addHeader("Content-Type","application/json")
                        .build();
                return chain.proceed(build);
            }
        };
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mRewriteCAcheControlInterceptor)
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT,TimeUnit.MILLISECONDS)
                .cache(mCache)
                .addNetworkInterceptor(mRewriteCAcheControlInterceptor)
                .addInterceptor(heasderInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ssZ").serializeNulls().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstans.getHost(hostType))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();


        mService = retrofit.create(ApiService.class);


    }

    /**
     *
     * @param
     * @return
     */
    public static ApiService getDelfult(int hostType){
        RetrofitManager retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null){
            retrofitManager = new RetrofitManager(hostType);
            sRetrofitManager.put(hostType,retrofitManager);
        }
        return retrofitManager.mService;
    }

    /**
     * 根据网络状况获取缓存的策略；
     * @return
     */
    public static String getCacheControl(){
        return NetUtil.isNetworkConncted() ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略；
     */
    private final Interceptor mRewriteCAcheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkConncted()){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkConncted()){
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control",cacheControl)
                        .removeHeader("Pragma")
                        .build();
            }else {
                return originalResponse.newBuilder()
                        .header("Cache-Control","public,only-if-cached,max-stale="+CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

}
