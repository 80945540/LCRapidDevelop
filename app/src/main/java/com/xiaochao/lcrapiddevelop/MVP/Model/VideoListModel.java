package com.xiaochao.lcrapiddevelop.MVP.Model;

import com.xiaochao.lcrapiddevelop.Data.HttpData.HttpData;
import com.xiaochao.lcrapiddevelop.MVP.Listener.OnLoadDataListListener;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;

import java.util.List;

import rx.Observer;

/**
 * Created by Administrator on 2016/9/26.
 */

public class VideoListModel {

    public void LoadData(final OnLoadDataListListener listener){
        HttpData.getInstance().verfacationCodeGetCache( new Observer<List<VideoListDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onNext(List<VideoListDto> videoListDtos) {
                listener.onSuccess(videoListDtos);
            }
        });
    }
}
