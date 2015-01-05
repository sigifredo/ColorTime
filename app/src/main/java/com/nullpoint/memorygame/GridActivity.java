package com.nullpoint.memorygame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;

import com.nullpoint.memorygame.util.ColorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


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
        Set<Integer> order = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Random random = new Random();

        int n = (cols * rows) / 2;

        for (int i = 0; i < n; i++) {
            int newColor = random.nextInt(0x1000000);

            if (colors.contains(newColor)) {
                colors.add(newColor);
                colors.add(newColor);
            }
        }

        n *= 2;

        while (order.size() != 2)
            order.add(random.nextInt(n) + 1);

        Iterator<Integer> iterator = order.iterator();
        while (iterator.hasNext())
            result.add(iterator.next());

        return result;
    }
}