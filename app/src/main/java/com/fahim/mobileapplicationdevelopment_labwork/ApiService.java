package com.fahim.mobileapplicationdevelopment_labwork;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("/api/videos")
    Call<List<VideoItem>> getVideos();
}
