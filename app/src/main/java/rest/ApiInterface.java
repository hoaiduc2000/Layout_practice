package rest;

import java.util.List;

import model.TestModel;
import model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nguyen.hoai.duc on 6/24/2016.
 */
public interface ApiInterface {
    @GET("data/2.5/weather?q=hanoi&units=metric&appid=8f7d676b8457df2da9c6c9dd10e1fdfe")
    Call<Weather> getCurrentWeather();

    @GET("rank/list")
    Call<TestModel> getDataModel();
}
