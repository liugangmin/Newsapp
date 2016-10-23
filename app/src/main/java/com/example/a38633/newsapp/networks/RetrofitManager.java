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
    ApidService mService;
    Retrofit retrofit;


    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    private static final String CACHE_CONTROL_CACHE = "only-if-cached,max-stale="+CACHE_STALE_SEC;
    public static final String CACHE_CONTROL_AGE = "max-age=0";
      private static SparseArray<RetrofitManager>sRetrofitManager = new SparseArray<>(HostType.TYPE_COUNT);
    private RetrofitManager(int hostType){
        Cache mCache = new Cache(new File(App.getContext().getCacheDir(),"httpcache"),1024 * 1024 *500);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
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


        mService = retrofit.create(ApidService.class);


    }

    /**
     *
     * @param
     * @return
     */
    public static ApidService getDelfult(int hostType){
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
