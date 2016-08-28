package com.fhmou.activity.book;

import java.io.Serializable;

/**
 * package com.fhmou.activity.book
 * functional describe:
 *
 * @version 1.0 16-8-26 上午11:21
 * @auther luyanliang [765673481@qq.com]
 */
public class Label implements Serializable {

    private String labelName;
    private long id;
    private long creatorId;
    private String lastUpdateDate;
    private String createDate;

    public long getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLabelName() {
        return labelName;
    }
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
