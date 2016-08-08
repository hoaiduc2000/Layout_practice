package fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nguyenhoaiduc.layout_practice.MainActivity;
import com.example.nguyenhoaiduc.layout_practice.R;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import adapter.WeatherAdapter;
import model.ForeCast;
import model.ForeCastWeather;
import model.Weather;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.FileUtils;

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class WeatherFragment extends Fragment {
    private WeatherAdapter mAdapter;
    private ArrayList<ForeCast> mForeCastArrayList;
    private Weather mWeather;
    private FileUtils mFileUtils;
    private ForeCastWeather mForeCastWeather;
    private ListView mListView;

    private TextView mTextViewLocation;
    private TextView mTextViewTemp;
    private TextView mTextViewTemp2;
    private TextView mTextViewStatus;
    private TextView mTextViewWind;

    private ImageView mImageView;

    private Call<Weather> mCallWeather;
    private Call<ForeCastWeather> mCallForeCastWeather;

    ApiInterface apiInterface;
    private ProgressDialog mProgressDialog;

    private LatLng mLatLng = new LatLng(0, 0);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLatLng = ((MainActivity) getActivity()).getmLatLng();
        apiInterface = ApiClient.getClientWeather().create(ApiInterface.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDataModel();
    }

    public void updateUI() {
        mTextViewLocation.setText(mWeather.getName());
        mTextViewTemp.setText(mFileUtils.getRound(mWeather.getMain().getTemp(), 0) + "\u2103");
        mTextViewTemp2.setText(mFileUtils.getRound(mWeather.getMain().getTemp_min(), 0) + "\u2103"
                + " - " + mFileUtils.getRound(mWeather.getMain().getTemp_max(), 0) + "\u2103 ");
        mTextViewStatus.setText(mWeather.getMainStatus().get(0).getMain());
        mTextViewWind.setText(mWeather.getWind().getSpeed() + " mph");
        Picasso.with(getContext()).load("http://openweathermap.org/img/w/" + mWeather.getMainStatus()
                .get(0).getIcon() + ".png").into(mImageView);

    }

    public void initDataModel() {
        mForeCastArrayList = new ArrayList();
        mForeCastWeather = new ForeCastWeather();
        mFileUtils = new FileUtils();
        mForeCastWeather.setForeCasts(new ArrayList<ForeCast>());
        mListView = (ListView) getActivity().findViewById(R.id.list_view_item);
        mAdapter = new WeatherAdapter(getActivity(), R.layout.list_item_weather, mForeCastArrayList);
        mListView.setAdapter(mAdapter);

        mTextViewLocation = (TextView) getActivity().findViewById(R.id.text_view_location);
        mTextViewStatus = (TextView) getActivity().findViewById(R.id.text_view_status);
        mTextViewTemp = (TextView) getActivity().findViewById(R.id.text_view_temp);
        mTextViewTemp2 = (TextView) getActivity().findViewById(R.id.text_view_temp2);
        mTextViewWind = (TextView) getActivity().findViewById(R.id.text_view_wind);

        mImageView = (ImageView) getActivity().findViewById(R.id.image_view_status);

        enqueueData("21.0306078", "105.8449229");


    }

    public void enqueueData(String lat, String lon) {
        mProgressDialog = ProgressDialog.show(getActivity(), "Cập nhật dữ liệu", "Đang quét...");
        mCallWeather = apiInterface.getCurrentWeather(lat, lon);
        try {
            mCallWeather.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    mWeather = response.body();
                    updateUI();
                    if (mWeather != null && mForeCastWeather != null)
                        mProgressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }

        mCallForeCastWeather = apiInterface.getForeCastWeather(lat, lon);
        try {
            mCallForeCastWeather.enqueue(new Callback<ForeCastWeather>() {
                @Override
                public void onResponse(Call<ForeCastWeather> call, Response<ForeCastWeather> response) {
                    mForeCastWeather = response.body();
                    mForeCastArrayList.clear();
                    mForeCastArrayList.addAll(mForeCastWeather.getForeCasts());
                    mAdapter.notifyDataSetChanged();
                    if (mWeather != null && mForeCastWeather != null)
                        mProgressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<ForeCastWeather> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCallWeather != null || mCallForeCastWeather != null) {
            mCallWeather.cancel();
            mCallForeCastWeather.cancel();
        }
    }

    public void setLatLon(LatLng latLng){
        enqueueData(latLng.latitude + "", latLng.longitude + "");
    }
}
