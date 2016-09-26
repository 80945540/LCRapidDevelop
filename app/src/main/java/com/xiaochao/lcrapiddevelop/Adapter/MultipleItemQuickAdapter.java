package com.xiaochao.lcrapiddevelop.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.entity.ChatDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseMultiItemQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<ChatDto> {

    public MultipleItemQuickAdapter(Context context, List data) {
        super( data);
        addItemType(ChatDto.TEXT, R.layout.chat_text_layout);
        addItemType(ChatDto.IMG, R.layout.chat_img_layout);
        addItemType(ChatDto.IMGS, R.layout.chat_imgs_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatDto item) {
        switch (helper.getItemViewType()) {
            case ChatDto.TEXT:
                helper.setText(R.id.text_context, item.getTextContext());
                break;
            case ChatDto.IMG:
                Glide.with(mContext)
                        .load(item.getTextContext())
                        .crossFade()
                        .crossFade()
                        .placeholder(R.drawable.timg1)
                        .into((ImageView) helper.getView(R.id.img_imageview));
                break;
            case ChatDto.IMGS:
                Glide.with(mContext)
                        .load(item.getTextContext())
                        .crossFade()
                        .placeholder(R.drawable.timg)
                        .into((ImageView) helper.getView(R.id.imgs_imageview));
                helper.setText(R.id.imgs_textview, item.getTextContext());
                break;
        }
    }
}
