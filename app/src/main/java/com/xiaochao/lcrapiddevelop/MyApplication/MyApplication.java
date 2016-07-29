package com.xiaochao.lcrapiddevelop.MyApplication;

import android.app.Application;

import com.xiaochao.lcrapiddeveloplibrary.Cache.ACache;

/**
 * Created by Administrator on 2016/7/1.
 */
public class MyApplication extends Application {
    private static ACache mCache;
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        mCache = ACache.get(this);
        this.instance = this;
    }
    /*
	获得缓存类
	 */
    public static ACache getAcache(){
        return mCache;
    }
    public static MyApplication getInstance() {
        return instance;
    }
}
