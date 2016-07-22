package com.xiaochao.lcrapiddevelop.MyApplication;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.xiaochao.lcrapiddeveloplibrary.Cache.ACache;

/**
 * Created by Administrator on 2016/7/1.
 */
public class MyApplication extends Application {
    private static RequestQueue queue;
    private static ACache mCache;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
        mCache = ACache.get(this);
    }
    public static RequestQueue getHttpQueue(){
        return queue;
    }
    /*
	获得缓存类
	 */
    public static ACache getAcache(){
        return mCache;
    }
}
