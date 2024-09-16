package com.fahim.mobileapplicationdevelopment_labwork;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_STORAGE = 2;

    Button selectFileButton;
    ListView studentListView;
    StudentAdapter adapter;
    ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectFileButton = findViewById(R.id.selectFileButton);
        studentListView = findViewById(R.id.studentListView);
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        studentListView.setAdapter(adapter);

        selectFileButton.setOnClickListener(v -> checkPermissionAndOpenFilePicker());
    }

    private void checkPermissionAndOpenFilePicker() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);
        } else {
            openFilePicker();
        }
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"text/comma-separated-values", "text/csv"});
        resultLauncher.launch(Intent.createChooser(intent, "Select CSV"));
    }

    private final ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri uri = result.getData().getData();
                    readCsvFile(uri);
                }
            });

    private void readCsvFile(Uri uri) {
        try {
            InputStreamReader isr = new InputStreamReader(getContentResolver().openInputStream(uri));
            BufferedReader reader = new BufferedReader(isr);

            String line;
            studentList.clear();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String sapNumber = fields[0];
                    String rollNumber = fields[1];
                    String studentName = fields[2];
                    studentList.add(new Student(sapNumber, rollNumber, studentName));
                }
            }

            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to read CSV file", Toast.LENGTH_SHORT).show();
        }
    }
}
