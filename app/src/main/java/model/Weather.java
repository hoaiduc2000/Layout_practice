package model;

import java.io.Serializable;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Weather implements Serializable {
    private int mId;
    private String mDay;
    private String mStatus;
    private String mTemp;

    public Weather() {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmTemp() {
        return mTemp;
    }

    public void setmTemp(String mTemp) {
        this.mTemp = mTemp;
    }

    public Weather(String mDay, String mStatus, String mTemp) {
        this.mDay = mDay;
        this.mStatus = mStatus;
        this.mTemp = mTemp;
    }
}
