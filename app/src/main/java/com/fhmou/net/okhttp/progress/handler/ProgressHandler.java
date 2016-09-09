package com.fhmou.net.okhttp.progress.handler;

import com.fhmou.net.okhttp.ResponseListener;
import com.fhmou.net.okhttp.base.BaseResponseHandler;
import com.fhmou.net.okhttp.progress.listener.ProgressListener;

/**
 * package com.fhmou.net.okhttp.progress.handler
 * functional describe:
 *
 * @version 1.0 16-9-9 下午8:39
 * @auther luyanliang [765673481@qq.com]
 */
public class ProgressHandler extends BaseResponseHandler
        implements ProgressListener {

    public ProgressHandler(String tag, ResponseListener listener, ProgressListener progressListener) {
        super(tag, listener, progressListener);
    }

    @Override
    public void onProgress(long currentBytes, long contentLength, boolean done) {

    }
}
