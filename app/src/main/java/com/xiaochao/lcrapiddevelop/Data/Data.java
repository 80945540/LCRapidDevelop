package com.xiaochao.lcrapiddevelop.Data;

import com.xiaochao.lcrapiddevelop.entity.ChatDto;
import com.xiaochao.lcrapiddevelop.entity.MainDateDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class Data {
    public static String[] MAIN_TITLE={"常见ListView显示","常见分组ListView显示","常见GridView显示","多布局Listview显示","Tab+Fragment快速实现"};
    public static String[] MAIN_INFO={"数据加载页,无数据页,网络错误页\n包含下拉刷新,自动加载,图片显示及缓存\n本页菜单可切换下拉刷新",
            "数据加载页,无数据页,网络错误页\n包含下拉刷新,自动加载,图片显示及缓存\n本页菜单可切换加载动画",
            "常见GridView显示\n包含下拉刷新,自动加载,图片显示及缓存\n数据加载页,无数据页,网络错误页",
            "多布局ListView显示\n同一个ListView里面不同Item根据需求使用不同布局\n高效,简便","Tab+Fragment快速实现\nTab动画效果,ViewPagerg管理\n可根据XML的属性设置自己想要的风格"};
    public static String[] MAIN_IMAGE_URL={"http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=9b8f4fa4da33c895a62b907fe4235fc6/0823dd54564e925845a2bedd9f82d158ccbf4e6a.jpg",
    "http://f.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=f6a651714c4a20a4314b34c3a562b414/a50f4bfbfbedab64b6ff44a3f436afc378311ec7.jpg",
    "http://d.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=27d514408cb1cb133e3c3415ed647a76/b7003af33a87e95026578cc311385343faf2b4d8.jpg",
    "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3229897698,2043497950&fm=21&gp=0.jpg",
    "http://img4.imgtn.bdimg.com/it/u=2007293974,2893395526&fm=11&gp=0.jpg"};
    public static String CHAT_DATA_TEXT="欢迎您下载Android快速开发框架Demo,框架持续更新中,有兴趣的同学可以在GITHUB和我一起完善这个项目,如果您有什么更好的想法和意见您也可以与我联系!!!!!!!!!!";
    public static String CHAT_DATA_URL="http://d.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=27d514408cb1cb133e3c3415ed647a76/b7003af33a87e95026578cc311385343faf2b4d8.jpg";


    public static List<MainDateDto> getData(){
        List<MainDateDto> data=new ArrayList<MainDateDto>();
        for(int i=0;i<MAIN_TITLE.length;i++){
            data.add(new MainDateDto(MAIN_TITLE[i],MAIN_INFO[i],MAIN_IMAGE_URL[i]));
        }
        return data;
    }
    public static List<ChatDto> getMultipleItemData() {
        List<ChatDto> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            if(i%2==0){
                ChatDto multipleItem = new ChatDto(CHAT_DATA_TEXT,"");
                multipleItem.setItemType(ChatDto.TEXT);
                list.add(multipleItem);
            }else if(i%3==0){
                ChatDto multipleItem = new ChatDto("",MAIN_IMAGE_URL[0]);
                multipleItem.setItemType(ChatDto.IMG);
                list.add(multipleItem);
            }else{
                ChatDto multipleItem = new ChatDto(CHAT_DATA_TEXT,MAIN_IMAGE_URL[0]);
                multipleItem.setItemType(ChatDto.IMGS);
                list.add(multipleItem);
            }
        }
        return list;
    }
}
