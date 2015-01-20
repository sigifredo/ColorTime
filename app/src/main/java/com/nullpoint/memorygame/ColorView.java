package com.nullpoint.memorygame;

import android.content.Context;
import android.view.View;

import com.nullpoint.memorygame.util.ColorAdapter;

public class ColorView extends View {

    private int mColor;

    public ColorView(Context context) {
        super(context);

        setBackgroundColor(ColorAdapter.BACKGROUND_COLOR);
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        mColor = color;
    }

    public int getBackgroundColor() {
        return mColor;
    }
}