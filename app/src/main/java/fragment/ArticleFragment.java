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
import com.example.nguyenhoaiduc.layout_practice.ResultActivity;

import java.util.ArrayList;

import adapter.ArticleAdapter;
import model.Article;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class ArticleFragment extends Fragment implements ArticleAdapter.OnClickListener{
    private RecyclerView mRecyclerView;
    private ArticleAdapter mArticleAdapter;
    private ArrayList<Article> list;
    private ImageView mImageView;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_article,container,false);
        initData();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    public void initData(){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mImageView = (ImageView) view.findViewById(R.id.iv_image);
        mRecyclerView.setHasFixedSize(true);
        list = new ArrayList();
        for(int i=0;i<200;i++)
            list.add(new Article("fsdf","fsgs"));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mArticleAdapter = new ArticleAdapter(getActivity(),list);
        mArticleAdapter.setOnclickListener(this);
        mRecyclerView.setAdapter(mArticleAdapter);
        mArticleAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnClickListener(String content) {
        Intent intent = new Intent(getActivity(), ResultActivity.class);
        intent.putExtra("content",content);
        startActivity(intent);

    }
}
