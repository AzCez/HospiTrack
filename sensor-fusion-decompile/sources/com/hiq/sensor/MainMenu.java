package com.hiq.sensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {
    public void about(View view) {
        startActivity(new Intent(this, About.class));
    }

    public void exitClick(View view) {
        moveTaskToBack(true);
    }

    public void logClick(View view) {
        startActivity(new Intent(this, LogActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.main);
    }

    public void prefs(View view) {
        startActivity(new Intent(this, Preferences.class));
    }

    public void selectClick(View view) {
        startActivity(new Intent(this, MoreActivity.class));
    }

    public void sensorList(View view) {
        startActivity(new Intent(this, SensorListActivity.class));
    }
}
