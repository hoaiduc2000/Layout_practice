package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nguyen.hoai.duc on 6/22/2016.
 */
public class Article implements Serializable {
    private int id;
    private String content;
    private String url;

    public Article(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Article(String content, String url) {
        this.content = content;
        this.url = url;
    }
}
