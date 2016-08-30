package com.fhmou.tools.json;

import android.util.Log;

import com.alibaba.fastjson.JSON;

/**
 * package com.fhmou.activity.book
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:21
 * @auther luyanliang [765673481@qq.com]
 */
public class AbstractObject {

    public static <T> T String2Object(String jsonString,Class<T> clazz){

        T info = null;
        try{
            info = JSON.parseObject(jsonString, clazz);
        }catch(Exception e){
            Log.e("book", e.getMessage(), e);
            return null;
        }
        return info;
    }
}
