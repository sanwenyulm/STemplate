package com.sanwenyu.stemplate.base;

/**
 * des:baseview
 * Created by lzc
 * on 2020.1.27
 */
public interface BaseView {
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
