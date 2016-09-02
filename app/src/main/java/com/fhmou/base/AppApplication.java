package com.fhmou.base;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * package com.fhmou.base
 * functional describe:
 *
 * @version 1.0 16-9-1 上午9:36
 * @auther luyanliang [765673481@qq.com]
 */
public class AppApplication extends Application
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static volatile AppApplication instance;
    public String TOKEN;
    public String UID;
    public String URL_FACE_ICON;
    private ArrayList<Activity> records;

    public static AppApplication getInstance() {
        return instance;
    }

    public void addActvity(Activity paramActivity) {
        if (records == null) {
            records = new ArrayList();
        }
        records.add(paramActivity);
    }

    public void exitAll() {
        if (this.records != null) {
            Iterator<Activity> iterator = records.iterator();
            while (iterator.hasNext()) {
                (iterator.next()).finish();
            }
            records.clear();
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
