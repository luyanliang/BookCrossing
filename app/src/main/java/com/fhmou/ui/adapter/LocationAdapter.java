package com.fhmou.ui.adapter;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fhmou.activity.R;
import com.fhmou.entity.UserLocation;

import java.util.List;

/**
 * package com.fhmou.ui.adapter
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:33
 * @auther luyanliang [765673481@qq.com]
 */
public class LocationAdapter extends BaseAdapter {

    List<UserLocation> locations ;
    private static LayoutInflater inflater = null;

    public LocationAdapter(List<UserLocation> locations, Fragment activity) {
        super();
        this.locations = locations;
        inflater = (LayoutInflater) activity.getActivity().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.item_location, null);
        TextView textView = (TextView) vi.findViewById(R.id.text_location);
        textView.setText(locations.get(position).getAddress());
        return vi;
    }
    @Override
    public int getCount() {
        return locations.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
