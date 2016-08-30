package com.fhmou.asyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.fhmou.entity.UserLocation;
import com.fhmou.adapter.LocationAdapter;
import com.fhmou.fragment.LocationFragment;
import com.fhmou.net.Https;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyLocationsTask extends AsyncTask<String, Integer, List<UserLocation>> {

	private LocationFragment fragment;
	
	public MyLocationsTask(LocationFragment fragment) {
		super();
		this.fragment = fragment;
	}
	@Override
	protected void onPostExecute(List<UserLocation> result) {
		super.onPostExecute(result);
		if(code ==500){
			Toast.makeText( fragment.getActivity(),"就这网络，也是醉了！", Toast.LENGTH_SHORT).show();
		}else{
			LocationAdapter adapter = new LocationAdapter(result, fragment);
			fragment.getLoclistView().setAdapter(adapter);
		}
	}
	Integer code = 500;
	@Override
	protected List<UserLocation> doInBackground(String... params) {
		Https httpAgent = new Https();
		String result = httpAgent.request("api/app/user-locations", null, "");
		List<UserLocation> list = parseReustl(result);
		return list;
	}
	private List<UserLocation> parseReustl(String result) {
		List<UserLocation> list = null;
		try {
			JSONObject jsonResult = new JSONObject(result);
			code = jsonResult.getInt("code");
			if(code==500)return null;
			list = JSON.parseArray(jsonResult.getString("msg"), UserLocation.class);
		} catch (JSONException e) {
			Log.e("book", e.getMessage(), e);
		}
		return list;
	}



	

}
