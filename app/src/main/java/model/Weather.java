package model;

import java.io.Serializable;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Weather implements Serializable {
    private int id;
    private String day;
    private String status;
    private String temp;

    public Weather(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Weather(String day, String status, String temp) {
        this.day = day;
        this.status = status;
        this.temp = temp;
    }
}
