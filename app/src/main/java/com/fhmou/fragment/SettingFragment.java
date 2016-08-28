package com.fhmou.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fhmou.activity.R;

/**
 * package com.fhmou.fragment
 * functional describe:
 *
 * @version 1.0 16-8-26 上午10:58
 * @auther luyanliang [765673481@qq.com]
 */
public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container,
                false);
        return rootView;

    }
}
