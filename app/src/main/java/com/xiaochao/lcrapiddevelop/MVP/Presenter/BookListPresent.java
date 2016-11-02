package com.xiaochao.lcrapiddevelop.MVP.Presenter;

import com.xiaochao.lcrapiddevelop.MVP.Model.BookListModel;
import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.MVP.View.BookListView;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class BookListPresent implements OnLoadDataListListener<List<BookListDto>> {
    private BookListView mView;
    private BookListModel mModel;
    private boolean isjz;
    public BookListPresent(BookListView mView) {
        this.mView = mView;
        this.mModel=new BookListModel();
        mView.showProgress();
    }

    public void LoadData(String type,int PageIndex,boolean isjz){
        this.isjz=isjz;
        mModel.LoadData(type,PageIndex,this);
    }

    @Override
    public void onSuccess(List<BookListDto> data) {
        if(isjz){
            if(data.size()==0){
                mView.showLoadCompleteAllData();
            }else{
                //新增自动加载的的数据
                mView.addDatas(data);
            }
        }else{
            if(data.size()==0){
               mView.showNoData();
            }else{
                mView.newDatas(data);
            }
        }
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
