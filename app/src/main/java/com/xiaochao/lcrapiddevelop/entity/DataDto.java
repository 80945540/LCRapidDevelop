package com.xiaochao.lcrapiddevelop.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DataDto<T>  {
    private int type;
    private List<T> t;

    public DataDto(int type, List<T> t) {
        this.type = type;
        this.t = t;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }
}
