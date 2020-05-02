package com.herren.herrentestapp.shopInfo.data;

import com.herren.herrentestapp.api.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ShopInfoRepository {


    private final ApiService service;

    @Inject
    ShopInfoRepository(ApiService service) {

        this.service = service;
    }

    public Single<StatusList> getShopStatus(int pageNum) {
        return service.getShopStatus(pageNum,20);

    }
}
