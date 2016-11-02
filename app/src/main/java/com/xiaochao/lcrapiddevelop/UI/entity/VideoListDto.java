package com.xiaochao.lcrapiddevelop.UI.entity;

/**
 * Created by Administrator on 2016/5/3.
 */
public class VideoListDto {

    /**
     * pictureUrl : http://img1.youzy.cn/content/media/thumbs/p00188299.jpeg
     * title : 高考如何备考及大幅提分
     * introduction : 程老师结合多年高考备考指导经验，为考生精心讲授快速提高考分的方法，以及如何提高上课效率及做作业效率，科学制定学习计划，大幅提高考分的考前复习妙法等。",
     程老师结合多年高考备考指导经验，为考生精心讲授快速提高考分的方法，以及如何提高上课效率及做作业效率，科学制定学习计划，大幅提高考分的考前复习妙法等。",
     程老师结合多年高考备考指导经验，为考生精心讲授快速提高考分的方法，以及如何提高上课效率及做作业效率，科学制定学习计划，大幅提高考分的考前复习妙法等。
     * viodeoUrl : http://200000455.vod.myqcloud.com/200000455_257c0a4c0b7411e6a480af2c82dfb2fb.f20.mp4
     * id : 1
     */

    private String pictureUrl;
    private String title;
    private String introduction;
    private String viodeoUrl;
    private int id;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getViodeoUrl() {
        return viodeoUrl;
    }

    public void setViodeoUrl(String viodeoUrl) {
        this.viodeoUrl = viodeoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
