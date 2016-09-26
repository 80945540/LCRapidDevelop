package com.xiaochao.lcrapiddevelop.MVP.Presenter;

import com.xiaochao.lcrapiddevelop.MVP.Model.SchoolListModel;
import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.MVP.View.SchoolListView;
import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class SchoolListPresent implements OnLoadDataListListener<List<UniversityListDto>> {
    private SchoolListView mView;
    private SchoolListModel mModel;
    private boolean isjz;
    public SchoolListPresent(SchoolListView mView) {
        this.mView = mView;
        this.mModel=new SchoolListModel();
    }

    public void LoadData(int PageIndex, int PageSize,boolean isjz){
        this.isjz=isjz;
        mModel.LoadData(PageIndex,PageSize,this);
        if(!isjz){
            mView.showProgress();
        }
    }

    @Override
    public void onSuccess(List<UniversityListDto> data) {
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
