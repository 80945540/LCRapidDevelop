package com.xiaochao.lcrapiddevelop.RxjavaRetrofit;

import com.xiaochao.lcrapiddevelop.Data.Constant;
import com.xiaochao.lcrapiddevelop.entity.Body.SchoolBody;
import com.xiaochao.lcrapiddevelop.entity.HttpResult;
import com.xiaochao.lcrapiddevelop.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.entity.VideoListDto;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liukun on 16/3/9.
 */
public interface MovieService{

    //获取视频地址
    @Headers("Cache-Control: public," + Constant.CACHE_CONTROL_CACHE)
    @GET("classroom/getHotVideos")
    Observable<HttpResult<List<VideoListDto>>> getVideoList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    //获取学校列表
    @POST("Colleges/getCollegeList")
    Observable<HttpResult<List<UniversityListDto>>> getSchoolList(@Body SchoolBody schoolBody);

}
