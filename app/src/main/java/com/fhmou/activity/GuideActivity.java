package com.fhmou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.fhmou.activity.user.LoginActivity;
import com.fhmou.base.BaseActivity;
import com.fhmou.utils.SPUtils;

/**
 * package com.fhmou.activity
 * functional describe: 首次启动引导页
 *
 * @version 1.0 16-9-2 下午12:18
 * @auther luyanliang [765673481@qq.com]
 */
public class GuideActivity extends BaseActivity {

    public ImageView logo;

    private void goLoginActivity() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        logo = (ImageView) findViewById(R.id.guide);
        logo.setImageResource(R.mipmap.start);
    }

    @Override
    public void onClick(View view) {
        SPUtils.putBoolean(SPUtils.Impl.FLAG_IS_FIRST, false);
        goLoginActivity();
    }

    @Override
    public void onFailure(int paramInt, String paramString1, String paramString2) {

    }

    @Override
    public void onSuccess(String paramString, Object paramObject) {

    }
}
