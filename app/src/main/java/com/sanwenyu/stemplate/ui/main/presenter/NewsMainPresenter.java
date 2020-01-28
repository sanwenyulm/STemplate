package com.sanwenyu.stemplate.ui.main.presenter;




import com.sanwenyu.stemplate.app.AppConstant;
import com.sanwenyu.stemplate.beans.NewsChannelTable;
import com.sanwenyu.stemplate.network.response.ResponseTransformer;
import com.sanwenyu.stemplate.ui.main.contract.NewsMainContract;

import java.util.List;

import io.reactivex.disposables.Disposable;
import rx.functions.Action1;


/**
 * des:
 * Created by lzc
 * on 2020.1.28 13点02分
 */
public class NewsMainPresenter extends NewsMainContract.Presenter{

    @Override
    public void onStart() {
        super.onStart();
        //监听新闻频道变化刷新
        mRxManage.on(AppConstant.NEWS_CHANNEL_CHANGED, new Action1<List<NewsChannelTable>>() {
            @Override
            public void call(List<NewsChannelTable> newsChannelTables) {
                if(newsChannelTables!=null){
                    mView.returnMineNewsChannels(newsChannelTables);
                }
            }
        });
    }

    @Override
    public void lodeMineChannelsRequest(long userId, String torken) {
       Disposable disposable = mModel.lodeMineNewsChannels(userId,torken)
                //过滤转换
                .compose(ResponseTransformer.handleResult())
                //切换线程
                .compose(schedulerProvider.applySchedulers())
                //通知订阅者mView
                .subscribe(channelList->{
                    //直接拿到返回来的频道列表  此刻已经从IO线程切换到主线程
                    mView.returnMineNewsChannels(channelList);
                },throwable -> {
                    mView.showErrorTip(throwable.getMessage());
                });
        mDisposable.add(disposable);
    }
}
