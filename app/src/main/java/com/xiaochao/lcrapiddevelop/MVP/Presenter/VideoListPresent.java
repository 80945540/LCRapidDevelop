package com.xiaochao.lcrapiddevelop.MVP.Presenter;

import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.MVP.Model.VideoListModel;
import com.xiaochao.lcrapiddevelop.MVP.View.VideoListView;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class VideoListPresent implements OnLoadDataListListener<List<VideoListDto>> {

    private VideoListView mView;
    private VideoListModel mModel;

    public VideoListPresent(VideoListView mView) {
        this.mView = mView;
        this.mModel=new VideoListModel();
        mView.showProgress();
    }

    public void LoadData(){
        mModel.LoadData(this);
    }

    @Override
    public void onSuccess(List<VideoListDto> data) {
        if(data.size()==0){
           mView.showNoData();
        }else{
            mView.newDatas(data);
        }
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
