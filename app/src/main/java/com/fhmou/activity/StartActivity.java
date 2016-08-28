package com.fhmou.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.fhmou.activity.user.LoginActivity;
import com.fhmou.asyncTask.AutoLoginTask;

import org.apache.commons.lang3.StringUtils;

/**
 * package com.fhmou.activity
 * functional describe: 欢迎页
 *
 * @version 1.0 16-8-26 上午10:40
 * @auther luyanliang [765673481@qq.com]
 */
public class StartActivity extends Activity {

    public ImageView image;

    public boolean isFirstIn;
    public String username;
    public String password;
    private SharedPreferences preferences;
    private String nickName;

    private static final int GO_HOME = 1;
    private static final int GO_GUIDE = 2;
    private static final String SHAREDPREFERENCES_NAME = "cloud";
    private static final long DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        init();
    }

    private void init() {
        preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn", true);
        password = preferences.getString("password", "");
        username = preferences.getString("username", "");

        if(StringUtils.isNotBlank(password) || StringUtils.isNotBlank(username)) {
            try {
                AutoLoginTask asyTask = new AutoLoginTask(username, password, this);
                asyTask.execute();
            } catch (Exception e) {
                Log.e("book", e.getMessage(), e);
            }
        } else if (!isFirstIn) {
            handler.sendEmptyMessage(GO_HOME);
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstIn", false);
            editor.commit();
            handler.sendEmptyMessage(GO_GUIDE);
        }

    }

    public Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            if (msg.obj != null && msg.obj.equals("success")) {
                Intent intent = new Intent();
                intent.setClass(StartActivity.this, MainActivity.class);
                intent.putExtra("username", getNickName());
                StartActivity.this.startActivity(intent);
                try {
                    Thread.sleep(666);
                } catch (InterruptedException e) {
                    Log.e("book", e.getMessage(), e);
                }
                StartActivity.this.finish();
            }
        }
    };

    protected void goHome() {
        Intent intent = new Intent();
        intent.setClass(StartActivity.this, LoginActivity.class);
        this.startActivity(intent);
        try {
            Thread.sleep(666);
        } catch (Exception e) {
            Log.e("book", e.getMessage(), e);
        }
        finish();
    }

    /**
     * 首次启动引导页
     */
    protected void goGuide() {
        setContentView(R.layout.activity_start);
        image = (ImageView) findViewById(R.id.guide);
        image.setImageResource(R.mipmap.start);
        handler.sendEmptyMessageDelayed(GO_HOME, DELAY_MILLIS);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
