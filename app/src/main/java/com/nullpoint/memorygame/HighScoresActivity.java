package com.nullpoint.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class HighScoresActivity extends Activity {

    private ListView mScoreList;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        mScoreList = (ListView) findViewById(R.id.scoreList);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.messageLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // verificar que exista lista de puntuaciones
        if (false) {
            mRelativeLayout.setVisibility(View.INVISIBLE);
        } else // sino existe lista de puntuaciones
            mScoreList.setVisibility(View.INVISIBLE);

        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
    }

    public void playGame(View view) {
        startActivity(new Intent(this, ConfigActivity.class));
    }
}