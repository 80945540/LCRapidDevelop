package com.xiaochao.lcrapiddevelop.UI.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.entity.VideoListDto;
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
        //Glide加载图片  并且支持gif动图
        Glide.with(mContext)
                .load(item.getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.def_head)
                .into((ImageView) helper.getView(R.id.video_list_item_image));
        //对视频的赋值 添加视频播放地址(使用原地址  .mp4之类的  这个要注意)和标题
        ((JCVideoPlayerStandard)helper.getView(R.id.video_list_item_playr)).setUp(item.getViodeoUrl(),item.getTitle());
        Glide.with(mContext)
                .load(item.getPictureUrl())
                .crossFade()
                .placeholder(R.mipmap.main_mini_m)
                .into((((JCVideoPlayerStandard) helper.getView(R.id.video_list_item_playr)).thumbImageView));
    }
}
