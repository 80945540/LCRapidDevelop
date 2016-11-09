package com.xiaochao.lcrapiddevelop.Data.APi;

import com.xiaochao.lcrapiddevelop.UI.entity.HttpResult;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API接口
 * 因为使用RxCache作为缓存策略 所以这里不需要写缓存信息
 */
public interface APIService {

    //获取视频地址
    @GET("video/getVideoList")
    Observable<HttpResult<List<VideoListDto>>> getVideoList();

    //根据图书类别获得图书列表
    @GET("api/getTypeBooks")
    Observable<HttpResult<List<BookListDto>>> getBookList(@Query("type")String type, @Query("pageIndex")int pageIndex);
}
