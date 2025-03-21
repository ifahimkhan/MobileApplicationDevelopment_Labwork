package com.fahim.mobileapplicationdevelopment_labwork.network;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ForceCacheInterceptor implements Interceptor {

    private IsInternetAvailable isInternetAvailable;

    public ForceCacheInterceptor(IsInternetAvailable isInternetAvailable) {
        this.isInternetAvailable = isInternetAvailable;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (!isInternetAvailable.isInternetAvailable()) {
            builder.cacheControl(CacheControl.FORCE_CACHE);
        }
        return chain.proceed(builder.build());
    }

    public interface IsInternetAvailable {
        boolean isInternetAvailable();
    }
}