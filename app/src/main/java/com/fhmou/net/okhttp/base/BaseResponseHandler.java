package com.fhmou.net.okhttp.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RecoverySystem;

import com.fhmou.net.okhttp.ResponseListener;
import com.fhmou.net.okhttp.progress.ProgressInfo;
import com.fhmou.net.okhttp.progress.listener.ProgressListener;

import java.lang.ref.WeakReference;

/**
 * package com.fhmou.net.okhttp.base
 * functional describe:
 *
 * @version 1.0 16-8-30 下午2:17
 * @auther luyanliang [765673481@qq.com]
 */
public abstract class BaseResponseHandler extends Handler {

    public static final int FAILURE = 8;
    public static final int START = 1;
    public static final int SUCCESS = 4;
    public static final int UPDATE = 2;

    protected String mBaseUrl;
    protected ProgressListener mProgress;
    protected final WeakReference<ResponseListener> mResponseListener;

    public BaseResponseHandler(String tag, ResponseListener listener) {
        super(Looper.getMainLooper());
        this.mBaseUrl = tag;
        mResponseListener = new WeakReference<ResponseListener>(listener);
    }

    public BaseResponseHandler(String tag, ResponseListener listener, ProgressListener progressListener) {
        this(tag, listener);
        this.mProgress = progressListener;
    }

    @Override
    public void handleMessage(Message message) {
        ResponseListener listener = mResponseListener.get();
        if (mProgress != null) {
            ProgressInfo info = (ProgressInfo) message.obj;
            if (info != null) {
                mProgress.onProgress(info.getCurrentBytes(), info.getContentLength(), info.isDone());
            }
        }
        listener.onSuccess(mBaseUrl, message.obj);
        listener.onFailure(message.arg1, mBaseUrl, message.obj.toString());
    }

}
