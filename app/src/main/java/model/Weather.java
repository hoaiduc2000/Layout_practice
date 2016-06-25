package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Weather implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
   @SerializedName("temp")
    private float temp;
    @SerializedName("temp_min")
    private float temp_min;
    @SerializedName("temp_max")
    private float temp_max;
    @SerializedName("main")
    private String main;
    @SerializedName("icon")
    private String icon;
    @SerializedName("speed")
    private float speed;

    public Weather() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
