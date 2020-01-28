package com.sanwenyu.stemplate.ui.main.contract;







import com.sanwenyu.stemplate.base.BaseModel;
import com.sanwenyu.stemplate.base.BasePresenter;
import com.sanwenyu.stemplate.base.BaseView;
import com.sanwenyu.stemplate.beans.NewsChannelTable;

import com.sanwenyu.stemplate.network.response.Response;


import java.util.List;

import io.reactivex.Observable;


/**
 * des: 新闻知识版块契约
 * Created by lzc
 * on 2020.1.27
 */
public interface NewsMainContract {

    interface Model extends BaseModel {
        Observable<Response<List<NewsChannelTable>>> lodeMineNewsChannels(long userId, String torken);
    }

    interface View extends BaseView {
        void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodeMineChannelsRequest(long userId,String torken);
    }
}
