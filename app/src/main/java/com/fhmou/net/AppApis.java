package com.fhmou.net;

import com.fhmou.entity.UserInfo;
import com.fhmou.net.okhttp.RequestParams;
import com.fhmou.net.okhttp.ResponseListener;
import com.fhmou.utils.SPUtils;

/**
 * package com.fhmou.net
 * functional describe:
 *
 * @version 1.0 16-8-30 下午2:30
 * @auther luyanliang [765673481@qq.com]
 */
public class AppApis {

    public static void login(String phone, String password, ResponseListener listener) {
        RequestParams params = RequestParams.getInstance();
        params.put("phone", phone);
        params.put("password", password);
        Https.getInstance().post(Urls.LOGIN, params, listener);
    }

    public static void getUserInfo(String paramString, ResponseListener listener) {
        RequestParams localRequestParams = getParamsWithUidToken();
        localRequestParams.put("oid", paramString);
        Https.getInstance().post(Urls.VISITOR_INFO, localRequestParams, listener, UserInfo.class);
    }

    public static RequestParams getParamsWithUidToken() {
        RequestParams params = RequestParams.getInstance();
        params.put("uid", SPUtils.Impl.getUid());
        params.put("token", SPUtils.Impl.getToken());
        return params;
    }
}
