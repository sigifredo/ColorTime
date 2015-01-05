package com.nullpoint.memorygame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;

import com.nullpoint.memorygame.util.ColorAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GridActivity extends Activity {

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        Bundle bundle = getIntent().getExtras();

        mGridView = (GridView) findViewById(R.id.gridView);
        int rows = bundle.getInt("rows");
        int cols = bundle.getInt("cols");

        mGridView.setNumColumns(cols);
        mGridView.setAdapter(new ColorAdapter(this, generateColorList(cols, rows)));
    }

    public static List<Integer> generateColorList(int cols, int rows) {

        List<Integer> colors = new ArrayList<>();
        Random random = new Random();

        int colorsAmount = (cols * rows) / 2;

        for (int i = 0; i < colorsAmount; i++) {
            int newColor = random.nextInt(0x1000000);

            if (!colors.contains(newColor)) {
                colors.add(newColor);
                colors.add(newColor);
            }
        }

        return colors;
    }
}