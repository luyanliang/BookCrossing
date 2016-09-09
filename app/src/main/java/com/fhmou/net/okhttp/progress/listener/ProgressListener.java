package com.fhmou.net.okhttp.progress.listener;

/**
 * package com.fhmou.net.okhttp.progress.listener
 * functional describe:
 *
 * @version 1.0 16-9-9 下午8:36
 * @auther luyanliang [765673481@qq.com]
 */
public interface ProgressListener {

    void onProgress(long currentBytes, long contentLength, boolean done);
}
