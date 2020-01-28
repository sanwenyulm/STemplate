package com.sanwenyu.stemplate.ui.main.model;



import com.sanwenyu.stemplate.beans.NewsChannelTable;
import com.sanwenyu.stemplate.network.response.Response;
import com.sanwenyu.stemplate.ui.main.contract.NewsMainContract;
import com.sanwenyu.stemplate.network.NetWorkManager;

import java.util.List;

import io.reactivex.Observable;


/**
 * des:从网络服务获取知识新闻版块列表
 * Created by lzc
 * on 2020.1.27
 */
public class NewsMainModel implements NewsMainContract.Model {
    @Override
    public Observable<Response<List<NewsChannelTable>>> lodeMineNewsChannels(long userId, String torken) {
        //创造被观察者（网络IO）
        return NetWorkManager.getNewsRequest().getNewsChannelTable(userId,torken);
    }
}
