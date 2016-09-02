package com.fhmou.entity;

/**
 * package com.fhmou.entity
 * functional describe:
 *
 * @version 1.0 16-9-1 上午11:50
 * @auther luyanliang [765673481@qq.com]
 */
public class UserInfo extends UserBaseInfo {

    public static final int POWER_TYPE_NOMAL = 0;
    public static final int POWER_TYPE_PRIVILEGE = 1;
    private static final long serialVersionUID = 1L;
    private String age;
    private String area;
    private String birthday;
    private String description;
    private String distance = "0km";
    private String head;
    private int like_num;
    private String like_time;
    private int like_type = 0;
    private int match_timestamp;
    private int pic_num;
    private int power = 0;
    private String sex = "1";
    private int slide_type;
    private int star_num = 0;
    private int super_likes = 0;
    private int thumb_num = 0;
    private int type = 0;
    private String update_time = "";
    private int vip;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getLike_time() {
        return like_time;
    }

    public void setLike_time(String like_time) {
        this.like_time = like_time;
    }

    public int getLike_type() {
        return like_type;
    }

    public void setLike_type(int like_type) {
        this.like_type = like_type;
    }

    public int getMatch_timestamp() {
        return match_timestamp;
    }

    public void setMatch_timestamp(int match_timestamp) {
        this.match_timestamp = match_timestamp;
    }

    public int getPic_num() {
        return pic_num;
    }

    public void setPic_num(int pic_num) {
        this.pic_num = pic_num;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSlide_type() {
        return slide_type;
    }

    public void setSlide_type(int slide_type) {
        this.slide_type = slide_type;
    }

    public int getStar_num() {
        return star_num;
    }

    public void setStar_num(int star_num) {
        this.star_num = star_num;
    }

    public int getSuper_likes() {
        return super_likes;
    }

    public void setSuper_likes(int super_likes) {
        this.super_likes = super_likes;
    }

    public int getThumb_num() {
        return thumb_num;
    }

    public void setThumb_num(int thumb_num) {
        this.thumb_num = thumb_num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }
}
