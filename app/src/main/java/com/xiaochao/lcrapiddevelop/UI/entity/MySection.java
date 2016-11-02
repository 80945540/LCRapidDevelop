package com.xiaochao.lcrapiddevelop.UI.entity;

import com.xiaochao.lcrapiddeveloplibrary.entity.SectionEntity;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MySection extends SectionEntity<BookListDto> {
    private boolean isMroe;
    public MySection(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMroe = isMroe;
    }

    public MySection(BookListDto t) {
        super(t);
    }

    public boolean isMroe() {
        return isMroe;
    }

    public void setMroe(boolean mroe) {
        isMroe = mroe;
    }
}
