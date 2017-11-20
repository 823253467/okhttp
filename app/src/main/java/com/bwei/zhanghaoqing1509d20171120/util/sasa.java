package com.bwei.zhanghaoqing1509d20171120.util;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by MK on 2017/11/20.
 */
public class sasa implements Interceptor {

    private HashMap<String, Object> rootMap;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request build = null;
        Request request = chain.request();
        FormBody.Builder formBuild = new FormBody.Builder();
        if (request.method().equals("GET")) {
            String oldUrl = request.url().toString();
            String newUrl = oldUrl + "&source=android";
            build = request.newBuilder()
                    .url(newUrl)
                    .build();
        } else {
            RequestBody body = request.body();
            for (int i = 0; i < ((FormBody) body).size(); i++) {
                formBuild.add(((FormBody) body).encodedName(i), ((FormBody) body).value(i));
            }
            formBuild.add("source", "android");
            FormBody formbody = formBuild.build();
            build = request.newBuilder()
                    .url(request.url())
                    .post(formbody)
                    .build();
        }
        return chain.proceed(build);
    }
}
