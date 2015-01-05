package com.nullpoint.memoryg.memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nullpoint.memoryg.memorygame.util.AbstractListener;

import java.util.ArrayList;
import java.util.List;


public class ConfigActivity extends Activity {

    private Spinner mColSpinner;
    private Spinner mRowSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        mRowSpinner = (Spinner) findViewById(R.id.rowSpinner);
        mColSpinner = (Spinner) findViewById(R.id.colSpinner);

        List<String> rows = new ArrayList<>();

        for (int i = 2; i < 9; i++)
            rows.add("" + i);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rows);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mRowSpinner.setAdapter(adapter);

        mRowSpinner.setOnItemSelectedListener(new ItemSelectedListener(this));
    }

    public void playGame(View view) {
        Toast.makeText(this, R.string.not_implemented_yet, Toast.LENGTH_SHORT).show();
    }

    public void rowChange(int rows) {
        Toast.makeText(this, "" + rows, Toast.LENGTH_SHORT).show();

        List<String> cols = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            int items = rows * i;

            if ((items & 1) == 0)
                cols.add("" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cols);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColSpinner.setAdapter(adapter);
        mColSpinner.setSelection(0);
    }

    class ItemSelectedListener extends AbstractListener<ConfigActivity> implements AdapterView.OnItemSelectedListener {

        public ItemSelectedListener(ConfigActivity parent) {
            super(parent);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            getParent().rowChange(Integer.parseInt((String) parent.getItemAtPosition(position)));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}