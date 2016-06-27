package fragment;


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

import com.example.nguyenhoaiduc.layout_practice.R;
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

/**
 * Created by nguyen.hoai.duc on 6/23/2016.
 */
public class WeatherFragment extends Fragment {
    private WeatherAdapter mAdapter;
    private ArrayList<Weather> mWeatherArrayList;
    private Weather mWeather;
    private ForeCastWeather mForeCastWeather;
    private ListView mListView;

    private TextView mTextViewLocation;
    private TextView mTextViewTemp;
    private TextView mTextViewTemp2;
    private TextView mTextViewStatus;
    private TextView mTextViewWind;

    private ImageView mImageView;


    private final static String API_KEY = "8f7d676b8457df2da9c6c9dd10e1fdfe";

    ApiInterface apiInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
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
        mTextViewLocation.setText("Hà Nội");
        mTextViewTemp.setText(getRound(mWeather.getMain().getTemp(),0)+"\u2103");
        mTextViewTemp2.setText(getRound(mWeather.getMain().getTemp_min(),0)+"\u2103"+" - "+getRound(mWeather.getMain().getTemp_max(),0)+"\u2103 ");
        mTextViewStatus.setText(mWeather.getMainStatus().get(0).getMain());
        mTextViewWind.setText(mWeather.getWind().getSpeed()+" mph");
        Picasso.with(getContext()).load("http://openweathermap.org/img/w/"+mWeather.getMainStatus().get(0).getIcon()+".png").into(mImageView);

    }

    public void initDataModel() {
        mWeatherArrayList = new ArrayList();
        mForeCastWeather = new ForeCastWeather();
        mForeCastWeather.setForeCasts( new ArrayList<ForeCast>());
        mListView = (ListView) getActivity().findViewById(R.id.list_view_item);
        mAdapter = new WeatherAdapter(getActivity(), R.layout.list_item_weather, mForeCastWeather.getForeCasts());
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mTextViewLocation = (TextView) getActivity().findViewById(R.id.text_view_location);
        mTextViewStatus = (TextView) getActivity().findViewById(R.id.text_view_status);
        mTextViewTemp = (TextView) getActivity().findViewById(R.id.text_view_temp);
        mTextViewTemp2 = (TextView) getActivity().findViewById(R.id.text_view_temp2);
        mTextViewWind = (TextView) getActivity().findViewById(R.id.text_view_wind);

        mImageView = (ImageView) getActivity().findViewById(R.id.image_view_status);

        enqueueData();


    }
    public void enqueueData(){
        Call<Weather> callWeather = apiInterface.getCurrentWeather();
        try {
            callWeather.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    mWeather = response.body();
                    Log.d("AAA", "data weather: " + mWeather.getName());
                    Log.d("AAA", "data weather: " + mWeather.getMainStatus().get(0).getMain());
                    updateUI();
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    Log.e("Check", t.toString());
                }
            });
        } catch (Exception e) {

        }

        Call<ForeCastWeather> callForeCastWeather = apiInterface.getForeCastWeather();
        try {
            callForeCastWeather.enqueue(new Callback<ForeCastWeather>() {
                @Override
                public void onResponse(Call<ForeCastWeather> call, Response<ForeCastWeather> response) {
                    mForeCastWeather = response.body();
                    Log.d("AAA", "data weather: " + mForeCastWeather.getForeCasts().size());
                    mAdapter = new WeatherAdapter(getActivity(), R.layout.list_item_weather, mForeCastWeather.getForeCasts());
                    mListView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ForeCastWeather> call, Throwable t) {
                    Log.e("Check", t.toString());
                }
            });
        } catch (Exception e) {

        }
    }
    public BigDecimal getRound(float d, int decimalPlace ){
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}
