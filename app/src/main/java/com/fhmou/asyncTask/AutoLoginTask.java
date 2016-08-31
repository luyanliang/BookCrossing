package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.fhmou.activity.StartActivity;
import com.fhmou.net.Https;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 上午10:47
 * @auther luyanliang [765673481@qq.com]
 */
public class AutoLoginTask extends AsyncTask<String, Integer, Integer> {

    public HashMap<String, Object> paras = new HashMap<String, Object>();
    private StartActivity startActivity;

    public String msgCode = "";
    private String userEmail = "";
    private String password = "";
    private JSONObject msgBody;


    public AutoLoginTask(String _userEmail, String _password, StartActivity _startActivity) {
        userEmail=_userEmail;
        password =_password;
        startActivity = _startActivity;
    }

    /**
     * 执行任务后调用
     */
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if(msgCode.equals("200")){
            Message msg = Message.obtain();
            msg.obj = "success";
            try {
                startActivity.setNickName(msgBody.getString("userName"));
            }catch (Exception e ){
                Log.e("book", e.getMessage(), e);
            }
            startActivity.handler.sendMessage(msg);
        }else{
            Toast.makeText(startActivity, "请检查网络连接和密码账号的正确性！", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 执行任务之前调用
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        paras.put("email", userEmail);
        paras.put("passwd", password);
    }

    /**
     * 执行任务
     */
    @Override
    protected Integer doInBackground(String... arg0) {
        return null;
    }
}
