package com.fhmou.net;

import com.fhmou.net.okhttp.RequestParams;
import com.fhmou.net.okhttp.ResponseListener;

/**
 * package com.fhmou.net
 * functional describe:
 *
 * @version 1.0 16-8-30 下午2:30
 * @auther luyanliang [765673481@qq.com]
 */
public class AppApis {

    public static void login (String phone, String password, ResponseListener listener) {
        RequestParams params = RequestParams.getInstance();
        params.put("phone", phone);
        params.put("password", password);
        Https.getInstance().post(Urls.LOGIN, params, listener);
    }
}
