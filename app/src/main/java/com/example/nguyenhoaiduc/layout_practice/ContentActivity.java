package com.example.nguyenhoaiduc.layout_practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class ContentActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initData();
    }

    public void initData() {
        mTextView = (TextView) findViewById(R.id.text_view_content);
        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.get("content").toString());
    }
}
