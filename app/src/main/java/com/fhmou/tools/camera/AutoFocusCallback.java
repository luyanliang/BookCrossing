package com.fhmou.tools.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * package com.fhmou.tools.camera
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:50
 * @auther luyanliang [765673481@qq.com]
 */
public final class AutoFocusCallback implements Camera.AutoFocusCallback {

    private static final String TAG = AutoFocusCallback.class.getSimpleName();

    private static final long AUTOFOCUS_INTERVAL_MS = 1500L;

    private Handler autoFocusHandler;
    private int autoFocusMessage;

    void setHandler(Handler autoFocusHandler, int autoFocusMessage) {
        this.autoFocusHandler = autoFocusHandler;
        this.autoFocusMessage = autoFocusMessage;
    }

    @Override
    public void onAutoFocus(boolean b, Camera camera) {
        if (autoFocusHandler != null) {
            Message message = autoFocusHandler.obtainMessage(autoFocusMessage, b);
            autoFocusHandler.sendMessageDelayed(message, AUTOFOCUS_INTERVAL_MS);
            autoFocusHandler = null;
        } else {
            Log.d(TAG, "Got auto-focus callback, but no handler for it");
        }
    }
}
