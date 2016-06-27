package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nguyen.hoai.duc on 6/27/2016.
 */
public class ForeCast implements Serializable{
    @SerializedName("main")
    private Main main;
    @SerializedName("dt_txt")
    private String dt;
    @SerializedName("weather")
    private ArrayList<MainStatus> mainStatus;
    @SerializedName("wind")
    private Wind wind;

    public ForeCast(){

    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
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
}
