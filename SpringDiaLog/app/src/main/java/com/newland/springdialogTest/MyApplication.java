package com.newland.springdialogTest;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 说明
 * 作者 郭翰林
 * 创建时间 2017/1/13.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
