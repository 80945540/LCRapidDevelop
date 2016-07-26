package com.xiaochao.lcrapiddevelop.entity;

/**
 * Created by Administrator on 2016/5/3.
 */
public class VideoListDto {

    /**
     * VideoObjectId : 6
     * Title : 优志愿高考志愿填报系统使用说明
     * VideoItemCount : 2
     * PictureId : 190551
     * PictureUrl : http://img1.youzy.cn/content/media/thumbs/p00190551.png
     * Time :
     * Hit : 23971
     * IsTop : true
     * Price : 0
     * DiscountPrice : 0
     * BuyCount : 0
     * Tags : 优志愿
     * GiveGoodCount : 0
     * ReviewCount : 7
     * VideoType : 志愿课堂
     * Introduction : 优志愿高考志愿填报导航系统，大数据实现精准志愿填报，找大学、查专业、测性格、院校智能推荐等优质功能帮助您用最经济的分数，考上最理想的大学和专业！
     * Status : true
     * Description :
     * IsFree : true
     * IsFreeDemo : false
     * CreationTime : 2016-04-19T09:18:04
     * Picture : {"PictureId":190551,"PictureUrl":"http://img1.youzy.cn/content/media/thumbs/p00190551.png","ThumbUrl":"","SquareUrl":""}
     * VideoObject : {"TypeId":1,"Name":"优志愿","IsTop":false,"GiveGoodCount":30,"PictureId":175632,"PictureUrl":"http://img1.youzy.cn/content/media/thumbs/p00175632.jpeg","Introduction":"专注高考志愿模拟填报服务，助力考生以最经济的分数，上最理想的大学！","CreationTime":"2015-10-23T18:42:14","Picture":{"PictureId":175632,"PictureUrl":"http://img1.youzy.cn/content/media/thumbs/p00175632.jpeg","ThumbUrl":"","SquareUrl":""},"RedirectUrl":"","Id":6}
     * AppVideoUrl : http://200000455.vod.myqcloud.com/200000455_6f4a8e3cfd6e11e5b081e1dcc0c65450.f20.mp4
     * Id : 338
     */

    private int VideoObjectId;
    private String Title;
    private int VideoItemCount;
    private int PictureId;
    private String PictureUrl;
    private String Time;
    private int Hit;
    private boolean IsTop;
    private int Price;
    private int DiscountPrice;
    private int BuyCount;
    private String Tags;
    private int GiveGoodCount;
    private int ReviewCount;
    private String VideoType;
    private String Introduction;
    private boolean Status;
    private String Description;
    private boolean IsFree;
    private boolean IsFreeDemo;
    private String CreationTime;
    /**
     * PictureId : 190551
     * PictureUrl : http://img1.youzy.cn/content/media/thumbs/p00190551.png
     * ThumbUrl :
     * SquareUrl :
     */

    private PictureEntity Picture;
    /**
     * TypeId : 1
     * Name : 优志愿
     * IsTop : false
     * GiveGoodCount : 30
     * PictureId : 175632
     * PictureUrl : http://img1.youzy.cn/content/media/thumbs/p00175632.jpeg
     * Introduction : 专注高考志愿模拟填报服务，助力考生以最经济的分数，上最理想的大学！
     * CreationTime : 2015-10-23T18:42:14
     * Picture : {"PictureId":175632,"PictureUrl":"http://img1.youzy.cn/content/media/thumbs/p00175632.jpeg","ThumbUrl":"","SquareUrl":""}
     * RedirectUrl :
     * Id : 6
     */

    private VideoObjectEntity VideoObject;
    private String AppVideoUrl;
    private int Id;

    public void setVideoObjectId(int VideoObjectId) {
        this.VideoObjectId = VideoObjectId;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setVideoItemCount(int VideoItemCount) {
        this.VideoItemCount = VideoItemCount;
    }

    public void setPictureId(int PictureId) {
        this.PictureId = PictureId;
    }

    public void setPictureUrl(String PictureUrl) {
        this.PictureUrl = PictureUrl;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setHit(int Hit) {
        this.Hit = Hit;
    }

    public void setIsTop(boolean IsTop) {
        this.IsTop = IsTop;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setDiscountPrice(int DiscountPrice) {
        this.DiscountPrice = DiscountPrice;
    }

    public void setBuyCount(int BuyCount) {
        this.BuyCount = BuyCount;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public void setGiveGoodCount(int GiveGoodCount) {
        this.GiveGoodCount = GiveGoodCount;
    }

    public void setReviewCount(int ReviewCount) {
        this.ReviewCount = ReviewCount;
    }

    public void setVideoType(String VideoType) {
        this.VideoType = VideoType;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setIsFree(boolean IsFree) {
        this.IsFree = IsFree;
    }

    public void setIsFreeDemo(boolean IsFreeDemo) {
        this.IsFreeDemo = IsFreeDemo;
    }

    public void setCreationTime(String CreationTime) {
        this.CreationTime = CreationTime;
    }

    public void setPicture(PictureEntity Picture) {
        this.Picture = Picture;
    }

    public void setVideoObject(VideoObjectEntity VideoObject) {
        this.VideoObject = VideoObject;
    }

    public void setAppVideoUrl(String AppVideoUrl) {
        this.AppVideoUrl = AppVideoUrl;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getVideoObjectId() {
        return VideoObjectId;
    }

    public String getTitle() {
        return Title;
    }

    public int getVideoItemCount() {
        return VideoItemCount;
    }

    public int getPictureId() {
        return PictureId;
    }

    public String getPictureUrl() {
        return PictureUrl;
    }

    public String getTime() {
        return Time;
    }

    public int getHit() {
        return Hit;
    }

    public boolean isIsTop() {
        return IsTop;
    }

    public int getPrice() {
        return Price;
    }

    public int getDiscountPrice() {
        return DiscountPrice;
    }

    public int getBuyCount() {
        return BuyCount;
    }

    public String getTags() {
        return Tags;
    }

    public int getGiveGoodCount() {
        return GiveGoodCount;
    }

    public int getReviewCount() {
        return ReviewCount;
    }

    public String getVideoType() {
        return VideoType;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public boolean isStatus() {
        return Status;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isIsFree() {
        return IsFree;
    }

    public boolean isIsFreeDemo() {
        return IsFreeDemo;
    }

    public String getCreationTime() {
        return CreationTime;
    }

    public PictureEntity getPicture() {
        return Picture;
    }

    public VideoObjectEntity getVideoObject() {
        return VideoObject;
    }

    public String getAppVideoUrl() {
        return AppVideoUrl;
    }

    public int getId() {
        return Id;
    }

    public static class PictureEntity {
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

    public static class VideoObjectEntity {
        private int TypeId;
        private String Name;
        private boolean IsTop;
        private int GiveGoodCount;
        private int PictureId;
        private String PictureUrl;
        private String Introduction;
        private String CreationTime;
        /**
         * PictureId : 175632
         * PictureUrl : http://img1.youzy.cn/content/media/thumbs/p00175632.jpeg
         * ThumbUrl :
         * SquareUrl :
         */

        private PictureEntity Picture;
        private String RedirectUrl;
        private int Id;

        public void setTypeId(int TypeId) {
            this.TypeId = TypeId;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setIsTop(boolean IsTop) {
            this.IsTop = IsTop;
        }

        public void setGiveGoodCount(int GiveGoodCount) {
            this.GiveGoodCount = GiveGoodCount;
        }

        public void setPictureId(int PictureId) {
            this.PictureId = PictureId;
        }

        public void setPictureUrl(String PictureUrl) {
            this.PictureUrl = PictureUrl;
        }

        public void setIntroduction(String Introduction) {
            this.Introduction = Introduction;
        }

        public void setCreationTime(String CreationTime) {
            this.CreationTime = CreationTime;
        }

        public void setPicture(PictureEntity Picture) {
            this.Picture = Picture;
        }

        public void setRedirectUrl(String RedirectUrl) {
            this.RedirectUrl = RedirectUrl;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getTypeId() {
            return TypeId;
        }

        public String getName() {
            return Name;
        }

        public boolean isIsTop() {
            return IsTop;
        }

        public int getGiveGoodCount() {
            return GiveGoodCount;
        }

        public int getPictureId() {
            return PictureId;
        }

        public String getPictureUrl() {
            return PictureUrl;
        }

        public String getIntroduction() {
            return Introduction;
        }

        public String getCreationTime() {
            return CreationTime;
        }

        public PictureEntity getPicture() {
            return Picture;
        }

        public String getRedirectUrl() {
            return RedirectUrl;
        }

        public int getId() {
            return Id;
        }

        public static class PictureEntity {
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
}
