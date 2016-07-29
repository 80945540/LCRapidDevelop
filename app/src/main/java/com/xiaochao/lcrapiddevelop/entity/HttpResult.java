package com.xiaochao.lcrapiddevelop.entity;

/**
 * Created by liukun on 16/3/5.
 */
public class HttpResult<T> {


    /**
     * TotalCount : 11
     * ReturnedCount : 1
     * Results :
     * Code : 1
     * Message :
     * Timestamp : 2016-07-28T10:50:31.116761+08:00
     */

    private int TotalCount;
    private int ReturnedCount;
    private T Results;
    private int Code;
    private String Message;
    private String Timestamp;

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public int getReturnedCount() {
        return ReturnedCount;
    }

    public void setReturnedCount(int ReturnedCount) {
        this.ReturnedCount = ReturnedCount;
    }

    public T getResults() {
        return Results;
    }

    public void setResults(T Results) {
        this.Results = Results;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "TotalCount=" + TotalCount +
                ", ReturnedCount=" + ReturnedCount +
                ", Results=" + Results +
                ", Code=" + Code +
                ", Message='" + Message + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                '}';
    }
}
