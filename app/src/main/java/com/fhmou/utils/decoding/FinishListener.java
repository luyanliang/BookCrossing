package com.fhmou.utils.decoding;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * package com.fhmou.tools.decoding
 * functional describe:
 *
 * @version 1.0 16-8-26 下午1:11
 * @auther luyanliang [765673481@qq.com]
 */
public final class FinishListener
        implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    private final Activity activityToFinish;

    public FinishListener(Activity activityToFinish) {
        this.activityToFinish = activityToFinish;
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    @Override
    public void run() {
        activityToFinish.finish();
    }
}
