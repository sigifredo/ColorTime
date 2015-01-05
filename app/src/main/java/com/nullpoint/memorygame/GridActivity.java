package com.nullpoint.memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;


public class GridActivity extends Activity {

    private int mRows;
    private int mCols;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        Bundle bundle = getIntent().getExtras();

        mGridView = (GridView) findViewById(R.id.gridView);
        mRows = bundle.getInt("rows");
        mCols = bundle.getInt("cols");
    }
}