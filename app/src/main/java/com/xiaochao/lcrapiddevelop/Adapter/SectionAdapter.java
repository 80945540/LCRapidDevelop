package com.xiaochao.lcrapiddevelop.Adapter;



import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.MySection;
import com.xiaochao.lcrapiddevelop.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.transform.GlideCircleTransform;
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
        UniversityListDto video = (UniversityListDto) item.t;
        helper.setText(R.id.listview_tv_title,video.getCnName()).setText(R.id.listview_tv_content,"热度:"+video.getHits());
        Glide.with(mContext)
                .load(video.getLogo().getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .transform(new GlideCircleTransform(mContext))
                .into((ImageView) helper.getView(R.id.listview_image_url));
    }
}
