package com.nullpoint.colortime.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nullpoint.colortime.ColorView;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends BaseAdapter {

    public static final int BACKGROUND_COLOR = 0xff000000;
    public static final int TRANSPARENT_COLOR = 0x0;
    private Context mContext;
    /**
     * Size of the color list.
     */
    private int mNumColors;

    /**
     * Default constructor.
     *
     * @param context context of the adapter.
     * @param numColors Size of the color list.
     */
    public ColorAdapter(Context context, int numColors) {
        mContext = context;
        mNumColors = numColors;
    }

    @Override
    public int getCount() {
        return mNumColors;
    }

    @Override
    public Object getItem(int position) {
        return BACKGROUND_COLOR;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = new ColorView(mContext);
            view.setMinimumHeight(85);
            view.setMinimumWidth(85);
        } else
            view = convertView;

        return view;
    }
}
