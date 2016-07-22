package com.xiaochao.lcrapiddevelop.Volley;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public abstract class VolleyInterface {
	public static Listener<JSONObject> mLisener;
	public static ErrorListener mErrorLisener;
	public VolleyInterface(Listener<JSONObject> mLisener,
			ErrorListener mErrorLisener) {
		super();
		this.mLisener = mLisener;
		this.mErrorLisener = mErrorLisener;
	}
	public Listener<JSONObject> LoadingLiener(){
		mLisener=new Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {

				onMySuccess(response);
			}
		};
		return mLisener;
		
	}
	public ErrorListener ErrorListener(){
		mErrorLisener=new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				onMyError(error);
			}
		};
		return mErrorLisener;	
	}
	public  abstract void onMySuccess(JSONObject response);
	public abstract void onMyError(VolleyError error);
}
