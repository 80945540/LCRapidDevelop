package com.xiaochao.lcrapiddeveloplibrary.SmartTab.UtilsV4;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class ViewPagerItems extends PagerItems<ViewPagerItem> {

  public ViewPagerItems(Context context) {
    super(context);
  }

  public static Creator with(Context context) {
    return new Creator(context);
  }

  public static class Creator {

    private final ViewPagerItems items;

    public Creator(Context context) {
      items = new ViewPagerItems(context);
    }

    public Creator add(@StringRes int title, @LayoutRes int resource) {
      return add(ViewPagerItem.of(items.getContext().getString(title), resource));
    }

    public Creator add(@StringRes int title, float width, @LayoutRes int resource) {
      return add(ViewPagerItem.of(items.getContext().getString(title), width, resource));
    }

    public Creator add(CharSequence title, @LayoutRes int resource) {
      return add(ViewPagerItem.of(title, resource));
    }

    public Creator add(ViewPagerItem item) {
      items.add(item);
      return this;
    }

    public ViewPagerItems create() {
      return items;
    }

  }

}
