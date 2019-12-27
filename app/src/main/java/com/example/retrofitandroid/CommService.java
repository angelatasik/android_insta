package com.example.retrofitandroid;

import org.w3c.dom.Document;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class ComentService {
        public static Retrofit retrofitClient;
        public static Document _commentService;

        public static void initalizeRetrofit()
        {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl("http://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            _commentService = retrofitClient.create(IPostService.class);
        }

    }

