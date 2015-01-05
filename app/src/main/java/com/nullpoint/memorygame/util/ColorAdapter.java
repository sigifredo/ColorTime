package com.nullpoint.memorygame.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.nullpoint.memorygame.R;

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
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setMinimumHeight(85);
            imageView.setMinimumWidth(85);
            // imageView.setAdjustViewBounds(true);
        } else
            imageView = (ImageView) convertView;

        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setBackgroundColor(mColors.get(position));

        return imageView;
    }
}