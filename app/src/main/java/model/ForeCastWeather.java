package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nguyen.hoai.duc on 6/27/2016.
 */
public class ForeCastWeather implements Serializable {

    @SerializedName("list")
    private ArrayList<ForeCast> foreCasts;

    public ForeCastWeather(){

    }

    public ArrayList<ForeCast> getForeCasts() {
        return foreCasts;
    }

    public void setForeCasts(ArrayList<ForeCast> foreCasts) {
        this.foreCasts = foreCasts;
    }
}
