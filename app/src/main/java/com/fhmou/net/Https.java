package com.fhmou.net;

import com.fhmou.net.okhttp.RequestParams;
import com.fhmou.net.okhttp.RequestTask;
import com.fhmou.net.okhttp.ResponseListener;
import com.fhmou.net.okhttp.SimpleResponseHandler;
import com.fhmou.net.okhttp.base.BaseResponseHandler;

import java.util.concurrent.ExecutorService;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * package com.fhmou.net.okhttp
 * functional describe: 封装请求
 *
 * @version 1.0 16-8-30 下午2:04
 * @auther luyanliang [765673481@qq.com]
 */
public class Https {

    public static final MediaType ALL = MediaType.parse("*/*");
    public static final MediaType FILE = MediaType.parse("application/octet-stream");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType TEXT = MediaType.parse("text/plain; charset=utf-8");

    private static volatile Https https;
    private Headers.Builder builder;
    private OkHttpClient client = getOkHttpClient();
    private ExecutorService threadPool;

    private Https() {
    }

    private Request.Builder createRequestBuilder(String tag, String url) {
        return new Request.Builder().url(url).tag(tag).headers(builder.build());
    }

    public static Https getInstance() {
        if (https == null) {
            https = new Https();
        }
        return https;
    }

    private Request.Builder getGetBuilder(String tag, RequestParams params) {
        Request.Builder rb;
        if (params != null) {
            rb = createRequestBuilder(tag, params.toQueryString(tag));
            releaseParames(params);
        } else {
            rb = createRequestBuilder(tag, tag);
        }
        return rb.get();
    }

    private Request.Builder getPostBuilder(String tag, RequestParams params) {
        Request.Builder rb;
        if (params != null) {
            rb = createRequestBuilder(tag, params.toQueryString(tag));
            releaseParames(params);
        } else {
            rb = createRequestBuilder(tag, tag);
        }
        return rb.post(params.toRequestBody());
    }

    private OkHttpClient getOkHttpClient() {
        if (client == null) {
            client = new OkHttpClient.Builder().build();
        }
        return client;
    }

    private void releaseParames(RequestParams params) {
        if (params != null) {
            params.clear();
        }
    }

    public void addHeader(String name, String value) {
        builder.add(name, value);
    }

    public void removeHeader(String name) {
        builder.removeAll(name);
    }

    public void get(String url, RequestParams params, ResponseListener listener) {
        submitRequest(url, getGetBuilder(url, params).build(), listener);
    }

    public void get(String url, RequestParams params, ResponseListener listener, Class<?> cls) {
        submitRequest(url, getGetBuilder(url, params).build(), listener, cls);
    }

    public void get(String url, RequestParams params, BaseResponseHandler handler) {
        submitRequest(url, getGetBuilder(url, params).build(), handler);
    }

    public void get(String url, RequestParams params, BaseResponseHandler handler, Class<?> cls) {
        submitRequest(url, getGetBuilder(url, params).build(), handler, cls);
    }

    public void get(String url, ResponseListener listener) {
        submitRequest(url, getGetBuilder(url, null).build(), listener);
    }

    public void get(String url, ResponseListener listener, Class<?> cls) {
        submitRequest(url, getGetBuilder(url, null).build(), listener, cls);
    }

    public void get(String url, BaseResponseHandler handler) {
        submitRequest(url, getGetBuilder(url, null).build(), handler);
    }

    public void get(String url, BaseResponseHandler handler, Class<?> cls) {
        submitRequest(url, getGetBuilder(url, null).build(), handler, cls);
    }

    public void post(String url, RequestParams params, ResponseListener listener) {
        submitRequest(url, getPostBuilder(url, params).build(), listener);
    }

    public void post(String url, RequestParams params, ResponseListener listener, Class<?> cls) {
        submitRequest(url, getPostBuilder(url, params).build(), listener, cls);
    }

    public void post(String url, RequestParams params, BaseResponseHandler handler) {
        submitRequest(url, getPostBuilder(url, params).build(), handler);
    }

    public void post(String url, RequestParams params, BaseResponseHandler handler, Class<?> cls) {
        submitRequest(url, getPostBuilder(url, params).build(), handler, cls);
    }

    public void post(String url, ResponseListener listener) {
        submitRequest(url, getPostBuilder(url, null).build(), listener);
    }

    public void post(String url, ResponseListener listener, Class<?> cls) {
        submitRequest(url, getPostBuilder(url, null).build(), listener, cls);
    }

    public void post(String url, BaseResponseHandler handler) {
        submitRequest(url, getPostBuilder(url, null).build(), handler);
    }

    public void post(String url, BaseResponseHandler handler, Class<?> cls) {
        submitRequest(url, getPostBuilder(url, null).build(), handler, cls);
    }

    public void submitRequest(String url, Request request) {
        submit(new RequestTask(url, getOkHttpClient(), request, null));
    }

    public void submitRequest(String url, Request request, ResponseListener listener) {
        submitRequest(url, request, new SimpleResponseHandler(request.tag().toString(), listener));
    }

    public void submitRequest(String url, Request request, ResponseListener listener, Class<?> cls) {
        submitRequest(url, request, new SimpleResponseHandler(request.tag().toString(), listener), cls);
    }

    public void submitRequest(String url, Request request, BaseResponseHandler handler) {
        submit(new RequestTask(url, getOkHttpClient(), request, handler));
    }

    public void submitRequest(String url, Request request, BaseResponseHandler handler, Class<?> cls) {
        submit(new RequestTask(url, getOkHttpClient(), request, handler, cls));
    }

    public void submit(Runnable runnable) {
        threadPool.submit(runnable);
    }

}