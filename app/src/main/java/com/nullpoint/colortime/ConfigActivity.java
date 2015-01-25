package com.nullpoint.colortime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nullpoint.colortime.playservices.PlaceholderFragment;
import com.nullpoint.colortime.util.AbstractListener;

import java.util.ArrayList;
import java.util.List;


public class ConfigActivity extends FragmentActivity {

    private Spinner mColSpinner;
    private Spinner mRowSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment())
            .commit();
        }

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
        Intent intent = new Intent(this, GridActivity.class);

        intent.putExtra("rows", Integer.parseInt((String) mRowSpinner.getSelectedItem()));
        intent.putExtra("cols", Integer.parseInt((String) mColSpinner.getSelectedItem()));

        startActivity(intent);
    }

    public void rowChange(int rows) {
        List<String> cols = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            int items = rows * i;

            if ((items & 1) == 0 && items > 2)
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
