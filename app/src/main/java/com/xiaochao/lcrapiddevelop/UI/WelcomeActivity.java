package com.xiaochao.lcrapiddevelop.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.xiaochao.lcrapiddevelop.MyApplication.MyApplication;
import com.xiaochao.lcrapiddevelop.R;

public class WelcomeActivity extends ListvViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
