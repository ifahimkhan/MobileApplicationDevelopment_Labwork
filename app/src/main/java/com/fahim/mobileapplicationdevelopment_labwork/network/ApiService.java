package com.fahim.mobileapplicationdevelopment_labwork.network;

import com.fahim.mobileapplicationdevelopment_labwork.Todo;
import com.fahim.mobileapplicationdevelopment_labwork.model.MyResponseBody;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
   @GET("get")
    Call<MyResponseBody> testCache();

}
