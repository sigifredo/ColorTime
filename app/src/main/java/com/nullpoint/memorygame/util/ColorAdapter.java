package com.nullpoint.memorygame.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends BaseAdapter {

    private List<Integer> mColors;
    private Context mContext;

    public ColorAdapter(Context context, List<Integer> colors) {
        mContext = context;
        mColors = new ArrayList<>(colors);
    }

    @Override
    public int getCount() {
        return mColors.size();
    }

    @Override
    public Object getItem(int position) {
        return mColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = new View(mContext);
            view.setMinimumHeight(85);
            view.setMinimumWidth(85);
        } else
            view = convertView;

        int color = mColors.get(position);
        view.setBackgroundColor(color);

        return view;
    }
}