package com.xiaochao.lcrapiddevelop.MVP.View;

import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public interface VideoListView {

    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(List<VideoListDto> newsList);
    //添加更多数据
    void addDatas(List<VideoListDto> addList);
    //显示加载失败
    void showLoadFailMsg();
    //显示已加载所有数据
    void showLoadCompleteAllData();
    //显示无数据
    void showNoData();

}
