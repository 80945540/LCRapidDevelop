package com.xiaochao.lcrapiddevelop.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xiaochao.lcrapiddevelop.Adapter.MultipleItemQuickAdapter;
import com.xiaochao.lcrapiddevelop.Constant.Data;
import com.xiaochao.lcrapiddevelop.R;

public class ChatLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(this, Data.getMultipleItemData());
        mRecyclerView.setAdapter(multipleItemAdapter);
    }
}
