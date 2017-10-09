package com.sun.courseprj.application;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by sun on 2017/10/9.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,"5db4c488cf76efadfaf9c669d898fe97");
    }
}
