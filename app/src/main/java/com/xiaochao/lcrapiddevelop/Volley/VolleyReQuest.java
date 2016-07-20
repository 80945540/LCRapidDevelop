package com.xiaochao.lcrapiddevelop.Volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.xiaochao.lcrapiddevelop.MyApplication.MyApplication;
import com.xiaochao.lcrapiddevelop.Util.sysUtil;


import org.json.JSONObject;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


public class VolleyReQuest {
	public static Context context;
	public static JsonObjectRequest jsonObject;

	public static void ReQuestGet(Context context,String url,String tag,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.GET, url, null, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestPost(Context context,String url,String tag,JSONObject json,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.POST,url, json, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestGet_null(Context context,String url,String tag,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.GET, url, null, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestPost_null(Context context,String url,String tag,JSONObject json,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.POST,url, json, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestGet_token(Context context,String url,String tag,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.GET, url, null, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestPost_token(Context context,String url,String tag,JSONObject json,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.POST,url, json, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestGet_token_null(Context context,String url,String tag,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.GET, url, null, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}
	public static void ReQuestPost_token_null(Context context,String url,String tag,JSONObject json,VolleyInterface vif){
		MyApplication.getHttpQueue().cancelAll(tag);
		jsonObject=new JsonObjectRequest(Method.POST,url, json, vif.LoadingLiener(), vif.ErrorListener()){
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
//				headers.put("Authorization", "UCore " + Constant.AccessToken);
				headers.put("YouzyApp_Sign", sysUtil.youzySing());
				headers.put("YouzyApp_FromSource","android-2.61");
				headers.put("YouzyApp_IP", getLocalIpAddress());
				return headers;
			}
		};
		jsonObject.setRetryPolicy(new DefaultRetryPolicy(10000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObject.setTag(tag);
		MyApplication.getHttpQueue().add(jsonObject);
	}

	public static String getLocalIpAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()&& !inetAddress.isLinkLocalAddress()) {
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
			Log.e("VOLLEY", ex.toString());
		}
		return "127.0.0.1(error)";
	}
}
