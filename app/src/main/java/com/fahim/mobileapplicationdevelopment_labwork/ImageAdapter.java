package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> imagePaths;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, ArrayList<String> imagePaths) {
        this.context = context;
        this.imagePaths = imagePaths;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imagePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return imagePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_image, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String imagePath = imagePaths.get(position);

        // Efficient image loading: decode sampled bitmap to prevent OOM
        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inSampleSize = 4; // adjust as needed for thumbnails

        Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
        holder.imageView.setImageBitmap(bitmap);

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}
