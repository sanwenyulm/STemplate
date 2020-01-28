package com.sanwenyu.stemplate.ui.poetry.presenter;


import com.sanwenyu.stemplate.app.QueryType;

import com.sanwenyu.stemplate.ui.poetry.contract.PoetryContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;



/**
 * des:诗词查询
 * Created by lzc
 * on 2020年1月28日14点45分
 */
public class PoetryPresenter extends PoetryContract.Presenter{

    @Override
    public void lodePoetrysRequest(String where, QueryType type, int pageNum) {
        Disposable disposable = mModel.lodePoetrys(where,type,pageNum)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(poetryList->{
                    //直接拿到返回来的频道列表  此刻已经从IO线程切换到主线程
                    mView.returnPoetryLists(poetryList);
                },throwable -> {
                    mView.showErrorTip("查询失败");
                });
        mDisposable.add(disposable);
    }
}
