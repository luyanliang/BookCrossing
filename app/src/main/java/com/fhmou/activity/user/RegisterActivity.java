package com.fhmou.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.fhmou.activity.MainActivity;
import com.fhmou.activity.R;
import com.fhmou.asyncTask.RegisterTask;
import com.fhmou.base.BaseActivity;
import com.fhmou.utils.CleanableEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * package com.fhmou.activity.user
 * functional describe:
 *
 * @version 1.0 16-8-25 下午4:43
 * @auther luyanliang [765673481@qq.com]
 */
public class RegisterActivity extends BaseActivity {

    private Button go_back;
    private Button ensure_button;
    private CleanableEditText Email;
    private CleanableEditText nickname;
    private CleanableEditText signup_password;
    private CleanableEditText weixin;
    private CleanableEditText signup_passwordagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signup);
        ensure_button = (Button) findViewById(R.id.ensure);
        go_back = (Button) findViewById(R.id.button_back);
        go_back.setOnClickListener(this);
        ensure_button.setOnClickListener(this);
        Email = (CleanableEditText) findViewById(R.id.Email_edit);
        nickname = (CleanableEditText) findViewById(R.id.nickname_edit);
        signup_password = (CleanableEditText) findViewById(R.id.password_edit);
        weixin = (CleanableEditText) findViewById(R.id.weixin_edit);
        signup_passwordagain = (CleanableEditText) findViewById(R.id.passwordagain_edit);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                goback();
                break;
            case R.id.ensure:
                ensure();
                break;
            default:
                break;
        }
    }

    private void goback() {
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(intent);
        RegisterActivity.this.finish();
    }
    //确定注册
    private void ensure() {
        // TODO Auto-generated method stub
        String email_S =Email.getText().toString();
        String nickname_S =nickname.getText().toString();
        String signup_password_S =signup_password.getText().toString();
        String weixin_S =weixin.getText().toString();
        String signup_passwordagain_S =signup_passwordagain.getText().toString();

        if(nickname_S.equals("")){
            Toast.makeText(RegisterActivity.this,"昵称不可为空", Toast.LENGTH_LONG).show();
            return;
        }

        if(signup_password_S.equals(signup_passwordagain_S)){
            Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
            Matcher matcher = pattern.matcher(email_S);
            if(matcher.find()){
                //NetWork network = new NetWork(NAME,PASSWORD);
                RegisterTask network = new RegisterTask(email_S,signup_password_S,nickname_S,weixin_S,this);
                network.execute();
            }else{
                Toast.makeText(RegisterActivity.this,"请输入正确邮箱", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(RegisterActivity.this,"请确认密码", Toast.LENGTH_LONG).show();
        }
    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.obj.equals("success")) {
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, MainActivity.class);
                intent.putExtra("username",nickname.getText().toString());
                RegisterActivity.this.startActivity(intent);
                RegisterActivity.this.finish();
            }
        }
    };
}
