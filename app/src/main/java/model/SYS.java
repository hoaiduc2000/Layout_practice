package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nguyen.hoai.duc on 6/27/2016.
 */
public class Sys implements Serializable {
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private int sunrise;
    @SerializedName("sunset")
    private int sunset;
    public Sys(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
