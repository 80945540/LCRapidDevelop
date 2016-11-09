package com.xiaochao.lcrapiddevelop.Data.HttpData;

import com.xiaochao.lcrapiddevelop.Data.APi.CacheProviders;
import com.xiaochao.lcrapiddevelop.Data.APi.APIService;
import com.xiaochao.lcrapiddevelop.Data.Retrofit.ApiException;
import com.xiaochao.lcrapiddevelop.Data.Retrofit.RetrofitUtils;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddevelop.UI.entity.HttpResult;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;
import com.xiaochao.lcrapiddevelop.Util.FileUtil;

import java.io.File;
import java.util.List;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
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

    private static File cacheDirectory = FileUtil.getcacheDirectory();
    private static final CacheProviders providers = new RxCache.Builder()
            .persistence(cacheDirectory)
            .using(CacheProviders.class);

    protected static final APIService service = getRetrofit().create(APIService.class);


    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance(){
        return SingletonHolder.INSTANCE;
    }

    //Get请求  视频列表
    public void verfacationCodeGetCache(Observer<List<VideoListDto>> observer) {
        Observable observable=service.getVideoList().map(new HttpResultFunc<List<VideoListDto>>());
        Observable observableCahce=providers.getVideoList(observable,new DynamicKey("视频列表"),new EvictDynamicKey(false)).map(new HttpResultFuncCcche<List<VideoListDto>>());
        setSubscribe(observableCahce,observer);
    }

    //post请求 学校列表
    public void HttpDataToSchoolList(String type,int pageIndex,Observer<List<BookListDto>> observer){
        Observable observable=service.getBookList(type,pageIndex).map(new HttpResultFunc<List<BookListDto>>());
        Observable observableCahce=providers.getBookList(observable,new DynamicKey("书籍列表"+pageIndex+type),new EvictDynamicKey(false)).map(new HttpResultFuncCcche<List<BookListDto>>());
        setSubscribe(observableCahce,observer);
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

            return httpResult.getData();
        }
    }
    /**
     * 用来统一处理RxCacha的结果
     */
    private  class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {

        @Override
        public T call(Reply<T> httpResult) {
            return httpResult.getData();
        }
    }
}
