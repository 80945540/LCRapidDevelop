package com.xiaochao.lcrapiddevelop.UI.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddevelop.Util.GlideCircleTransform;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ListViewAdapter extends BaseQuickAdapter<BookListDto> {
    public ListViewAdapter(int layoutResId, List<BookListDto> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookListDto item) {
        Glide.with(mContext)
                .load(item.getImageUrl())
                .crossFade()
                .placeholder(R.mipmap.nocover)
                .into((ImageView) helper.getView(R.id.book_info_image_url));
        helper.setText(R.id.book_info_textview_name,item.getBookName());
        helper.setText(R.id.book_info_textview_author,item.getAuthor());
        helper.setText(R.id.book_info_textview_introduction,"简介:"+item.getIntroduction());
    }
}
