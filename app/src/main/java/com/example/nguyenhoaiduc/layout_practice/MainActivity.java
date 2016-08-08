package com.example.nguyenhoaiduc.layout_practice;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.Frame;

import fragment.ArticleFragment;
import fragment.MapFragment;
import fragment.WeatherFragment;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class MainActivity extends AppCompatActivity implements MapFragment.OnMapClicklistener,MapFragment.OnFragmentChangeListener {
    private ViewPager mViewPager;
    public WeatherFragment mWeatherFragment;
    public MapFragment mMapFragment;
    public ArticleFragment mArticleFragment;
    public static FragmentManager mFragmentManager;
    public LatLng mLatLng = new LatLng(0, 0);

    public LatLng getmLatLng() {
        return mLatLng;
    }

    public void setmLatLng(LatLng mLatLng) {
        this.mLatLng = mLatLng;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    public void initData() {
        mFragmentManager = getSupportFragmentManager();
        mWeatherFragment = new WeatherFragment();
        mMapFragment = new MapFragment();
        mMapFragment.setOnMapclick(this);
        mMapFragment.setOnChangeFragment(this);
        mArticleFragment = new ArticleFragment();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onClick(LatLng latLng) {
       mWeatherFragment.setLatLon(latLng);
    }

    @Override
    public void onChangeFragment() {
        mViewPager.setCurrentItem(0,true);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mWeatherFragment;
                case 1:
                    return mMapFragment;
                case 2:
                    return mArticleFragment;
                default:
                    return mWeatherFragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
