package com.fhmou.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpAgent {

    public static String TAG="debug-okhttp";
    public static boolean isDebug=true;

    private OkHttpClient client;
    // 超时时间
    public static final int TIMEOUT = 1000 * 60;

    //json请求
    public static final MediaType JSON = MediaType
            .parse("application/json; charset=utf-8");

    private Handler handler = new Handler(Looper.getMainLooper());

    public HttpAgent () {
        this.init();
    }

    private void init() {
        client = new OkHttpClient();

        // 设置超时时间
        client.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
    }

    /**
     * 
     * @param url 服务器资源定位
     * @param paras 传入的参数localhost:8080/login_ad
     * @return result 返回的Json
     */
    public  String request(String url, Map<String,Object> paras, String sessionId){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", 200);
            jsonObject.put("msg", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public void post(String url, Map<String, Object> paras, String sessionId, final HttpCallback callback) {
        /**
         * 创建请求的参数body
         */
        FormBody.Builder builder = new FormBody.Builder();

        /**
         * 遍历key
         */
        if (null != paras) {
            for (Map.Entry<String, Object> entry : paras.entrySet()) {
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }

        RequestBody body = builder.build();

        Request request = new Request.Builder().url(url).post(body).build();

        onStart(callback);

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                onError(callback, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    onSuccess(callback, response.body().string());
                } else {
                    onError(callback, response.message());
                }
            }
        });
    }

    public void postJson(String url, String json, final HttpCallback callback) {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();

        onStart(callback);

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                onError(callback, e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    onSuccess(callback, response.body().string());
                } else {
                    onError(callback, response.message());
                }
            }

        });

    }

    /**
     * log信息打印
     * @param params
     */
    public void debug(String params){
        if(false == isDebug){
            return;
        }

        if(null == params){
            Log.d(TAG, "params is null");
        }else{
            Log.d(TAG, params);
        }
    }

    private void onStart(HttpCallback callback) {
        if (null != callback) {
            callback.onStart();
        }
    }

    private void onSuccess(final HttpCallback callback, final String data) {

        debug(data);

        if (null != callback) {
            handler.post(new Runnable() {
                public void run() {
                    // 需要在主线程的操作。
                    callback.onSuccess(data);
                }
            });
        }
    }

    private void onError(final HttpCallback callback,final String msg) {
        if (null != callback) {
            handler.post(new Runnable() {
                public void run() {
                    // 需要在主线程的操作。
                    callback.onError(msg);
                }
            });
        }
    }

    /**
     * http请求回调
     *
     * @author Flyjun
     *
     */
    public static abstract class HttpCallback {
        // 开始
        public void onStart() {};

        // 成功回调
        public abstract void onSuccess(String data);

        // 失败回调
        public void onError(String msg) {};
    }
}