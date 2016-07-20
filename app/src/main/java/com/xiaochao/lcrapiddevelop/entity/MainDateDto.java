package com.xiaochao.lcrapiddevelop.entity;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MainDateDto {
    private String title;
    private String info;
    private String imageUrl;

    public MainDateDto(String title, String info, String imageUrl) {
        this.title = title;
        this.info = info;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
