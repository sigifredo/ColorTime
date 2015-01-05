package com.nullpoint.memoryg.memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;


public class GridActivity extends Activity {

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mGridView = (GridView) findViewById(R.id.gridView);
    }
}