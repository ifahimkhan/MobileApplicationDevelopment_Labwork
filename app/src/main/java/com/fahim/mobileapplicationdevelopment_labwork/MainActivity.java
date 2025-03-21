package com.fahim.mobileapplicationdevelopment_labwork;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fahim.mobileapplicationdevelopment_labwork.model.MyResponseBody;
import com.fahim.mobileapplicationdevelopment_labwork.network.ApiService;
import com.fahim.mobileapplicationdevelopment_labwork.network.RetrofitClient;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private final ArrayList<Todo> todos = new ArrayList<>();
    private ApiService apiService;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = RetrofitClient.getInstance(getApplicationContext()).create(ApiService.class);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new TodoAdapter(todos);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(VISIBLE);
        Call<MyResponseBody> call = apiService.testCache();
        call.enqueue(new Callback<MyResponseBody>() {
            @Override
            public void onResponse(Call<MyResponseBody> call, Response<MyResponseBody> response) {
                progressBar.setVisibility(GONE);
                if (response.isSuccessful()) {
                    todos.clear();

                    Log.d("CACHE_DEBUG", "Response from: " +
                            (response.raw().cacheResponse() != null ? "CACHE" : "NETWORK"));


                    Log.e("TAG", "response body: " + new Gson().toJson(response.body()));

                    String res =new Gson().toJson(response.body());
                    String[] array = res.split(",");

                    Log.e("TAG", "array: " + array.length+res);
                    for (int i = 0; i < array.length; i++) {
                        Todo todo = new Todo(i, i, response.body().toString(), false);
                        todos.add(i, todo);
                    }
                    adapter.notifyDataSetChanged();

                } else {
                    Log.e("CACHE_DEBUG", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MyResponseBody> call, Throwable t) {
                Log.e("CACHE_DEBUG", "Error: " + t.getMessage());
                progressBar.setVisibility(GONE);
            }
        });
    }

}