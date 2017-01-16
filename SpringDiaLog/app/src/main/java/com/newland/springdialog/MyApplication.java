package com.newland.springdialog;

import android.app.Application;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.newland.springdialog.springdialog.DisplayUtil;

/**
 * 说明
 * 作者 郭翰林
 * 创建时间 2017/1/13.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initDisplayOpinion();
        Fresco.initialize(this);
    }

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);
    }
}
