package com.sanwenyu.stemplate.ui.poetry.model;


import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.sanwenyu.stemplate.app.AppConstant;
import com.sanwenyu.stemplate.app.QueryType;
import com.sanwenyu.stemplate.beans.Poetry;
import com.sanwenyu.stemplate.db.DbHelper;
import com.sanwenyu.stemplate.db.dao.PoetryDao;
import com.sanwenyu.stemplate.ui.poetry.contract.PoetryContract;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.greenrobot.greendao.rx.RxQuery;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * des:诗词model
 * Created by lzc
 * on 2020年1月28日13点26分
 */
public class PoetryModel implements PoetryContract.Model {

    @Override
    public Observable<List<Poetry>> lodePoetrys(String where, QueryType type,int pageNum) {
        QueryBuilder qb = DbHelper.getInstance().getDaoSession().getPoetryDao().queryBuilder();
        WhereCondition whereCondition = null;
        switch (type) {
            case TITLE:
                whereCondition = PoetryDao.Properties.Title.like(where);
                break;
            case AUTHOR:
                whereCondition = PoetryDao.Properties.Author.like(where);
                break;
            case DYNASTY:
                whereCondition = PoetryDao.Properties.Dynasty.like(where);
                break;
            case CONTENT:
                whereCondition = PoetryDao.Properties.Content.like(where);
                break;
                default:
                    throw new IllegalArgumentException();
                break;
        }
        RxQuery rxQuery = qb
                .where(whereCondition)
                .limit(AppConstant.PAGE_SIZE)
                .offset((pageNum-1)*AppConstant.PAGE_SIZE)
                .rx();
        return rxQuery.list();
    }
}
