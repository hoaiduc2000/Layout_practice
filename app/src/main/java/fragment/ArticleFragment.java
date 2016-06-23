package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyenhoaiduc.layout_practice.R;
import com.example.nguyenhoaiduc.layout_practice.ContentActivity;

import java.util.ArrayList;

import adapter.ArticleAdapter;
import model.Article;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class ArticleFragment extends Fragment implements ArticleAdapter.OnClickListener {
    private RecyclerView mRecyclerView;
    private ArticleAdapter mArticleAdapter;
    private ArrayList<Article> mArticleArrayList;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_article, container, false);
        initData();
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    public void initData() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mArticleArrayList = new ArrayList();
        for (int i = 0; i < 200; i++)
            mArticleArrayList.add(new Article("fsdf", "fsgs"));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mArticleAdapter = new ArticleAdapter(getActivity(), mArticleArrayList);
        mArticleAdapter.setOnclickListener(this);
        mRecyclerView.setAdapter(mArticleAdapter);
        mArticleAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnClickListener(String content) {
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra("content", content);
        startActivity(intent);

    }
}
