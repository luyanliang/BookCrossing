package com.fhmou.net.okhttp;

import com.fhmou.net.okhttp.base.BaseResponseHandler;

/**
 * package com.fhmou.net.okhttp
 * functional describe:
 *
 * @version 1.0 16-8-30 下午2:21
 * @auther luyanliang [765673481@qq.com]
 */
public class SimpleResponseHandler extends BaseResponseHandler {

    public SimpleResponseHandler(String tag, ResponseListener listener) {
        super(tag, listener);
    }
}
