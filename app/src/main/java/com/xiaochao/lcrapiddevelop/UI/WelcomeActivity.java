package com.xiaochao.lcrapiddevelop.UI;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddevelop.UI.ListvView.ListvViewActivity;


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
