package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nguyenhoaiduc.layout_practice.R;

import java.util.ArrayList;

import adapter.WeatherAdapter;
import model.Weather;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class WeatherFragment extends Fragment {
    private WeatherAdapter mAdapter;
    private ArrayList<Weather> mWeatherArrayList;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    public void initData() {
        mWeatherArrayList = new ArrayList();

        for (int i = 0; i < 200; i++) {
            mWeatherArrayList.add(new Weather("Tomorrow", "Sunny", "15\u2103 - 28℃"));
        }
        mListView = (ListView) getActivity().findViewById(R.id.list_view_item);
        mAdapter = new WeatherAdapter(getActivity(), R.layout.list_item_weather, mWeatherArrayList);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
