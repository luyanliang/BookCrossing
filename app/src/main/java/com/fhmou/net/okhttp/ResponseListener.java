package com.fhmou.net.okhttp;

/**
 * package com.fhmou.http.okhttp
 * functional describe:
 *
 * @version 1.0 16-8-28 上午10:40
 * @auther luyanliang [765673481@qq.com]
 */
public abstract interface ResponseListener {

    public abstract void onFailure(int paramInt, String paramString1, String paramString2);

    public abstract void onSuccess(String paramString, Object paramObject);
}
