package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_practice.R;

import java.util.ArrayList;
import java.util.List;

import model.Weather;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class WeatherAdapter extends ArrayAdapter implements Filterable {
    private Activity mContext;
    private int mLayoutId;
    private ArrayList<Weather> mWeatherArrayList;

    public WeatherAdapter(Activity context, int resource, ArrayList<Weather> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayoutId = resource;
        this.mWeatherArrayList = objects;
    }

    public WeatherAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return mWeatherArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        convertView = inflater.inflate(mLayoutId, null);

        final TextView tv_day = (TextView) convertView.findViewById(R.id.text_view_day);
        final TextView tv_status = (TextView) convertView.findViewById(R.id.text_view_status2);
        final TextView tv_temp = (TextView) convertView.findViewById(R.id.text_view_temp3);

        tv_day.setText(mWeatherArrayList.get(position).getmDay());
        tv_status.setText(mWeatherArrayList.get(position).getmStatus());
        tv_temp.setText(mWeatherArrayList.get(position).getmTemp());
        return convertView;
    }
}
