package com.xiaochao.lcrapiddeveloplibrary.Exception.callback;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.xiaochao.lcrapiddeveloplibrary.Exception.core.Recovery;
import com.xiaochao.lcrapiddeveloplibrary.Exception.core.RecoveryActivity;
import com.xiaochao.lcrapiddeveloplibrary.Exception.core.RecoveryStore;
import com.xiaochao.lcrapiddeveloplibrary.Exception.tools.Reflect;


/**
 * Created by zhengxiaoyong on 16/8/28.
 */
public class RecoveryActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(final Activity activity, Bundle savedInstanceState) {
        boolean isLegal = RecoveryStore.getInstance().verifyActivity(activity);
        if (!isLegal)
            return;
        if (activity.getIntent().getBooleanExtra(RecoveryActivity.RECOVERY_MODE_ACTIVE, false)) {
            Reflect.on(Recovery.class).method("registerRecoveryProxy").invoke(Recovery.getInstance());
        }
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            if (decorView == null)
                return;
            decorView.post(new Runnable() {
                @Override
                public void run() {
                    RecoveryStore.getInstance().putActivity(activity);
                    Object o = activity.getIntent().clone();
                    RecoveryStore.getInstance().setIntent((Intent) o);
                }
            });
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        RecoveryStore.getInstance().removeActivity(activity);
    }

}
