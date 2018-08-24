package com.qhxk.webservicedemo.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 创建者     WLD
 * 创建时间   2017/12/13 14:00
 * 描述	     公共的HTTP请求--- 接口回调返回数据
 * 更新描述
 */
public class ComProtocol {

    private okResponse mOkResponse;
    private String url;
    private String json;

    public ComProtocol(String url, String json, okResponse okResponse) {
        this.url = url;
        this.json = json;
        this.mOkResponse = okResponse;
    }

    public void getHttpClientResult() {

        MediaType JSON = MediaType.parse("text/xml; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);
        final Request request = new Request.Builder().url(url).post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                mOkResponse.onFaile(e.toString());
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                mOkResponse.onSuccess(str);
            }
        });

    }

    public interface okResponse {
        void onSuccess(String str);
        void onFaile(String str);
    }
}
