package com.xiaochao.lcrapiddeveloplibrary.SmartTab.UtilsV4.v4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.xiaochao.lcrapiddeveloplibrary.SmartTab.UtilsV4.PagerItem;


public class FragmentPagerItem extends PagerItem {

  private static final String TAG = "FragmentPagerItem";
  private static final String KEY_POSITION = TAG + ":Position";

  private final String className;
  private final Bundle args;

  protected FragmentPagerItem(CharSequence title, float width, String className, Bundle args) {
    super(title, width);
    this.className = className;
    this.args = args;
  }

  public static FragmentPagerItem of(CharSequence title, Class<? extends Fragment> clazz) {
    return of(title, DEFAULT_WIDTH, clazz);
  }

  public static FragmentPagerItem of(CharSequence title, Class<? extends Fragment> clazz,
                                     Bundle args) {
    return of(title, DEFAULT_WIDTH, clazz, args);
  }

  public static FragmentPagerItem of(CharSequence title, float width,
                                     Class<? extends Fragment> clazz) {
    return of(title, width, clazz, new Bundle());
  }

  public static FragmentPagerItem of(CharSequence title, float width,
                                     Class<? extends Fragment> clazz, Bundle args) {
    return new FragmentPagerItem(title, width, clazz.getName(), args);
  }

  public static boolean hasPosition(Bundle args) {
    return args != null && args.containsKey(KEY_POSITION);
  }

  public static int getPosition(Bundle args) {
    return (hasPosition(args)) ? args.getInt(KEY_POSITION) : 0;
  }

  static void setPosition(Bundle args, int position) {
    args.putInt(KEY_POSITION, position);
  }

  public Fragment instantiate(Context context, int position) {
    setPosition(args, position);
    return Fragment.instantiate(context, className, args);
  }

}
