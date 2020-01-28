package com.sanwenyu.stemplate.base;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxManager;
import com.sanwenyu.stemplate.network.schedulers.BaseSchedulerProvider;
import com.sanwenyu.stemplate.network.schedulers.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * des:基类presenter
 * Created by lzc
 * on 2020.1.27
 */
public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E mModel;
    public T mView;
    public BaseSchedulerProvider schedulerProvider;
    public CompositeDisposable mDisposable;
    public RxManager mRxManage = new RxManager();
    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        schedulerProvider = SchedulerProvider.getInstance();
        mDisposable = new CompositeDisposable();
        this.onStart();
    }
    public void onStart(){
    }
    public void onDestroy() {
        if(mDisposable != null){
            mDisposable.dispose();
        }
        mRxManage.clear();

    }
}
