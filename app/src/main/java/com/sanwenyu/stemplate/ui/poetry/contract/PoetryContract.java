package com.sanwenyu.stemplate.ui.poetry.contract;


import com.sanwenyu.stemplate.app.QueryType;
import com.sanwenyu.stemplate.base.BaseModel;
import com.sanwenyu.stemplate.base.BasePresenter;
import com.sanwenyu.stemplate.base.BaseView;
import com.sanwenyu.stemplate.beans.Poetry;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


/**
 * des:
 * Created by lzc
 * on 2020年1月28日13点16分
 */
public interface PoetryContract {

    interface Model extends BaseModel {
        Observable<List<Poetry>> lodePoetrys(String where, QueryType type, int pageNum);
    }

    interface View extends BaseView {
        void returnPoetryLists(List<Poetry> poetryList);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodePoetrysRequest(String where, QueryType type,int pageNum);
    }
}
