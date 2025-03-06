package com.fahim.mobileapplicationdevelopment_labwork;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        apiService = RetrofitClient.getInstance().create(ApiService.class);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        fetchTodos();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new TodoAdapter(todos);
        recyclerView.setAdapter(adapter);


    }

    private void fetchTodos() {
        progressBar.setVisibility(VISIBLE);
        apiService.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todos.clear();
                progressBar.setVisibility(GONE);
                if (response.body() != null) {
                    todos.addAll(response.body());
                    adapter.notifyItemRangeInserted(1, todos.size());
                    Toast.makeText(MainActivity.this, "Fetched " + todos.size() + " todos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error fetching todos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                progressBar.setVisibility(GONE);
                Toast.makeText(MainActivity.this, "Error fetching todos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}