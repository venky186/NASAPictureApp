package com.example.nasapic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.nasapic.R;
import com.squareup.picasso.Picasso;

public class MyViewPagerAdapter extends PagerAdapter {
    private String[] images;
    private LayoutInflater inflater;
    private Context context;
    public MyViewPagerAdapter(Context context, String[] images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.pager_item, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imageView);
        Picasso.with(context).load(images[position]).error(R.mipmap.ic_launcher).into(myImage);
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }
    @Override
    public boolean isViewFromObject(View view, @NonNull Object object) {
        return view.equals(object);
    }
}