package com.nullpoint.memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.nullpoint.memorygame.util.ColorAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class GridActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        Bundle bundle = getIntent().getExtras();

        GridView gridView = (GridView) findViewById(R.id.gridView);
        int rows = bundle.getInt("rows");
        int cols = bundle.getInt("cols");

        gridView.setNumColumns(cols);
        gridView.setHorizontalSpacing(5);
        gridView.setVerticalSpacing(5);
        gridView.setAdapter(new ColorAdapter(this, generateColorList(cols, rows)));
    }

    public static List<Integer> generateColorList(int cols, int rows) {
        List<Integer> colors = new ArrayList<>();
        Set<Integer> order = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Random random = new Random();

        int n = (cols * rows) / 2;

        for (int i = 0; i < n; i++) {
            int newColor = random.nextInt(0x1000000);

            if (!colors.contains(newColor)) {
                colors.add(newColor);
                colors.add(newColor);
            } else
                --i;
        }

        n *= 2;

        while (order.size() != n)
            order.add(random.nextInt(n) + 1);

        for (Integer i: order)
            result.add(colors.get(i - 1));

        return result;
    }
}