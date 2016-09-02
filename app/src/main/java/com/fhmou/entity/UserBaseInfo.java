package com.fhmou.entity;

import java.util.ArrayList;

/**
 * package com.fhmou.entity
 * functional describe:
 *
 * @version 1.0 16-9-1 上午11:53
 * @auther luyanliang [765673481@qq.com]
 */
public class UserBaseInfo extends BaseInfo {

    private ArrayList<String> album;
    private String nickname;
    private String uid;

    public ArrayList<String> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<String> album) {
        this.album = album;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
