package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fileDownload(View view) {
        Log.e("TAG", "fileDownload Starts: ");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable downloadImageTask = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("File downloaded by: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.submit(downloadImageTask);
        executor.shutdown();

    }

    public void multipleApiCalls(View view) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            final int apiNumber = i;
            executor.submit(() -> {
                System.out.println("Fetching data from API " + apiNumber + " by: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

    }

    public void periodicTaskExecution(View view) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

        Runnable refreshDashboardTask = () -> {
            System.out.println("Refreshing dashboard by: " + Thread.currentThread().getName());
        };

        scheduledExecutor.scheduleWithFixedDelay(refreshDashboardTask, 0, 5, TimeUnit.SECONDS);

    }

    public void returnResultCallable(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> calculateSquare = () -> {
            int number = 5;
            return number * number;
        };

        Future<Integer> future = executor.submit(calculateSquare);
        try {
            int result = future.get();
            System.out.println("Square is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }

    public void handleLongRunningTask(View view) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<String> files = Arrays.asList("file1.txt", "file2.txt", "file3.txt", "file4.txt");

        for (String file : files) {
            executor.submit(() -> {
                System.out.println("Processing " + file + " by: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

    }

    public void timeoutTask(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> longRunningTask = () -> {
            Log.e("TAG", "starting long running Task: ");
            Thread.sleep(6000);
            return "Task completed";
        };

        Future<String> future = executor.submit(longRunningTask);
        try {
            Log.e("TAG", "starting wait time: ");
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Task took too long, canceling...");
            future.cancel(true);
        }
        Log.e("TAG", "ending wait time: ");

        executor.shutdown();

    }

    public void databaseOperation(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable readFromDatabaseTask = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Data read from the database by: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.submit(readFromDatabaseTask);
        executor.shutdown();

    }

    public void parallelProcessing(View view) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<String> images = Arrays.asList("image1.jpg", "image2.jpg", "image3.jpg");

        for (String image : images) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
                System.out.println("Processing " + image + " by: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

    }
}