package com.xiaochao.lcrapiddevelop.Data;

import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/7/20.
 */
public abstract class DataInterface {

    public SuccessListener Success(){
        SuccessListener listener=new SuccessListener() {
            @Override
            public void onResponse(JSONObject response) {
                onMySuccess(response);
            }
        };
       return listener;
    }
    public ErrorListener Error(){
        ErrorListener listener=new ErrorListener() {
            @Override
            public void onResponse() {
                onMyError();
            }
        };
        return listener;
    }
    public  abstract JSONObject onMySuccess(JSONObject response);
    public abstract void onMyError();
    public interface SuccessListener {
        public void onResponse(JSONObject response);
    }
    public interface ErrorListener {
        public void onResponse();
    }
}
