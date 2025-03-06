package com.fahim.mobileapplicationdevelopment_labwork;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit instance;

    private RetrofitClient() {
        // Private constructor to prevent instantiation from outside
    }

    public static synchronized Retrofit getInstance() {
        if (instance == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}