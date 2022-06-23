package com.example.nasapic.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;

import com.example.nasapic.R;
import com.example.nasapic.adapter.GridViewAdapter;
import com.example.nasapic.utils.Util;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set an enter transition
        getWindow().setEnterTransition(new ChangeBounds());
// set an exit transition
        getWindow().setExitTransition(new ChangeBounds());
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        GridViewAdapter myAdapter = new GridViewAdapter(MainActivity.this, Util.getNasaModel(this));
        mRecyclerView.setAdapter(myAdapter);
    }
}