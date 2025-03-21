package com.fahim.mobileapplicationdevelopment_labwork.network;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String BASE_URL = "https://httpbin.org/";
    private static Retrofit instance;

    private RetrofitClient() {
        // Private constructor to prevent instantiation from outside
    }

    public static synchronized Retrofit getInstance(Context context) {
        if (instance == null) {
            File httpCacheDirectory = new File(context.getCacheDir(), "responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(httpCacheDirectory, cacheSize);

            // Logging interceptor
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

            OkHttpClient client = new OkHttpClient.Builder()
                    .cache(cache)
                    .addNetworkInterceptor(new CacheInterceptor())
                    .addInterceptor(new ForceCacheInterceptor(() -> new MyInternetChecker(context).isInternetAvailable()))
                    .addInterceptor(loggingInterceptor)
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