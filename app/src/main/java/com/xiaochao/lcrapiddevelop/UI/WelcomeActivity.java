package com.xiaochao.lcrapiddevelop.UI;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AndroidRuntimeException;
import android.util.Log;

import com.xiaochao.lcrapiddevelop.R;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


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
