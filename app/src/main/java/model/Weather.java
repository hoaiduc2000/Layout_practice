package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Weather implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("main")
    private Main main;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("weather")
    private ArrayList<MainStatus> mainStatus;
    public Weather() {

    }
    public ArrayList<MainStatus> getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(ArrayList<MainStatus> mainStatus) {
        this.mainStatus = mainStatus;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
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

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
