package adapter;

import android.content.Context;
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

    public OnClickListener mOnClickListener;

    public interface OnClickListener {
        void OnClickListener(String content);
    }

    private ArrayList<Article> mArticleArrayList;
    private Context mContext;


    public ArticleAdapter(Context context, ArrayList<Article> arrayList) {
        this.mContext = context;
        this.mArticleArrayList = arrayList;
        this.mOnClickListener = null;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_article, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.MyViewHolder holder, int position) {
        final Article article = mArticleArrayList.get(position);
        final String content = holder.mTextView.getText().toString();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.OnClickListener(content);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleArrayList.size();
    }

    public void setOnclickListener(OnClickListener onclickListener) {
        this.mOnClickListener = onclickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public MyViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_view_article);
        }
    }
}
