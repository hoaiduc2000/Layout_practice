package com.example.nguyenhoaiduc.layout_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.ListItemAdapter;
import model.Weather;

public class WeatherActivity extends AppCompatActivity {

    private ListItemAdapter adapter;
    private ArrayList<Weather> list;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initData();
    }

    public void initData(){
        list =  new ArrayList();

        for(int i=0; i<100;i++) {
            list.add(new Weather("Tomorrow", "Sunny", "15\u2103 - 28℃"));
        }
        listView = (ListView) findViewById(R.id.lv_item);
        adapter = new ListItemAdapter(this, R.layout.list_weather,list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public interface ClickListener{
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
}
