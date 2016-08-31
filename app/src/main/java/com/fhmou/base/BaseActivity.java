package com.fhmou.base;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.fhmou.activity.R;
import com.fhmou.net.okhttp.ResponseListener;
import com.fhmou.ui.dialog.DialogProgress;

/**
 * package com.fhmou.base
 * functional describe:
 *
 * @version 1.0 16-8-30 下午1:54
 * @auther luyanliang [765673481@qq.com]
 */
public abstract class BaseActivity extends FragmentActivity
        implements ResponseListener, View.OnClickListener {

    private DialogProgress loadingDialog;

    @Override
    public void onFailure(int j) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 隐藏对话框
     */
    protected void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.hide();
        }
    }

    /**
     * 显示对话框
     */
    protected void showLoadingDialog() {
        showLoadingDialog(R.string.get_data);
    }

    protected void showLoadingDialog(int resId) {
        showLoadingDialog(getString(resId));
    }

    protected void showLoadingDialog(String message) {
        if (loadingDialog == null) {
            loadingDialog = new DialogProgress(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
        loadingDialog.setMsg(message);
    }
}
