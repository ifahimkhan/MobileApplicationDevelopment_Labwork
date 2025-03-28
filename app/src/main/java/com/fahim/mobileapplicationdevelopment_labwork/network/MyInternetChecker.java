package com.fahim.mobileapplicationdevelopment_labwork.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyInternetChecker implements ApplicationCacheInterceptor.IsInternetAvailable {
    private Context context;

    public MyInternetChecker(Context context) {
        this.context = context;
    }

    @Override
    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}