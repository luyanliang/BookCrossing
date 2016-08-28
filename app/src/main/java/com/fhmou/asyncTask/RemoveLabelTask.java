package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fhmou.fragment.LabelFragment;
import com.fhmou.http.HttpAgent;

import java.util.HashMap;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:36
 * @auther luyanliang [765673481@qq.com]
 */
public class RemoveLabelTask extends AsyncTask<String, Integer, Integer> {

    private LabelFragment labelFragment;

    public RemoveLabelTask(LabelFragment labelFragment) {
        super();
        this.labelFragment = labelFragment;
    }

    @Override
    protected Integer doInBackground(String... arg0) {
        HttpAgent httpAgent = new HttpAgent();
        HashMap<String, Object> paras = new HashMap<String, Object>();
        paras.put("labelId", arg0[0]);
        String result = httpAgent.request("api/app/label-remove", paras, "");

        JSONObject jsonObject;
        int msgCode = 500;
        try {
            jsonObject = JSONObject.parseObject(result);
            msgCode = jsonObject.getIntValue("code");
        } catch (JSONException e) {
            Log.e("book", e.getMessage(),e);
        }

        return msgCode;
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if(result == 500){
            Toast.makeText(labelFragment.getActivity(), "删除失败",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(labelFragment.getActivity(), "删除成功",
                    Toast.LENGTH_LONG).show();
            labelFragment.showLableList();
        }
    }
}
