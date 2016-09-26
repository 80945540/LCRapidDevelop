package com.xiaochao.lcrapiddevelop.Util;

import android.util.Log;

import com.xiaochao.lcrapiddevelop.MyApplication.MyApplication;

import java.io.File;

/**
 * 文件工具类
 *
 */
public class FileUtil {
	/**
	 * @return  创建缓存目录
	 */
	public static File getcacheDirectory()
	{
		File file = new File(MyApplication.getInstance().getApplicationContext().getExternalCacheDir(), "MyCache");
		if(!file.exists())
		{
			boolean b = file.mkdirs();
			Log.e("file", "文件不存在  创建文件    "+b);
		}else{
			Log.e("file", "文件存在"+file.toString());
		}
		return file;
	}
}
