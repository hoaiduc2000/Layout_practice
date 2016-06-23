package com.example.nguyenhoaiduc.layout_practice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import fragment.ArticleFragment;
import fragment.WeatherFragment;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class MainActivity extends AppCompatActivity{
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }
    public void initData(){
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        WeatherFragment firstFragment = new WeatherFragment();
        ArticleFragment secondFragment = new ArticleFragment();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return firstFragment;
                case 1:
                    return secondFragment;
                default:
                    return firstFragment;
            }
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
}
