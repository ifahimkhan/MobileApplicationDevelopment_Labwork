package com.fahim.mobileapplicationdevelopment_labwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

}
