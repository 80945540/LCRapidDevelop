package com.xiaochao.lcrapiddevelop.Data;

import android.content.Context;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiaochao.lcrapiddevelop.Volley.VolleyInterface;
import com.xiaochao.lcrapiddevelop.Volley.VolleyReQuest;
import com.xiaochao.lcrapiddevelop.entity.IsError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/19.
 */
public class JsonData {

    private static Gson gson;

    public static IsError josnToObj(JSONObject response){
        gson = new Gson();
        try {
            return gson.fromJson(response.toString(),IsError.class);
        } catch (JsonSyntaxException e) {
            return new IsError(0,0,1001,"程序发生未知错误","");
        }
    }
}
