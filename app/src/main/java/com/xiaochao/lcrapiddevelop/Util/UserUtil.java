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
    public static String usergrad(int i){
        String string="";
        switch (i){
            case 1:
                string="高一";
                break;
            case 2:
                string="高二";
                break;
            case 3:
                string="高三";
                break;
        }
        return string;
    }
    public static String toBatch(int Batch){
        switch (Batch){
            case 1:
                return "本一批";
            case 2:
                return "本二批";
            case 3:
                return "本三批";
            case 4:
                return "专科一批";
            case 5:
                return "专科二批";
        }
        return "";
    }
    public static String getReservationDomains(String str){
        String string = "";
        String[] strs=str.split(",");
        for(int i=0;i<strs.length;i++){
            if(i>0) {
                string += "  ";
            }
            switch (strs[i]){
                case "1":
                    string+="志愿填报";
                    break;
                case "2":
                    string+="自主招生";
                    break;
                case "3":
                    string+="高考提分";
                    break;
                case "4":
                    string+="心理减压";
                    break;
                case "7":
                    string+="艺考传媒";
                    break;
                case "8":
                    string+="学业规划";
                    break;
            }
        }
        return string;
    }
    public static String getReservationDomains(String str,String fgf){
        String string = "";
        String[] strs=str.split(",");
        for(int i=0;i<strs.length;i++){
            switch (strs[i]){
                case "1":
                    string+="志愿填报";
                    break;
                case "2":
                    string+="自主招生";
                    break;
                case "3":
                    string+="高考提分";
                    break;
                case "4":
                    string+="心理减压";
                    break;
                case "7":
                    string+="艺考传媒";
                    break;
                case "8":
                    string+="学业规划";
                    break;
            }
            if((i+1)%2==0){
                string+=fgf+fgf;
            }else{
                string+="                       ";
            }

        }
        return string;
    }
    //电话号码去除中间几位数
    public static String userPhone(String string){
        String maskNumber = string.substring(0,3)+"****"+string.substring(7,string.length());
        return maskNumber;
    }
    public static int nian(){
        SimpleDateFormat formatter    =   new SimpleDateFormat("yyyy");
        Date curDate    =   new Date(System.currentTimeMillis());//获取当前时间
        String str    =    formatter.format(curDate);
        return Integer.parseInt(str);
    }
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
    public static String strToString(String string){
        //2015-11-30T14:04:53.543
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string));
        } catch (Exception e) {
            return "";
        }
        return timedata(times(c.getTimeInMillis()));
    }

    public static String time(String time){
        String[] times=time.split("T");
        String[] sj=times[1].split(":");
        return times[0]+"  "+sj[0]+":"+sj[1];
    }
    public static String toReservationDomains(Map<Integer,Integer> ReservationDomains){
        String string="";
        Iterator iter = ReservationDomains.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            string+=entry.getValue() + ",";
        }
        return string;
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
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
