package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewGroceries;
    private GroceryAdapter adapter;
    private ArrayList<GroceryItem> groceriesList = new ArrayList<>();
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGroceries = findViewById(R.id.listview_groceries);
        TextView tv_date = findViewById(R.id.date);
        datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        });

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
        groceriesList.add(new GroceryItem("Potato", R.drawable.potato));
        groceriesList.add(new GroceryItem("Onion", R.drawable.onion));
        groceriesList.add(new GroceryItem("Apple", R.drawable.apple));
        groceriesList.add(new GroceryItem("Carrot", R.drawable.carrot));
        groceriesList.add(new GroceryItem("Lettuce", R.drawable.lettuce));
        groceriesList.add(new GroceryItem("Tomato", R.drawable.tomato));
        groceriesList.add(new GroceryItem("Garlic", R.drawable.garlic));
        groceriesList.add(new GroceryItem("Spinach", R.drawable.spinach));
    }
}