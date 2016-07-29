package com.xiaochao.lcrapiddevelop.Util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/1.
 */
public class UserUtil {
    public static String times(){
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate    =   new Date(System.currentTimeMillis());//获取当前时间
        String str    =    formatter.format(curDate);
        return str;
    }
    public static String times(long time){
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate    =   new Date(time);//获取当前时间
        String str    =    formatter.format(curDate);
        return str;
    }
    /*
        时间换算
         */
    public static String timedata(String time){
        //2015/11/6 10:05:52
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format_info = new SimpleDateFormat("MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
            c.setTime(date);
            long times= System.currentTimeMillis()-c.getTimeInMillis();
            if(times>60*60*24*1000){
                if((times/(60*60*24*1000))>9){
                    return format.format(c.getTimeInMillis()).split(" ")[0];
                }else{
                    return (times/(60*60*24*1000))+"天前";
                }
            }else if(times>60*60*1000){
                return (times/(60*60*1000))+"小时前";
            }else if(times>60*1000){
                return (times/(60*1000))+"分钟前";
            }else{
                return "刚刚";
            }
        } catch (Exception e) {
            return "未知";
        }
    }
}
