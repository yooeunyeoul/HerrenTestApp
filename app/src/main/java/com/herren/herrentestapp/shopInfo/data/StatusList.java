package com.herren.herrentestapp.shopInfo.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusList {

    public List<ShopStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<ShopStatus> statusList) {
        this.statusList = statusList;
    }

    @SerializedName("list")
    private
    List<ShopStatus> statusList;



}
