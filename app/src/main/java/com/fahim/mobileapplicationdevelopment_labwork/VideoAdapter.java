package com.fahim.mobileapplicationdevelopment_labwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoItem> videoList;

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title, channel;

        public VideoViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.image_thumbnail);
            title = itemView.findViewById(R.id.text_title);
            channel = itemView.findViewById(R.id.text_channel);
        }
    }

    public VideoAdapter(List<VideoItem> list) {
        this.videoList = list;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoItem item = videoList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(item.getThumbnail_url())
                .into(holder.thumbnail);
        holder.title.setText(item.getTitle());
        holder.channel.setText(item.getChannel_title());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
