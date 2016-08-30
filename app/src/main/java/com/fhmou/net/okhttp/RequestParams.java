package com.fhmou.net.okhttp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * package com.fhmou.net.okhttp
 * functional describe: 请求参数封装
 *
 * @version 1.0 16-8-30 下午2:04
 * @auther luyanliang [765673481@qq.com]
 */
public class RequestParams {

    private HashMap<String, String> params;

    private RequestParams() {
        if (this.params == null) {
            this.params = new HashMap<String, String>();
        }
    }

    public static RequestParams getInstance () {
        return Init.rp;
    }

    public void clear () {
        params.clear();
    }

    public HashMap<String, String> getParams () {
        return params;
    }

    public void put(String key, String value) {
        params.put(key, value);
    }

    public void put(String key, Object value) {
        params.put(key, value.toString());
    }

    public String remove(String key) {
        return params.remove(key);
    }

    public String toQueryString(String tag) {
        String param = toString();
        return param;
    }

    public RequestBody toRequestBody() {
        FormBody.Builder fb = new FormBody.Builder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            fb.add(entry.getKey(), entry.getValue());
        }
        return fb.build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (sb.length() > 0)
                sb.append("&");
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    private static class Init {
        private static RequestParams rp = new RequestParams();
    }
}
