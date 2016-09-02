package com.fhmou.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.fhmou.activity.GuideActivity;
import com.fhmou.activity.MainActivity;
import com.fhmou.activity.R;
import com.fhmou.base.BaseActivity;
import com.fhmou.utils.CleanableEditText;
import com.fhmou.utils.SPUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * package com.fhmou.tools
 * functional describe: 登录页面
 *
 * @auther luyanliang [765673481@qq.com]
 * @version 1.0 2016-08-25 16:03
 */
public class LoginActivity extends BaseActivity {

    private Button login_button;
    private Button signup_button;
    private CleanableEditText user_name;
    private CleanableEditText user_password;

    public String nickName = "";

    private void initLoginView() {
        login_button = (Button) findViewById(R.id.signin_button);
        signup_button = (Button) findViewById(R.id.signup_button);
        login_button.setOnClickListener(this);
        signup_button.setOnClickListener(this);
        user_name = (CleanableEditText) findViewById(R.id.username_edit);
        user_password = (CleanableEditText) findViewById(R.id.password_edit);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SPUtils.getBoolean(SPUtils.Impl.FLAG_IS_FIRST, true)) {
            startActivity(new Intent(this, GuideActivity.class));
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_login);
            initLoginView();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_button:
                signIn();
                break;
            case R.id.signup_button:
                signUp();
                break;
            default:
                break;
        }
    }

    /**
     * 登录
     */
    private void signIn() {
        String userName = user_name.getText().toString().trim();
        String password = user_password.getText().toString().trim();
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(userName);
        if(matcher.find()) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, LoginTransitActivity.class);
            intent.putExtra("userName",userName);
            intent.putExtra("password",password);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(LoginActivity.this,"请输入正确邮箱", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 注册
     */
    private void signUp() {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public Handler handler=	new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if("success".equals(msg.obj)) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", nickName);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    public void onFailure(int paramInt, String paramString1, String paramString2) {

    }

    @Override
    public void onSuccess(String paramString, Object paramObject) {

    }
}
