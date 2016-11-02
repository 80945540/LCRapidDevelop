package com.xiaochao.lcrapiddevelop.UI.entity;

import java.util.List;

/**
 * Created by liukun on 16/3/5.
 */
public class HttpResult<T> {


    /**
     * data : []
     * requestTime : 2016-11-02 14:00:25
     * code : 1
     */

    private String requestTime;
    private int code;
    private T data;

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
