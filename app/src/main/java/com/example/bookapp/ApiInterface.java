package com.example.bookapp;

import com.example.bookapp.models.MainObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("books/v1/volumes")
    Call<MainObject> getNews(
            @Query("q") String type,
            @Query("maxResults") Integer max);
}
