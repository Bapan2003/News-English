package com.example.newsenglish;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public abstract class ApiInterface {

      public static String base_url="https://newsapi.org/v2/";

    @GET("top-headlines")
    abstract Call<mainNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    ) ;

    @GET("top-headlines")
    abstract Call<mainNews> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

}
