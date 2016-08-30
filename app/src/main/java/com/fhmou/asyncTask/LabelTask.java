package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fhmou.tools.json.AbstractObject;
import com.fhmou.entity.Label;
import com.fhmou.adapter.LabelAdapter;
import com.fhmou.fragment.LabelFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * package com.fhmou.asyncTask
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:04
 * @auther luyanliang [765673481@qq.com]
 */
public class LabelTask extends AsyncTask<String, Integer, Integer> {

    public HashMap<String, Object> paras = new HashMap<String, Object>();
    private String msgCode = "";
    private LabelFragment labelFragment;
    private LabelAdapter adapter;
    private List<Label> labelList = null;
    public LabelTask(LabelFragment _labelFragment) {
        labelFragment = _labelFragment;
    }

    /**
     * 执行任务后调用
     */
    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if (!msgCode.equals("200")) {
            Toast.makeText(labelFragment.getActivity(), "网络错误",
                    Toast.LENGTH_LONG).show();
            return;
        }
        labelFragment.setLabelList(labelList);
        if (labelList ==null  ||labelList.size()==0) {
            Toast.makeText(labelFragment.getActivity(), "分享，让知识不在孤单！",
                    Toast.LENGTH_LONG).show();
        }
        adapter = new LabelAdapter(labelFragment, labelList);
        labelFragment.getGridView().setAdapter(adapter);

    }


    @Override
    protected Integer doInBackground(String... arg0) {
//        String result = httpAgent.request("api/app/labels", paras, "");
//        labelList = parseLableList(result);
        return null;
    }
    private List<Label> parseLableList(String result) {
        List<Label> labels = new ArrayList<Label>();
        JSONArray jsonResult = null;
        try {
            JSONObject mess = JSONObject.parseObject(result);
            msgCode = mess.getString("code");
            jsonResult = mess.getJSONArray("msg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; jsonResult !=null && i < jsonResult.size(); i++) {
            try {
                Label label = AbstractObject.String2Object(jsonResult
                        .getJSONObject(i).toString(), Label.class);
                labels.add(label);
            } catch (JSONException e) {
                Log.e("book", e.getMessage(), e);
            }
        }
        return labels;
    }
}
