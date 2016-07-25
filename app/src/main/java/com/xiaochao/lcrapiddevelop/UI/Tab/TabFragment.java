package com.xiaochao.lcrapiddevelop.UI.Tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddeveloplibrary.SmartTab.UtilsV4.v4.FragmentPagerItem;

public class TabFragment extends Fragment {

    TextView tabfragmenttextview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View root) {
        tabfragmenttextview = (TextView) root.findViewById(R.id.tab_fragment_textview);
        int position = FragmentPagerItem.getPosition(getArguments());
        tabfragmenttextview.setText(String.valueOf(position));
    }
}
