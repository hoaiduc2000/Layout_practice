package com.example.nguyenhoaiduc.layout_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.ListItemAdapter;
import model.Weather;

public class MainActivity extends AppCompatActivity {

    private ListItemAdapter adapter;
    private ArrayList<Weather> list;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    public void initData(){
        list =  new ArrayList();

        for(int i=0; i<100;i++) {
            list.add(new Weather("Tomorrow", "Sunny", "15\u2103 - 28℃"));
        }
        listView = (ListView) findViewById(R.id.lv_item);
        adapter = new ListItemAdapter(this, R.layout.list_item,list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
