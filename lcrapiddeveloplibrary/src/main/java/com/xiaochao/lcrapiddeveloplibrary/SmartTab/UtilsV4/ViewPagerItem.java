package com.xiaochao.lcrapiddeveloplibrary.SmartTab.UtilsV4;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerItem extends PagerItem {

  private final int resource;

  protected ViewPagerItem(CharSequence title, float width, @LayoutRes int resource) {
    super(title, width);
    this.resource = resource;
  }

  public static ViewPagerItem of(CharSequence title, @LayoutRes int resource) {
    return of(title, DEFAULT_WIDTH, resource);
  }

  public static ViewPagerItem of(CharSequence title, float width, @LayoutRes int resource) {
    return new ViewPagerItem(title, width, resource);
  }

  public View initiate(LayoutInflater inflater, ViewGroup container) {
    return inflater.inflate(resource, container, false);
  }

}
