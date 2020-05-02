package com.herren.herrentestapp.api;

import com.herren.herrentestapp.shopInfo.data.StatusList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    public static final String ENDPOINT = "http://api-staging.gongbiz.kr";


    @GET("/app/v2020/art")
    Single<StatusList> getShopStatus(@Query("page") int Page,
                                     @Query("size") int Size);
}
