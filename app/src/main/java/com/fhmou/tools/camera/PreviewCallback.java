package com.fhmou.tools.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * package com.fhmou.tools.camera
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:55
 * @auther luyanliang [765673481@qq.com]
 */
public final class PreviewCallback implements Camera.PreviewCallback {

    private static final String TAG = PreviewCallback.class.getSimpleName();

    private final CameraConfigurationManager configManager;
    private final boolean useOneShotPreviewCallback;
    private Handler previewHandler;
    private int previewMessage;

    PreviewCallback(CameraConfigurationManager configManager, boolean useOneShotPreviewCallback) {
        this.configManager = configManager;
        this.useOneShotPreviewCallback = useOneShotPreviewCallback;
    }

    void setHandler(Handler previewHandler, int previewMessage) {
        this.previewHandler = previewHandler;
        this.previewMessage = previewMessage;
    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {
        Point cameraResolution = configManager.getCameraResolution();
        if (!useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        if (previewHandler != null) {
            Message message = previewHandler.obtainMessage(previewMessage, cameraResolution.x,
                    cameraResolution.y, bytes);
            message.sendToTarget();
            previewHandler = null;
        } else {
            Log.d(TAG, "Got preview callback, but no handler for it");
        }
    }
}
