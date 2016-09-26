package com.xiaochao.lcrapiddevelop.UI.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.entity.UniversityListDto;
import com.xiaochao.lcrapiddevelop.Util.GlideCircleTransform;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ListViewAdapter extends BaseQuickAdapter<UniversityListDto> {
    public ListViewAdapter(int layoutResId, List<UniversityListDto> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UniversityListDto item) {
        helper.setText(R.id.listview_tv_title,item.getCnName()).setText(R.id.listview_tv_content,"热度:"+item.getHits());
        Glide.with(mContext)
                .load(item.getLogo().getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .transform(new GlideCircleTransform(mContext))
                .into((ImageView) helper.getView(R.id.listview_image_url));
    }
}
