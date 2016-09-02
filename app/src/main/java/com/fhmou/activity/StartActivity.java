package com.fhmou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.fhmou.activity.user.LoginActivity;
import com.fhmou.base.AppApplication;
import com.fhmou.base.BaseActivity;
import com.fhmou.net.AppApis;
import com.fhmou.utils.SPUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * package com.fhmou.activity
 * functional describe: APP启动页
 *
 * @version 1.0 16-8-26 上午10:40
 * @auther luyanliang [765673481@qq.com]
 */
public class StartActivity extends BaseActivity
        implements Animation.AnimationListener {

    public ImageView logo;
    private int alphaDuration = 500;

    private boolean hasLogin = false;
    public boolean isFirstIn;
    private View startView;

    /**
     * 如果登录，则直接进入首页，否则进去登录页进行登录
     */
    private void enter() {
        if (hasLogin) {
            goHomeActivity();
        } else {
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startView = findViewById(R.id.root);
        logo = (ImageView) findViewById(R.id.welcome_logo);
        AlphaAnimation animation = new AlphaAnimation(0.0F, 1.0F);
        animation.setDuration(alphaDuration);
        animation.setFillAfter(true);
        animation.setAnimationListener(this);
        startView.setAnimation(animation);
        animation.startNow();
    }

    private void initLoginStatus() {
        isFirstIn = SPUtils.getBoolean(SPUtils.Impl.FLAG_IS_FIRST, true);
        if (StringUtils.isNotBlank(SPUtils.Impl.getUid()) && StringUtils.isNotBlank(SPUtils.Impl.getToken())) {
            if (StringUtils.isNotBlank(SPUtils.Impl.getUrlFaceIcon())) {
                hasLogin = true;
            } else {
                AppApis.getUserInfo(SPUtils.Impl.getUid(), this);
            }
        } else {
            hasLogin = false;
        }
        enter();
    }

    /**
     * 登录后的首页
     */
    protected void goHomeActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        AppApplication.getInstance().exitAll();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFailure(int paramInt, String paramString1, String paramString2) {

    }

    @Override
    public void onSuccess(String paramString, Object paramObject) {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        initLoginStatus();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
