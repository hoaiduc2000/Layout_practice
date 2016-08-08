package rest;

import model.ForeCastWeather;
import model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by nguyen.hoai.duc on 6/24/2016.
 */
public interface ApiInterface {

    @GET("data/2.5/weather?units=metric&appid=8f7d676b8457df2da9c6c9dd10e1fdfe")
    Call<Weather> getCurrentWeather(@Query("lat") String lat,@Query("lon") String lon);

    @GET("data/2.5/forecast?mode=json&units=metric&appid=8f7d676b8457df2da9c6c9dd10e1fdfe")
    Call<ForeCastWeather> getForeCastWeather(@Query("lat") String lat,@Query("lon") String lon);

//    @GET("rank/list")
//    Call<TestModel> getDataModel();
}
