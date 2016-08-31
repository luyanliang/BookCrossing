package com.fhmou.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.fhmou.activity.R;

/**
 * package com.fhmou.ui.dialog
 * functional describe: 复写对话框
 *
 * @version 1.0 16-8-31 下午4:53
 * @auther luyanliang [765673481@qq.com]
 */
public class DialogProgress extends Dialog {

    private TextView textView;

    public DialogProgress(Context context) {
        super(context, R.style.customDialog);
        setContentView(R.layout.dialog_progress);
        textView = (TextView) findViewById(R.id.progress_message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);  // 设置Dialog点击屏幕不消失
    }

    public void setMsg(String msg) {
        textView.setText(msg);
    }
}
