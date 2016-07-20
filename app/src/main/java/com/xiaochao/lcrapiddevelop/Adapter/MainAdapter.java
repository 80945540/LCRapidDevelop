package com.xiaochao.lcrapiddevelop.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.MainDateDto;
import com.xiaochao.lcrapiddevelop.transform.GlideCircleTransform;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MainAdapter extends BaseQuickAdapter<MainDateDto> {
    public MainAdapter(int layoutResId, List<MainDateDto> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, MainDateDto item) {
        helper.setText(R.id.tv_title,item.getTitle()+"")
                .setText(R.id.tv_content,item.getInfo()+"");
        //通过Glide显示图片
        Glide.with(mContext)
                .load(item.getImageUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .transform(new GlideCircleTransform(mContext))
                .into((ImageView) helper.getView(R.id.iv_url));
    }
}
