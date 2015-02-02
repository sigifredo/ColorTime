package com.nullpoint.colortime.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.nullpoint.colortime.R;


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

    public void showAbout(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CharSequence message;

        try {
            PackageInfo packageInfo;
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            message = getString(R.string.version) + packageInfo.versionName + "\n" +
                      getString(R.string.powered_by_np);
        } catch (PackageManager.NameNotFoundException e) {
            message = getString(R.string.app_name);
        }

        builder.setTitle(R.string.app_name)
        .setIcon(R.drawable.ic_launcher)
        .setMessage(message)
        .setPositiveButton(android.R.string.yes, null);

        builder.create().show();
    }
}