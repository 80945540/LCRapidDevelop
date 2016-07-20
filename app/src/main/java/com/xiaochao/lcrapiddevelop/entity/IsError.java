package com.xiaochao.lcrapiddevelop.entity;

/**
 * Created by Administrator on 2016/4/22.
 */
public class IsError {

    /**
     * TotalCount : 0
     * ReturnedCount : 0
     * Results : []
     * Code : 1002
     * Message : 用户登陆失败
     * Timestamp : 2016-04-22T11:21:11.0918743+08:00
     */

    private int TotalCount;
    private int ReturnedCount;
    private int Code;
    private String Message;
    private String Timestamp;

    public IsError(int totalCount, int returnedCount, int code, String message, String timestamp) {
        TotalCount = totalCount;
        ReturnedCount = returnedCount;
        Code = code;
        Message = message;
        Timestamp = timestamp;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public void setReturnedCount(int ReturnedCount) {
        this.ReturnedCount = ReturnedCount;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }


    public int getTotalCount() {
        return TotalCount;
    }

    public int getReturnedCount() {
        return ReturnedCount;
    }

    public int getCode() {
        return Code;
    }

    public String getMessage() {
        return Message;
    }

    public String getTimestamp() {
        return Timestamp;
    }
}
