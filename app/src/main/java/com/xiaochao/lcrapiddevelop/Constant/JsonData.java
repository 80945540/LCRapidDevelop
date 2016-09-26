package com.xiaochao.lcrapiddevelop.Constant;

import com.xiaochao.lcrapiddevelop.UI.entity.MySection;
import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/19.
 */
public class JsonData {
    public static List<MySection> getSampleData(List<UniversityListDto> expertLists,int PageIndex) {
        List<MySection> list = new ArrayList<>();
        if(PageIndex%2==0){
            list.add(new MySection(true, "分组"+PageIndex, false));
        }else{
            list.add(new MySection(true, "分组"+PageIndex, true));
        }
        for (UniversityListDto UniversityListDto:expertLists) {
            list.add(new MySection(UniversityListDto));
        }
        return list;
    }
}
