package com.sanwenyu.stemplate.app;


import android.content.Context;

import com.jaydenxiao.common.BuildConfig;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;


/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    public static Context mApplicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
        mApplicationContext = this;
    }
    public static Context  getAppicationContext(){
        return mApplicationContext;
    }
}
