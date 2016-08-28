package com.fhmou.activity.user;

import java.io.Serializable;

/**
 * package com.fhmou.activity.user
 * functional describe:
 *
 * @version 1.0 16-8-26 下午1:26
 * @auther luyanliang [765673481@qq.com]
 */
public class UserLocation implements Serializable {

    private Integer Id;
    private Integer userId;
    private String longitude;
    private String latitude;
    private String address;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
