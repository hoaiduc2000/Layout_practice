package com.example.nguyenhoaiduc.layout_practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

import adapter.ArticleAdapter;
import model.Article;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class ArticleActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArticleAdapter mArticleAdapter;
    private ArrayList<Article> list;
    private ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        initData();
    }
    public void initData(){
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mRecyclerView.setHasFixedSize(true);
        list = new ArrayList();
        for(int i=0;i<200;i++)
            list.add(new Article("fsdf","fsgs"));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mArticleAdapter = new ArticleAdapter(this,list);
        mRecyclerView.setAdapter(mArticleAdapter);
        mArticleAdapter.notifyDataSetChanged();

    }
}
