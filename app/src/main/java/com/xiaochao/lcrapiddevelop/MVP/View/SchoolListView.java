package com.xiaochao.lcrapiddevelop.MVP.View;

import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public interface SchoolListView {

    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(List<UniversityListDto> newsList);
    //添加更多数据
    void addDatas(List<UniversityListDto> addList);
    //显示加载失败
    void showLoadFailMsg();
    //显示已加载所有数据
    void showLoadCompleteAllData();
    //显示无数据
    void showNoData();

}
