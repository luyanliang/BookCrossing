package com.fhmou.net.okhttp;

import android.os.Message;

import com.fhmou.net.okhttp.base.BaseResponseHandler;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * package com.fhmou.net.okhttp
 * functional describe:
 *
 * @version 1.0 16-8-30 下午4:07
 * @auther luyanliang [765673481@qq.com]
 */
public class RequestTask implements Runnable {

    private String mBeaseUrl;
    private OkHttpClient client;
    private Class<?> cls;
    private BaseResponseHandler handler;
    private Request request;
    private long startTime = 0L;

    public RequestTask(String url, OkHttpClient client, Request request, BaseResponseHandler handler) {
        this.mBeaseUrl = url;
        this.client = client;
        this.request = request;
        this.handler = handler;
    }

    public RequestTask(String url, OkHttpClient client, Request request, BaseResponseHandler handler, Class<?> cls) {
        this.mBeaseUrl = url;
        this.client = client;
        this.request = request;
        this.handler = handler;
        this.cls = cls;
    }

    private void sendMessage(int what, int arg1, Object obj) {
        if (handler != null) {
            Message message = handler.obtainMessage(what, arg1);
            message.obj = obj;
            message.sendToTarget();
        }
    }

    @Override
    public void run() {
        System.out.printf("request start");
        sendMessage(1, -1, null);
//        if (NetUtils.isNetworkAvailable()) {
//
//        }
    }
}
