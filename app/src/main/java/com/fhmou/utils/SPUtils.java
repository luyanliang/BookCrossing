package com.fhmou.utils;

import android.content.Context;
import android.text.TextUtils;

import com.fhmou.entity.UserInfo;
import com.fhmou.utils.date.DateUtils;
import com.fhmou.base.AppApplication;

/**
 * package com.fhmou.utils
 * functional describe:
 *
 * @version 1.0 16-9-1 上午11:30
 * @auther luyanliang [765673481@qq.com]
 */
public class SPUtils extends SPBase {

    static {
        INIT_METHOD_DEFAULT = INIT_METHOD_2;
    }

    public static void init(Context context) {
        initSP(context, USER_PREFERENCE_FILE_NAME);
    }

    public static class Impl {
        public static final String FLAG_AGE = "age";
        public static final String FLAG_BIRTHDAY = "birthday";
        public static final String FLAG_DESCRIPTION = "description";
        public static final String FLAG_DISTANCE = "distance";
        public static final String FLAG_IS_FIRST = "isFirst";
        public static final String FLAG_LATEST_PAY_CASH_DATE = "latest_pay_cash_date";
        public static final String FLAG_LIKE_NUM = "like_num";
        public static final String FLAG_PAY_CASH_ACCOUNT = "pay_cash_account";
        public static final String FLAG_PAY_CASH_NAME = "pay_cash_name";
        public static final String FLAG_PAY_PWD = "pay_pwd";
        public static final String FLAG_PHONE = "phone";
        public static final String FLAG_PIC_NUM = "pic_num";
        public static final String FLAG_POWER = "power";
        public static final String FLAG_RESOURCE = "resource";
        public static final String FLAG_SEX = "sex";
        public static final String FLAG_STAT_NUM = "stat_num";
        public static final String FLAG_SUPER_LIKES = "super_likes";
        public static final String FLAG_THUMB_NUM = "thumb_num";
        public static final String FLAG_TOKEN = "KEY_HTTP_TOKEN";
        public static final String FLAG_UID = "KEY_UID";
        public static final String FLAG_UPDATE_TIME = "update_time";
        public static final String FLAG_USER_FACE_URL = "user_face_url";
        public static final String FLAG_USER_NICK_NAME = "nick_name";
        public static final String FLAG_VIP = "vip";
        public static final String HAS_LOOK_SETTING = "has_look_setting";
        public static final String IS_FIRST_LOGIN = "isFirstLogin";
        public static final String NOTIFICATION_CALLIN = "callin";
        public static final String NOTIFICATION_DETAIL = "detail";
        public static final String NOTIFICATION_RECEVIE = "recevie";
        public static final String NOTIFICATION_VIBOR = "vibor";
        public static final String NOTIFICATION_VOICE = "voice";
        public static final String OFFLINE_MESSAGE_ID = "offline.message.id";
        public static final String VERSION_CODE = "version_code";

        public static boolean checkTodayPayCash() {
            return DateUtils.format(System.currentTimeMillis(), DateUtils.FORMAT_DATE_yyyyMMdd3).equals(SPBase.getString(FLAG_LATEST_PAY_CASH_DATE + getUid(), ""));
        }

        public static String getPayCashAccount() {
            return SPBase.getString(FLAG_PAY_CASH_ACCOUNT + getUid(), "");
        }

        public static String getPayCashName() {
            return SPBase.getString(FLAG_PAY_CASH_NAME + getUid(), "");
        }

        public static String getPayPwd() {
            return SPBase.getString(FLAG_PAY_PWD + getUid(), "");
        }

        public static String getToken() {
            String str2 = AppApplication.getInstance().TOKEN;
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
                str1 = SPBase.getString(FLAG_TOKEN, "");
                AppApplication.getInstance().TOKEN = str1;
            }
            return str1;
        }

        public static String getUid() {
            String str2 = AppApplication.getInstance().UID;
            String str1 = str2;
            return str2;
        }

        public static String getUrlFaceIcon() {
            String str2 = AppApplication.getInstance().URL_FACE_ICON;
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
                str1 = SPBase.getString(FLAG_USER_FACE_URL, "");
                AppApplication.getInstance().URL_FACE_ICON = str1;
            }
            return str1;
        }

        public static UserInfo getUserInfo() {
            UserInfo localUserInfo = new UserInfo();
            localUserInfo.setUid(getUid());
            localUserInfo.setBirthday(SPBase.getString(FLAG_BIRTHDAY, ""));
            localUserInfo.setNickname(SPBase.getString(FLAG_USER_NICK_NAME, ""));
            localUserInfo.setAge(SPBase.getString(FLAG_AGE, "0"));
            localUserInfo.setDistance(SPBase.getString(FLAG_DISTANCE, "10m"));
            localUserInfo.setDescription(SPBase.getString(FLAG_DESCRIPTION, ""));
            localUserInfo.setUpdate_time(SPBase.getString(FLAG_UPDATE_TIME, "刚刚"));
            localUserInfo.setThumb_num(SPBase.getInt(FLAG_THUMB_NUM, 0));
            localUserInfo.setLike_num(SPBase.getInt(FLAG_LIKE_NUM, 0));
            localUserInfo.setStar_num(SPBase.getInt(FLAG_STAT_NUM, 0));
            localUserInfo.setPic_num(SPBase.getInt(FLAG_PIC_NUM, 0));
            localUserInfo.setSex(SPBase.getString(FLAG_SEX, "0"));
            localUserInfo.setPower(SPBase.getInt(FLAG_POWER, 0));
            localUserInfo.setVip(SPBase.getInt(FLAG_VIP, 0));
            localUserInfo.setSuper_likes(SPBase.getInt(FLAG_SUPER_LIKES, 0));
            localUserInfo.setHead(getUrlFaceIcon());
            localUserInfo.setStatus(1);
            return localUserInfo;
        }

        public static void saveUserInfo(UserInfo paramUserInfo) {
            SPBase.putString(FLAG_AGE, paramUserInfo.getAge());
            SPBase.putString(FLAG_BIRTHDAY, paramUserInfo.getBirthday());
            SPBase.putString(FLAG_DISTANCE, paramUserInfo.getDistance());
            SPBase.putString(FLAG_DESCRIPTION, paramUserInfo.getDescription());
            SPBase.putString(FLAG_UPDATE_TIME, paramUserInfo.getUpdate_time());
            SPBase.putInt(FLAG_THUMB_NUM, paramUserInfo.getThumb_num());
            SPBase.putInt(FLAG_LIKE_NUM, paramUserInfo.getLike_num());
            SPBase.putInt(FLAG_STAT_NUM, paramUserInfo.getStar_num());
            SPBase.putInt(FLAG_PIC_NUM, paramUserInfo.getPic_num());
            SPBase.putString(FLAG_SEX, paramUserInfo.getSex());
            SPBase.putString(FLAG_USER_NICK_NAME, paramUserInfo.getNickname());
            SPBase.putInt(FLAG_POWER, paramUserInfo.getPower());
            SPBase.putInt(FLAG_VIP, paramUserInfo.getVip());
            SPBase.putInt(FLAG_SUPER_LIKES, paramUserInfo.getSuper_likes());
            setUrlFaceIcon(paramUserInfo.getHead());
        }

        public static void setPayCashAccount(String paramString) {
            SPBase.putString(FLAG_PAY_CASH_ACCOUNT + getUid(), paramString);
        }

        public static void setPayCashName(String paramString) {
            SPBase.putString(FLAG_PAY_CASH_NAME + getUid(), paramString);
        }

        public static void setPayPwd(String paramString) {
            SPBase.putString(FLAG_PAY_PWD + getUid(), paramString);
        }

        public static void setToken(String token) {
            SPBase.putString(FLAG_TOKEN, token);
        }

        public static void setUid(String paramString) {
            SPBase.putString(FLAG_UID, paramString);
        }

        public static void setUrlFaceIcon(String paramString) {
            SPBase.putString(FLAG_USER_FACE_URL, paramString);
        }

        public static void updateLatestPayCashDate() {
            SPBase.putString(FLAG_LATEST_PAY_CASH_DATE + getUid(), DateUtils.format(System.currentTimeMillis(), DateUtils.FORMAT_DATE_yyyyMMdd3));
        }
    }

}
