package com.fhmou.entity;

import java.io.Serializable;

/**
 * package com.fhmou.entity
 * functional describe:
 *
 * @version 1.0 16-9-1 上午11:51
 * @auther luyanliang [765673481@qq.com]
 */
public class BaseInfo implements Serializable {

    private String app_runtime;
    private int errno;
    private String error;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getApp_runtime() {
        return app_runtime;
    }

    public void setApp_runtime(String app_runtime) {
        this.app_runtime = app_runtime;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
