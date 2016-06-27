package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nguyen.hoai.duc on 6/27/2016.
 */
public class Wind implements Serializable {
    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private float deg;

    public Wind() {

    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }
}
