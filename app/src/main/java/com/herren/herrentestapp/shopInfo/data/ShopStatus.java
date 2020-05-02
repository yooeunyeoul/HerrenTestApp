package com.herren.herrentestapp.shopInfo.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShopStatus {

    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

    @SerializedName("url")
    private final String url;

    @SerializedName("seq")
    private final int seq;

    @SerializedName("name")
    private final String name;

    @SerializedName("state")
    private final String state;

    @SerializedName("viewcnt")
    private final int viewCount;

    @SerializedName("regdate")
    private final String regDate;


    ShopStatus(int seq, String name, String state, int viewCount, String regDate, String url) {
        this.seq = seq;
        this.name = name;
        this.state = state;
        this.viewCount = viewCount;
        this.regDate = regDate;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public int getSeq() {
        return seq;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getViewCount() {
        return "조회수:" + viewCount;
    }

    public String getRegDate() {
        Date n;
        String format="";
        try {
            n = DATE_TIME_FORMAT.parse(regDate);
            format = DATE_FORMAT.format(n);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "등록날짜 : "+format;
    }

    @NonNull
    @Override
    public String toString() {
        return "이름:" + name + "url" + url + "뷰 카운트" + viewCount;
    }
}
