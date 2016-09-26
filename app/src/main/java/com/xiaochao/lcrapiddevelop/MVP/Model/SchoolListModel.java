package com.xiaochao.lcrapiddevelop.MVP.Model;

import com.xiaochao.lcrapiddevelop.Data.HttpData.HttpData;
import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;

import java.util.List;

import rx.Observer;

/**
 * Created by Administrator on 2016/9/26.
 */

public class SchoolListModel {

    public void LoadData(int PageIndex, int PageSize, final OnLoadDataListListener listener){
        HttpData.getInstance().HttpDataToSchoolList(PageIndex, PageSize, new Observer<List<UniversityListDto>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                //设置页面为加载错误
                listener.onFailure(e);
            }

            @Override
            public void onNext(List<UniversityListDto> data) {
                listener.onSuccess(data);
            }
        });
    }
}
