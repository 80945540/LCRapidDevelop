package com.xiaochao.lcrapiddevelop.MVP.Model;

import com.xiaochao.lcrapiddevelop.Data.HttpData.HttpData;
import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;

import java.util.List;

import rx.Observer;

/**
 * Created by Administrator on 2016/9/26.
 */

public class BookListModel {

    public void LoadData(String type,int PageIndex, final OnLoadDataListListener listener){
        HttpData.getInstance().HttpDataToSchoolList(type, PageIndex, new Observer<List<BookListDto>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                //设置页面为加载错误
                listener.onFailure(e);
            }

            @Override
            public void onNext(List<BookListDto> data) {
                listener.onSuccess(data);
            }
        });
    }
}
