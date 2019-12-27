package com.example.retrofitandroid.Service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    public static Retrofit retrofitClient;

    public static IPostService _postService;

    public static void initalizeRetrofit()
    {
        retrofitClient = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        _postService = retrofitClient.create(IPostService.class);
    }

}