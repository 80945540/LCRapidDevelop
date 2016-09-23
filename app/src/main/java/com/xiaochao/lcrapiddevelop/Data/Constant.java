package com.xiaochao.lcrapiddevelop.Data;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Constant {

    public static String  ERROR_TITLE="网络连接异常";
    public static String  ERROR_CONTEXT="请检查网络后重试";
    public static String  ERROR_BUTTON="重试";

    public static String EMPTY_TITLE="没有找到数据";
    public static String EMPTY_CONTEXT="换个条件试试吧";

    //服务器路径
    public static final String API_SERVER = "http://123.59.57.18:8018";

    //设缓存有效期为7天
    public static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，使用缓存
    public static final String CACHE_CONTROL_CACHE = "max-age=" + CACHE_STALE_SEC;
}
