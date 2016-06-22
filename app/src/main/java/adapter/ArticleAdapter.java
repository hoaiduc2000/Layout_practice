package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_practice.R;

import java.util.ArrayList;

import model.Article;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private ArrayList<Article> list;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView content;
        public MyViewHolder(View view){
            super(view);
        }
    }
    public ArticleAdapter(ArrayList<Article> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
