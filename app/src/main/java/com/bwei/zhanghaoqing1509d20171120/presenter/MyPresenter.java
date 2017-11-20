package com.bwei.zhanghaoqing1509d20171120.presenter;

import android.util.Log;

import com.bwei.zhanghaoqing1509d20171120.bean.JavaBean;
import com.bwei.zhanghaoqing1509d20171120.model.MyModel;
import com.bwei.zhanghaoqing1509d20171120.util.OnUiCallback;
import com.bwei.zhanghaoqing1509d20171120.view.MyView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by MK on 2017/11/20.
 */
public class MyPresenter {
    MyView view;
    private final MyModel model;

    public MyPresenter(MyView view) {
        this.view = view;
        model = new MyModel();
    }

    public void add(String uid,String status,String page,String source){
        model.showData(uid, status, page, source, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

                Log.i("失败","疯狂运行中");

            }

            @Override
            public void onSuccess(String result) {
                Log.i("---",result);
                Gson gson = new Gson();
                JavaBean javaBean = gson.fromJson(result, JavaBean.class);
                view.getData(javaBean);

            }
        });
    }

    public void cancal() {
        this.view=null;
    }
}
