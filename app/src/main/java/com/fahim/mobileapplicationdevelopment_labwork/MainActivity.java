package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private List<VideoItem> videoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ApiService apiService = RetrofitClient.getInstance().getApiService();

        Call<List<VideoItem>> call = apiService.getVideos();
        call.enqueue(new Callback<List<VideoItem>>() {
            @Override
            public void onResponse(Call<List<VideoItem>> call, Response<List<VideoItem>> response) {
                if (!response.isSuccessful() || response.body() == null) return;
                videoList.clear();
                videoList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<VideoItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network call Failed!", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}
