package com.sanwenyu.network.request;


import com.sanwenyu.network.beans.BaseEntity;
import com.sanwenyu.network.response.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 封装请求的接口
 */

public interface Request {

    public static String HOST = "https://xxxx.api.xxx.com/xxxx/";

    @POST("?service=User.getList")
    Observable<Response<List<BaseEntity>>> getList(@Query("userId") String userId);

}
