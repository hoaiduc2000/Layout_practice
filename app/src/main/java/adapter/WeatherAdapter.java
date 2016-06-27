package adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_practice.R;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ForeCast;
import model.ForeCastWeather;
import model.Weather;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class WeatherAdapter extends ArrayAdapter implements Filterable {
    private Activity mContext;
    private int mLayoutId;
    private ArrayList<ForeCast> mForeCastArrayList;

    public WeatherAdapter(Activity context, int resource, ArrayList<ForeCast> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayoutId = resource;
        this.mForeCastArrayList = objects;
    }

    public WeatherAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return mForeCastArrayList.size();
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
        final ImageView iv_icon = (ImageView) convertView.findViewById(R.id.image_view_icon);

        Picasso.with(getContext()).load("http://openweathermap.org/img/w/"+mForeCastArrayList
                .get(position).getMainStatus().get(0).getIcon()+".png").into(iv_icon);
        tv_day.setText(coventerDate(mForeCastArrayList.get(position).getDt()));
        tv_status.setText(mForeCastArrayList.get(position).getMainStatus().get(0).getMain());
        tv_temp.setText(getRound(mForeCastArrayList.get(position).getMain().getTemp_min(),0)+"\u2103"+" - "+getRound(mForeCastArrayList.get(position).getMain().getTemp_max(),0)+"\u2103 ");
        return convertView;
    }
    public String coventerDate(String date){
        String dateFormat="";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        try {
            Date d = format.parse(date);
            long mTime = d.getTime();
            Date mDate = new Date(mTime);
            DateFormat format2 = new SimpleDateFormat("HH:mm");
            dateFormat = format2.format(mDate);
            Log.d("AAAA",dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;
    }
    public BigDecimal getRound(float d, int decimalPlace ){
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}
