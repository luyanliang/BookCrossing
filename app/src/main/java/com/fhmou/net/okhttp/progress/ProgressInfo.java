package com.fhmou.net.okhttp.progress;

import java.io.Serializable;

/**
 * package com.fhmou.net.okhttp.progress
 * functional describe:
 *
 * @version 1.0 16-9-9 下午8:33
 * @auther luyanliang [765673481@qq.com]
 */
public class ProgressInfo implements Serializable {

    private long contentLength;
    private long currentBytes;
    private boolean done;

    public ProgressInfo(long currentBytes, long contentLength, boolean done) {
        this.currentBytes = currentBytes;
        this.contentLength = contentLength;
        this.done = done;
    }

    public long getContentLength() {
        return contentLength;
    }

    public long getCurrentBytes() {
        return currentBytes;
    }

    public boolean isDone() {
        return done;
    }

    public void setContentLength(long paramLong) {
        this.contentLength = paramLong;
    }

    public void setCurrentBytes(long paramLong) {
        this.currentBytes = paramLong;
    }

    public void setDone(boolean paramBoolean) {
        this.done = paramBoolean;
    }

    public String toString() {
        return "ProgressInfo{currentBytes=" + currentBytes + ", contentLength=" + contentLength + ", done=" + done + '}';
    }
}
