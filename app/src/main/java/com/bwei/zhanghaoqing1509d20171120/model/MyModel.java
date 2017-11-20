package com.bwei.zhanghaoqing1509d20171120.model;

import com.bwei.zhanghaoqing1509d20171120.util.OkHttp3Utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/20.
 */
public class MyModel implements IModel{
    @Override
    public void showData(String uid, String status, String page, String source, Callback callback) {
        /*Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        map.put("status",status);
        map.put("page",page);

        OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/getOrders",map,callback);*/
        OkHttp3Utils instance = OkHttp3Utils.getInstance();
        instance.doGet("https://www.zhaoapi.cn/product/getOrders?uid="+uid+"&status"+status+"&page"+page+"",callback);
    }
}
