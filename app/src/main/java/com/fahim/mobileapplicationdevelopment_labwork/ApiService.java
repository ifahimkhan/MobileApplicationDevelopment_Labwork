package com.fahim.mobileapplicationdevelopment_labwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/MobileApplicationDevelopment_Labwork/video.json")
    Call<List<VideoItem>> getVideos();
}
