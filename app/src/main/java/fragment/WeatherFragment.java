package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nguyenhoaiduc.layout_practice.R;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import adapter.WeatherAdapter;
import model.TestModel;
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
    private ListView mListView;
    private final static String API_KEY ="8f7d676b8457df2da9c6c9dd10e1fdfe";

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


    public void initDataModel() {
        mWeatherArrayList = new ArrayList();

/*        for (int i = 0; i < 200; i++) {
            mWeatherArrayList.add(new Weather("Tomorrow", "Sunny", "15\u2103 - 28℃"));
        }*/
        mListView = (ListView) getActivity().findViewById(R.id.list_view_item);
        mAdapter = new WeatherAdapter(getActivity(), R.layout.list_item_weather, mWeatherArrayList);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();



//        Call<TestModel> listCall = apiInterface.getDataModel();
//        listCall.enqueue(new Callback<TestModel>() {
//            @Override
//            public void onResponse(Call<TestModel> call, Response<TestModel> response) {
//            //    Log.d("AAA", "status code: " + response.code());
//                if (response != null) {
//                    TestModel testModel = response.body();
//               //     Log.d("AAA", "data " + testModel.getName());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<TestModel> call, Throwable t) {
//                Log.d("AAA", "onFailure " + t.getMessage());
//            }
//        });
//

        Call<Weather> call = apiInterface.getCurrentWeather();
        try {
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    mWeather = response.body();
                    Log.d("AAA", "data weather: " + mWeather.getName());
/*                    mWeather.setId(response.body().getId().toString());
                    mWeather.setIcon(response.body().getIcon().toString());
                    mWeather.setMain(response.body().getMain().toString());
                    mWeather.setName(response.body().getName().toString());
                    mWeather.setTemp(response.body().getTemp().toString());
                    mWeather.setTemp_min(response.body().getTemp_min().toString());
                    mWeather.setTemp_max(response.body().getTemp_max().toString());
                    mWeather.setSpeed(response.body().getSpeed().toString());*/
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {

                    Log.e("Check", t.toString());
                }
            });
        }catch(Exception e){

        }
    }
}
