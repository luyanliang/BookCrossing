package com.fhmou.net;

/**
 * package com.fhmou.http
 * functional describe: 请求服务端的url
 *
 * @version 1.0 16-8-28 上午10:40
 * @auther luyanliang [765673481@qq.com]
 */
public class Urls {

    public static final String API_DOMAIN = "http://api.fhmou.com/";
    public static final String VERSION = "v1.0";

    public static final String CHECK_ACCOUNT_NUMBER = API_DOMAIN + VERSION + "/auth/check_account_number";

    public static final String LOGIN = API_DOMAIN + VERSION + "/auth/login";

    public static final String VISITOR_INFO = API_DOMAIN + VERSION + "/index.php/visitor/user_info";
}
