package com.xiaochao.lcrapiddevelop.UI.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class UniversityListDto implements Serializable {

    /**
     * CollegeId : 838
     * CnName : 北京大学
     * Levevs : ["211","985"]
     * Logo : {"PictureId":189371,"PictureUrl":"http://img1.youzy.cn/content/media/thumbs/p00189371.jpeg","ThumbUrl":"","SquareUrl":""}
     * Hits : 200704
     * RankOfCn : 5
     * RankOfCnClassify : 0
     * RankOfWorld : 0
     */

    private int CollegeId;
    private String CnName;
    /**
     * PictureId : 189371
     * PictureUrl : http://img1.youzy.cn/content/media/thumbs/p00189371.jpeg
     * ThumbUrl :
     * SquareUrl :
     */

    private LogoEntity Logo;
    private int Hits;
    private int RankOfCn;
    private int RankOfCnClassify;
    private int RankOfWorld;
    private List<String> Levevs;

    public void setCollegeId(int CollegeId) {
        this.CollegeId = CollegeId;
    }

    public void setCnName(String CnName) {
        this.CnName = CnName;
    }

    public void setLogo(LogoEntity Logo) {
        this.Logo = Logo;
    }

    public void setHits(int Hits) {
        this.Hits = Hits;
    }

    public void setRankOfCn(int RankOfCn) {
        this.RankOfCn = RankOfCn;
    }

    public void setRankOfCnClassify(int RankOfCnClassify) {
        this.RankOfCnClassify = RankOfCnClassify;
    }

    public void setRankOfWorld(int RankOfWorld) {
        this.RankOfWorld = RankOfWorld;
    }

    public void setLevevs(List<String> Levevs) {
        this.Levevs = Levevs;
    }

    public int getCollegeId() {
        return CollegeId;
    }

    public String getCnName() {
        return CnName;
    }

    public LogoEntity getLogo() {
        return Logo;
    }

    public int getHits() {
        return Hits;
    }

    public int getRankOfCn() {
        return RankOfCn;
    }

    public int getRankOfCnClassify() {
        return RankOfCnClassify;
    }

    public int getRankOfWorld() {
        return RankOfWorld;
    }

    public List<String> getLevevs() {
        return Levevs;
    }

    public static class LogoEntity implements Serializable {
        private int PictureId;
        private String PictureUrl;
        private String ThumbUrl;
        private String SquareUrl;

        public void setPictureId(int PictureId) {
            this.PictureId = PictureId;
        }

        public void setPictureUrl(String PictureUrl) {
            this.PictureUrl = PictureUrl;
        }

        public void setThumbUrl(String ThumbUrl) {
            this.ThumbUrl = ThumbUrl;
        }

        public void setSquareUrl(String SquareUrl) {
            this.SquareUrl = SquareUrl;
        }

        public int getPictureId() {
            return PictureId;
        }

        public String getPictureUrl() {
            return PictureUrl;
        }

        public String getThumbUrl() {
            return ThumbUrl;
        }

        public String getSquareUrl() {
            return SquareUrl;
        }
    }
}
