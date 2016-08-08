package rest;

import com.google.android.gms.maps.model.LatLng;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nguyen.hoai.duc on 6/24/2016.
 */
public class ApiClient {
    public static final String BASE_URL = "http://api.openweathermap.org/";
    // public static final String BASE_URL = "http://demo1299317.mockable.io/";
    private static Retrofit retrofit = null;

    public static Retrofit getClientWeather(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
