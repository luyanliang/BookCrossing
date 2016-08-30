package com.fhmou.entity;

import java.io.Serializable;

/**
 * package com.fhmou.activity.book
 * functional describe:
 *
 * @version 1.0 16-8-26 上午11:18
 * @auther luyanliang [765673481@qq.com]
 */
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String userEmail;
    private String userName;
    private String wechatNum;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getWechatNum() {
        return wechatNum;
    }
    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }

}
