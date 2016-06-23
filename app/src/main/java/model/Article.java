package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Article implements Serializable {
    private int mId;
    private String mContent;
    private String mUrl;

    public Article() {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Article(String mContent, String mUrl) {
        this.mContent = mContent;
        this.mUrl = mUrl;
    }
}
