package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final int FILE_PICKER_REQUEST = 1;
    private static final int FILE_CREATE_REQUEST = 2;
    private static final int DIRECTORY_PICKER_REQUEST = 3;
    private TextView tvFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPickDir = findViewById(R.id.btnPickDirectory);
        Button btnCreateFile = findViewById(R.id.btnCreateFile);
        Button btnPickFile = findViewById(R.id.btnPickFile);
        tvFileName = findViewById(R.id.tvFileName);

        btnPickFile.setOnClickListener(v -> openFilePicker());
        btnCreateFile.setOnClickListener(v -> createFile());
        btnPickDir.setOnClickListener(v -> openDirectory());
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");  // Allow all file types
        startActivityForResult(intent, FILE_PICKER_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILE_PICKER_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                String fileName = getFileName(uri);
                String fileContent = readTextFromUri(uri);

                tvFileName.setText("File Name: " + fileName + "\nContent:\n" + fileContent);


            }
        }else if (requestCode == FILE_CREATE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            writeTextToUri(uri, "Hello, this is a new file created via SAF!");
        }else if (requestCode == DIRECTORY_PICKER_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            tvFileName.setText("Selected Directory: " + uri.toString());
        }
    }

    private String getFileName(Uri uri) {
        String fileName = "Unknown File";
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            if (nameIndex != -1) {
                fileName = cursor.getString(nameIndex);
            }
            cursor.close();
        }
        return fileName;
    }

    private String readTextFromUri(Uri uri) {
        StringBuilder content = new StringBuilder();
        try (InputStream inputStream = getContentResolver().openInputStream(uri);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    private void createFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "newfile.txt"); // Default name
        startActivityForResult(intent, FILE_CREATE_REQUEST);
    }
    private void writeTextToUri(Uri uri, String text) {
        try (OutputStream outputStream = getContentResolver().openOutputStream(uri);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openDirectory() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        startActivityForResult(intent, DIRECTORY_PICKER_REQUEST);
    }




}