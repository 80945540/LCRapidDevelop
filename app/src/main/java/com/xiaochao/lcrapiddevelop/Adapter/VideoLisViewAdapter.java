package com.xiaochao.lcrapiddevelop.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.VideoListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;
import com.xiaochao.lcrapiddeveloplibrary.Video.JCVideoPlayerStandard;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class VideoLisViewAdapter extends BaseQuickAdapter<VideoListDto> {

    public VideoLisViewAdapter(int layoutResId, List<VideoListDto> data) {
        super(layoutResId, data);
    }

    public VideoLisViewAdapter(List<VideoListDto> data) {
        super(data);
    }

    public VideoLisViewAdapter(View contentView, List<VideoListDto> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoListDto item) {
        helper.setText(R.id.video_list_item_text_title,item.getTitle()).setText(R.id.video_list_item_text_context,item.getIntroduction());
        Glide.with(mContext)
                .load(item.getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .into((ImageView) helper.getView(R.id.video_list_item_image));
        ((JCVideoPlayerStandard)helper.getView(R.id.video_list_item_playr)).setUp(item.getAppVideoUrl(),item.getTitle());
        Glide.with(mContext)
                .load(item.getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.main_mini_m)
                .into((((JCVideoPlayerStandard) helper.getView(R.id.video_list_item_playr)).thumbImageView));
    }
}
