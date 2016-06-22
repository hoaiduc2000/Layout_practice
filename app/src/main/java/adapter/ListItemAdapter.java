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
public class ListItemAdapter extends ArrayAdapter implements Filterable {
    Activity context;
    int layoutId;
    ArrayList<Weather> list;
    public ListItemAdapter(Activity context, int resource, ArrayList<Weather> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.list = objects;
    }

    public ListItemAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);

        final TextView tv_day = (TextView) convertView.findViewById(R.id.tv_day);
        final TextView tv_status = (TextView) convertView.findViewById(R.id.tv_status2);
        final TextView tv_temp = (TextView) convertView.findViewById(R.id.tv_temp3);

        tv_day.setText(list.get(position).getDay());
        tv_status.setText(list.get(position).getStatus());
        tv_temp.setText(list.get(position).getTemp());
        return convertView;
    }
}
