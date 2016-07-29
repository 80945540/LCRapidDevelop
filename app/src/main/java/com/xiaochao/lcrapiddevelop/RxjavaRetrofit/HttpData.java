package com.xiaochao.lcrapiddevelop.RxjavaRetrofit;

import com.xiaochao.lcrapiddevelop.entity.Body.SchoolBody;
import com.xiaochao.lcrapiddevelop.entity.HttpResult;
import com.xiaochao.lcrapiddevelop.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.entity.VideoListDto;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
/*
 *所有的请求数据的方法集中地
 * 根据MovieService的定义编写合适的方法
 */
public class HttpData extends RetrofitUtils {

    protected static final MovieService service = getRetrofit().create(MovieService.class);

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance(){
        return SingletonHolder.INSTANCE;
    }

    //Get请求  视频列表
    public void verfacationCodeGetCache(int pageIndex, int pageSize,Observer<List<VideoListDto>> observer) {
        Observable observable=service.getVideoList(pageIndex, pageSize).map(new HttpResultFunc<List<VideoListDto>>());
        setSubscribe(observable,observer);
    }

    //post请求 学校列表
    public void HttpDataToSchoolList(int pageIndex, int pageSize,Observer<List<UniversityListDto>> observer){
        Observable observable=service.getSchoolList(new SchoolBody("","","","",pageIndex,pageSize)).map(new HttpResultFunc<List<UniversityListDto>>());
        setSubscribe(observable,observer);
    }

    /**
     * 插入观察者
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private  class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {

                if (httpResult.getCode() !=1 ) {
                    throw new ApiException(httpResult);
                }

            return httpResult.getResults();
        }
    }

}
