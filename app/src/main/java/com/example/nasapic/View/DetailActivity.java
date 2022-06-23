package com.example.nasapic.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nasapic.R;
import com.example.nasapic.adapter.MyViewPagerAdapter;
import com.example.nasapic.model.NasaPicModel;

import me.relex.circleindicator.CircleIndicator;

public class DetailActivity extends AppCompatActivity {

    TextView mDescription;
TextView mTitle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = findViewById(R.id.tvTitle);
        mDescription = findViewById(R.id.tvDescription);

        Bundle mBundle = getIntent().getExtras();
        NasaPicModel nasaPicModel = (NasaPicModel) mBundle.getSerializable("data");
        if (mBundle != null) {
            mDescription.setText(nasaPicModel.getExplanation());
            mTitle.setText(nasaPicModel.getTitle());
        }
        adviewpager(new String[] {nasaPicModel.getHdurl(),nasaPicModel.getUrl()});
    }
    private void adviewpager(String [] images) {
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyViewPagerAdapter(DetailActivity.this, images));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.createIndicators(5,0);

        indicator.animatePageSelected(2);
        indicator.setViewPager(mPager);
    }
}
