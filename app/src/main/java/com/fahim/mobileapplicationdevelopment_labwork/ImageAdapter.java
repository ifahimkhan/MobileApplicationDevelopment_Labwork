package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private final Context context;
    private Cursor cursor;

    public ImageAdapter(Context context) {
        this.context = context;
        this.cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Images.Media.DATE_ADDED + " DESC" // Sort by latest images first
        );/*
        Log.e("TAG", "cursor: " + cursor.getCount());
        if (cursor == null) {
            Log.e("TAG", "cursor:reinit ");
            String[] projection = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
            String sortOrder = MediaStore.Images.Media.DATE_ADDED + " DESC";

            this.cursor = context.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection, // Specify the columns to retrieve
                    null,      // No selection clause
                    null,      // No selection arguments
                    sortOrder  // Sort order
            );
        }*/
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            // Use MediaStore.Images.Media._ID to get the content URI
            int columnIndex = cursor.getColumnIndex(MediaStore.Images.Media._ID);
            if (columnIndex != -1) {
                long id = cursor.getLong(columnIndex);
                Uri imageUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);

                // Use Glide to load the image using the content URI
                Glide.with(holder.imageView.getContext())
                        .load(imageUri)
                        .override(500)
                        .centerCrop()
                        .into(holder.imageView);
            } else {
                Log.e("ImageAdapter", "Column _ID not found in Cursor.");
            }
        }
    }
    /*@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            int columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            String imagePath = cursor.getString(columnIndex);
            Uri imageUri = Uri.parse(imagePath);

            // Use Glide to load the image efficiently
            Glide.with(context)
                    .load(imageUri)
                    .override(500)
                    .into(holder.imageView);
        }
    }*/

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}