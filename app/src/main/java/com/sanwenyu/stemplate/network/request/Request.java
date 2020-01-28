package com.sanwenyu.stemplate.network.request;


import com.sanwenyu.stemplate.beans.NewsChannelTable;
import com.sanwenyu.stemplate.network.response.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 封装请求的接口
 */

public interface Request {

    public static String HOST = "https://xxxx.api.xxx.com/xxxx/";

    @POST("?service=User.getList")
    Observable<Response<List<Object>>> getList(@Query("userId") String userId);

    //获取新闻知识频道表
    @POST("?service=User.getList")
    Observable<Response<List<NewsChannelTable>>> getNewsChannelTable(@Query("userId") long userId,@Query("torken") String torken);

}
