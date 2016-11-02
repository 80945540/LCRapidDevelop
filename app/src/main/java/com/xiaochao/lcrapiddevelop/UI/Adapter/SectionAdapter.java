package com.xiaochao.lcrapiddevelop.UI.Adapter;



import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.entity.MySection;
import com.xiaochao.lcrapiddevelop.UI.entity.BookListDto;
import com.xiaochao.lcrapiddevelop.Util.GlideCircleTransform;
import com.xiaochao.lcrapiddeveloplibrary.BaseSectionQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection> {

    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super( layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more,item.isMroe());
        helper.setOnClickListener(R.id.more,new OnItemChildClickListener());
    }


    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        BookListDto video = (BookListDto) item.t;
        Glide.with(mContext)
                .load(video.getImageUrl())
                .crossFade()
                .placeholder(R.mipmap.nocover)
                .into((ImageView) helper.getView(R.id.book_info_image_url));
        helper.setText(R.id.book_info_textview_name,video.getBookName());
        helper.setText(R.id.book_info_textview_author,video.getAuthor());
        helper.setText(R.id.book_info_textview_introduction,"简介:"+video.getIntroduction());
    }
}
