package com.nullpoint.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        startActivity(new Intent(this, ConfigActivity.class));
    }

    public void highScores(View view) {
        startActivity(new Intent(this, HighScoresActivity.class));
    }
}