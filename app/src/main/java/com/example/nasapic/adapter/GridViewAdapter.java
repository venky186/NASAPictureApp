package com.example.nasapic.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nasapic.R;
import com.example.nasapic.View.DetailActivity;
import com.example.nasapic.model.NasaPicModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<NasaViewHolder> {

    private List<NasaPicModel> mNasalist;
    private Context mContext;

    public GridViewAdapter(Context mContext, List<NasaPicModel> mNasalist) {
        this.mContext = mContext;
        this.mNasalist = mNasalist;
    }

    @Override
    public NasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new NasaViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final NasaViewHolder holder, int position) {
        Picasso.with(mContext).load(mNasalist.get(position).getUrl()).error(R.mipmap.ic_launcher).into(holder.mImage);
        holder.mTitle.setText(mNasalist.get(position).getTitle());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("data",  mNasalist.get(position));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, holder.mImage, "sharedImage");
                mContext.startActivity(mIntent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNasalist.size();
    }
}

class NasaViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView;

    NasaViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
    }
}