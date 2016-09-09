package com.fhmou.net.okhttp;

/**
 * package com.fhmou.http.okhttp
 * functional describe:
 *
 * @version 1.0 16-8-28 上午10:40
 * @auther luyanliang [765673481@qq.com]
 */
public interface ResponseListener {

    void onFailure(int arg1, String url, String obj);

    void onSuccess(String url, Object obj);
}
