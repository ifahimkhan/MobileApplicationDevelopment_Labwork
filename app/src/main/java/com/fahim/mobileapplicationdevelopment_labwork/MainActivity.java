package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    /*
    RequestOptions requestOptions = new RequestOptions()
            .skipMemoryCache(true) // Focus on using Bitmap Pool
            .diskCacheStrategy(DiskCacheStrategy.NONE);*/
    ActivityResultLauncher<Intent> cameraLauncher;
    ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
       cameraLauncher = registerForActivityResult(
               new ActivityResultContracts.StartActivityForResult(),
               new ActivityResultCallback<ActivityResult>() {
                   @Override
                   public void onActivityResult(ActivityResult activityResult) {
                       Intent data = activityResult.getData();
                       Bundle extras = data.getExtras();
                       Bitmap mBitmap = (Bitmap) extras.get("data");
                       imageView.setImageBitmap(mBitmap);
                   }
               }
       );
        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        Intent data = activityResult.getData();
                        Uri chosenImageUri = data.getData();
           /* Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(chosenImageUri)
                    .apply(requestOptions)
                    .into(imageView);*/

                        Bitmap mBitmap = null;
                        try {
                            mBitmap = MediaStore.Images.Media.getBitmap(MainActivity.this.getContentResolver(), chosenImageUri);
                            imageView.setImageBitmap(mBitmap);
                        } catch (IOException e) {
                            Log.e("TAG", "error loading image", e);
                            Toast.makeText(MainActivity.this, "error loading image", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
       /* String filePathOne="";
        String filePathTwo="";

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        Bitmap bitmapOne = BitmapFactory.decodeFile(filePathOne, options);
        imageView.setImageBitmap(bitmapOne);

        options.inBitmap = bitmapOne; // Reuse bitmapOne's memory
        Bitmap bitmapTwo = BitmapFactory.decodeFile(filePathTwo, options);
        imageView.setImageBitmap(bitmapTwo);

        RequestOptions requestOptions = new RequestOptions()
                .skipMemoryCache(true) // Focus on using Bitmap Pool
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(MainActivity.this)
                .asBitmap()
                .load(filePathOne)
                .apply(requestOptions)
                .into(imageView);*/

    }

    public void selectImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        galleryLauncher.launch(photoPickerIntent);
//        startActivityForResult(Intent.createChooser(photoPickerIntent,"Pick Image"), 1);

    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1)
        {
            Uri chosenImageUri = data.getData();
           *//* Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(chosenImageUri)
                    .apply(requestOptions)
                    .into(imageView);*//*

            Bitmap mBitmap = null;
            try {
                mBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), chosenImageUri);
                imageView.setImageBitmap(mBitmap);
            } catch (IOException e) {
                Log.e("TAG", "error loading image", e);
                Toast.makeText(this, "error loading image", Toast.LENGTH_SHORT).show();
            }

        }
        else if (resultCode == RESULT_OK && requestCode == 2) {
            Bundle extras = data.getExtras();
            Bitmap mBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(mBitmap);
            *//*Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(extras.get("data"))
                    .apply(requestOptions)
                    .into(imageView);
*//*
        }
    }*/

    public void captureImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(Intent.createChooser(intent,"Camera"));

//        startActivityForResult(intent,2);
    }

}