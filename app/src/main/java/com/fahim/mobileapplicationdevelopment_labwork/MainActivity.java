package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView dateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateSelected = findViewById(R.id.dateSelected);
        dateSelected.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                popUpDialog(v);
                return true;
            }
        });
        dateSelected.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP){
                    dateSelected.setTextColor(getColor(R.color.fahimColor));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                           dateSelected.setTextColor(getColor((R.color.black)));
                        }
                    }, 1000);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    dateSelected.setTextColor(getColor(R.color.fahimColor1));

                }
                if (event.getAction() == MotionEvent.ACTION_MOVE){
                    dateSelected.setTextColor(getColor(R.color.fahimColor2));

                }
                return false;
            }
        });
    }

    private void popUpDialog(View v) {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.clear){
                    dateSelected.setText("");
                }
                if (item.getItemId() == R.id.reset){
                    dateSelected.setText("No date selected");
                }
                return false;

            }
        });
    }

    public void showDatePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateSelected.setText("Date Selected: " + dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.save) {
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}