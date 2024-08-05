package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewGroceries;
    private GroceryAdapter adapter;
    private ArrayList<GroceryItem> groceriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewGroceries = findViewById(R.id.listview_groceries);
        initArrayList();
        adapter = new GroceryAdapter(this, groceriesList);
        listViewGroceries.setAdapter(adapter);
        listViewGroceries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroceryItem groceryItem = adapter.getItem(position);
                Toast.makeText(MainActivity.this, groceryItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initArrayList() {
        groceriesList.clear();
        groceriesList.add(new GroceryItem("Potato", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Onion", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Apple", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Carrot", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Lettuce", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Tomato", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Garlic", R.drawable.ic_launcher_background));
        groceriesList.add(new GroceryItem("Spinach", R.drawable.ic_launcher_background));
//        adapter.notifyDataSetChanged();
    }
}