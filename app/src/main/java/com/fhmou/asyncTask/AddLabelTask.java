package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.fhmou.fragment.LabelFragment;
import com.fhmou.net.Https;

import java.util.HashMap;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:22
 * @auther luyanliang [765673481@qq.com]
 */
public class AddLabelTask extends AsyncTask<String, Integer, Integer> {

    public Https httpAgent = new Https();
    private String labelName ="";
    private String msgBody;
    public HashMap<String, Object> paras = new HashMap<String, Object>();
    private String msgCode = "";
    private LabelFragment labelFragment;

    public AddLabelTask(String _labelName, LabelFragment _labelFragment){
        labelName = _labelName;
        labelFragment = _labelFragment;
    }
    /**
     * 执行任务后调用
     */
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if(msgCode.equals("200")){
            Toast.makeText(labelFragment.getActivity(), "添加成功", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(labelFragment.getActivity(), msgBody, Toast.LENGTH_LONG).show();
        }

    }

    /**
     * 执行任务之前调用
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        paras.put("labelName", labelName);
    }

    /**
     * 执行任务
     */
    @Override
    protected Integer doInBackground(String... arg0) {
        String result = httpAgent.request("api/app/label-add", paras, "");
        try{
            JSONObject mess= JSONObject.parseObject(result);
            msgCode = mess.getString("code");
            msgBody = mess.getString("msg");
        }catch (Exception e) {
            Log.e("book", e.getMessage(),e);
        }
        return null;
    }
}
