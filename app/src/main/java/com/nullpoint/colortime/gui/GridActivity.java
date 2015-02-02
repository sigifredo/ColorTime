package com.nullpoint.colortime.gui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;

import com.nullpoint.colortime.R;
import com.nullpoint.colortime.util.ColorAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GridActivity extends Activity implements AdapterView.OnItemClickListener {

    private ColorView mColorViews[];
    private Chronometer mChronometer;
    private List<Integer> mColorList;
    private int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mColorViews = new ColorView[2];

        Bundle bundle = getIntent().getExtras();

        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        int rows = bundle.getInt("rows");
        int cols = bundle.getInt("cols");

        gridView.setNumColumns(cols);
        gridView.setHorizontalSpacing(5);
        gridView.setVerticalSpacing(5);
        gridView.setAdapter(new ColorAdapter(this, rows * cols));
        gridView.setOnItemClickListener(this);

        mColorList = generateColorList(cols, rows);
        mChronometer.start();
    }

    protected void countPoint() {
        mPoints += 2;

        if (mPoints == mColorList.size()) {
            Intent intent = new Intent(this, GameOverActivity.class);
            mChronometer.stop();
            startActivity(intent);
            finish();
        }
    }

    public static List<Integer> generateColorList(int cols, int rows) {
        List<Integer> colors = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Random random = new Random();

        int n = (cols * rows) / 2;

        for (int i = 0; i < n; i++) {
            int newColor = random.nextInt(0x1000000) | 0xff000000;

            if (!colors.contains(newColor)) {
                colors.add(newColor);
                colors.add(newColor);
            } else
                --i;
        }

        n *= 2;

        while (order.size() != n) {
            int r = random.nextInt(n) + 1;
            if (!order.contains(r))
                order.add(r);
        }

        for (Integer i: order)
            result.add(colors.get(i - 1));

        return result;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ColorView colorView = (ColorView) view;

        if (colorView.getBackgroundColor() != ColorAdapter.TRANSPARENT_COLOR) {

            if (mColorViews[0] == null || mColorViews[1] == null) {
                colorView.setBackgroundColor(mColorList.get(position));

                if (mColorViews[0] == null)
                    mColorViews[0] = colorView;
                else if (mColorViews[0] != colorView) {
                    if (mColorViews[0].getBackgroundColor() == colorView.getBackgroundColor())
                        countPoint();

                    mColorViews[1] = colorView;
                }

            } else {
                int color;

                if (mColorViews[0].getBackgroundColor() == mColorViews[1].getBackgroundColor())
                    color = ColorAdapter.TRANSPARENT_COLOR;
                else
                    color = ColorAdapter.BACKGROUND_COLOR;

                mColorViews[0].setBackgroundColor(color);
                mColorViews[1].setBackgroundColor(color);

                if (color == ColorAdapter.TRANSPARENT_COLOR && (colorView == mColorViews[0] || colorView == mColorViews[1])) {
                    mColorViews[0] = null;
                }
                else {
                    colorView.setBackgroundColor(mColorList.get(position));
                    mColorViews[0] = colorView;
                }

                mColorViews[1] = null;
            }
        }
    }
}
