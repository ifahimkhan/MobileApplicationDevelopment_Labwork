package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage {
    public void writeToFile(String data, Context context) {
        String fileName = "example.txt";
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes());
            Toast.makeText(context, "File Written Successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(Context context) {
        String fileName = "example.txt";
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), fileName);
        if (file.exists())
            try (FileInputStream fis = new FileInputStream(file)) {
                int content;
                while ((content = fis.read()) != -1) {
                    stringBuilder.append((char) content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        return stringBuilder.toString();
    }
}
