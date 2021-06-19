package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private Context mContext;
    private List<PhotoModel> mPhotoList = new ArrayList<>();

    public PhotoAdapter(Context context, List<PhotoModel> photoList) {
        this.mContext = context;
        this.mPhotoList = photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.ViewHolder holder, int position) {
        holder.desc.setText(mPhotoList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(mPhotoList.get(position).getThumbnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
