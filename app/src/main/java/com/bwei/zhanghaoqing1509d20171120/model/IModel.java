package com.bwei.zhanghaoqing1509d20171120.model;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/20.
 */
public interface IModel {

    public void showData(String uid,String status,String page,String source,Callback callback);
}
