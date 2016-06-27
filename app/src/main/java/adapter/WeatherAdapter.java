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
import utils.FileUtils;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class WeatherAdapter extends ArrayAdapter implements Filterable {
    private Activity mContext;
    private int mLayoutId;
    private ArrayList<ForeCast> mForeCastArrayList;
    private FileUtils mFileUtils;

    public WeatherAdapter(Activity context, int resource, ArrayList<ForeCast> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayoutId = resource;
        this.mForeCastArrayList = objects;
        mFileUtils = new FileUtils();

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

        final TextView mTextViewTime = (TextView) convertView.findViewById(R.id.text_view_time);
        final TextView mTextViewDate = (TextView) convertView.findViewById(R.id.text_view_date);
        final TextView mTextViewStatus = (TextView) convertView.findViewById(R.id.text_view_status2);
        final TextView mTextViewTemp = (TextView) convertView.findViewById(R.id.text_view_temp3);
        final ImageView mImageView = (ImageView) convertView.findViewById(R.id.image_view_icon);

        Picasso.with(getContext()).load("http://openweathermap.org/img/w/" + mForeCastArrayList
                .get(position).getMainStatus().get(0).getIcon() + ".png").into(mImageView);
        mTextViewTime.setText(mFileUtils.coventerTime(mForeCastArrayList.get(position).getDt()));
        mTextViewDate.setText(mFileUtils.coventerDate(mForeCastArrayList.get(position).getDt()));
        mTextViewStatus.setText(mForeCastArrayList.get(position).getMainStatus().get(0).getMain());
        mTextViewTemp.setText(mFileUtils.getRound(mForeCastArrayList.get(position).getMain()
                .getTemp_min(), 0) + "\u2103" + " - "
                + mFileUtils.getRound(mForeCastArrayList.get(position).getMain().getTemp_max(), 0)
                + "\u2103 ");
        return convertView;
    }
}
