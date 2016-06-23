package fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nguyenhoaiduc.layout_practice.R;

import java.util.ArrayList;

import adapter.ListItemAdapter;
import model.Weather;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class WeatherFragment extends Fragment {
    private ListItemAdapter adapter;
    private ArrayList<Weather> list;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_weather,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    public void initData(){
        list =  new ArrayList();

        for(int i=0; i<200;i++) {
            list.add(new Weather("Tomorrow", "Sunny", "15\u2103 - 28℃"));
        }
        listView = (ListView) getActivity().findViewById(R.id.lv_item);
        adapter = new ListItemAdapter(getActivity(), R.layout.list_weather,list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
