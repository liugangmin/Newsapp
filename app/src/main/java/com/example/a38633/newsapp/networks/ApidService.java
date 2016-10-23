package com.example.a38633.newsapp.networks;


import com.example.a38633.newsapp.bean.NewsSummary;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by 38633 on 2016/10/23.
*/

public interface ApidService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String,List<NewsSummary>>> getNewsList(
            @Header("Cache_Control") String cacheControl,
            @Path("type") String type,@Path("id") String id,
            @Path("starPage") int startPage);


}
