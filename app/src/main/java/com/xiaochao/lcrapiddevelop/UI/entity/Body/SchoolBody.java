package com.xiaochao.lcrapiddevelop.UI.entity.Body;

/**
 * Created by Administrator on 2016/7/29.
 */
public class SchoolBody {

    public SchoolBody(String provinceIds, String classify, String collegeLevel, String isBen, int pageIndex, int pageSize) {
        ProvinceIds = provinceIds;
        Classify = classify;
        CollegeLevel = collegeLevel;
        IsBen = isBen;
        PageIndex = pageIndex;
        PageSize = pageSize;
    }

    /**
     * ProvinceIds :
     * Classify :
     * CollegeLevel :
     * IsBen :
     * PageIndex : 1
     * PageSize : 6
     */

    private String ProvinceIds;
    private String Classify;
    private String CollegeLevel;
    private String IsBen;
    private int PageIndex;
    private int PageSize;

    public String getProvinceIds() {
        return ProvinceIds;
    }

    public void setProvinceIds(String ProvinceIds) {
        this.ProvinceIds = ProvinceIds;
    }

    public String getClassify() {
        return Classify;
    }

    public void setClassify(String Classify) {
        this.Classify = Classify;
    }

    public String getCollegeLevel() {
        return CollegeLevel;
    }

    public void setCollegeLevel(String CollegeLevel) {
        this.CollegeLevel = CollegeLevel;
    }

    public String getIsBen() {
        return IsBen;
    }

    public void setIsBen(String IsBen) {
        this.IsBen = IsBen;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }
}
