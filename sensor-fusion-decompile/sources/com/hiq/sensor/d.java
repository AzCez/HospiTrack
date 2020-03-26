package com.hiq.sensor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class d extends Activity implements SensorEventListener {
    c a;
    String b;
    SensorManager c;
    NumberFormat d;
    int e;
    int f;
    int g;
    int h;
    int i;
    String j;

    public d(String str, int i2, int i3, int i4, int i5, int i6, String str2) {
        this.b = str;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = str2;
    }

    public void info(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sensor information");
        builder.setIcon(R.drawable.info);
        builder.setMessage(this.i);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = (SensorManager) getSystemService("sensor");
        this.a = new c(this, Float.valueOf(this.c.getDefaultSensor(this.e).getMaximumRange()), this.f);
        getWindow().addFlags(128);
        setContentView(this.h);
        FrameLayout frameLayout = (FrameLayout) findViewById(this.g);
        frameLayout.addView(this.a, 0);
        this.a.a(frameLayout, this.b);
        this.d = new DecimalFormat("##0.0");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.a.b();
        this.c.unregisterListener(this);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.a.e) {
            this.a.a();
        }
        super.onResume();
        g.a(getApplicationContext());
        double parseInt = (double) Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("frequency", "100"));
        Double.isNaN(parseInt);
        int round = (int) Math.round(1000000.0d / parseInt);
        SensorManager sensorManager = this.c;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(this.e), round);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        double d2;
        NumberFormat numberFormat;
        TextView textView;
        this.a.a(e.a(sensorEvent));
        if (this.f == 3) {
            ((TextView) findViewById(R.id.X_value)).setText(this.d.format((double) sensorEvent.values[0]));
            ((TextView) findViewById(R.id.Y_value)).setText(this.d.format((double) sensorEvent.values[1]));
            ((TextView) findViewById(R.id.Z_value)).setText(this.d.format((double) sensorEvent.values[2]));
            ((TextView) findViewById(R.id.units)).setText(this.j);
            textView = (TextView) findViewById(R.id.norm);
            numberFormat = this.d;
            d2 = Math.sqrt(Math.pow((double) sensorEvent.values[0], 2.0d) + Math.pow((double) sensorEvent.values[1], 2.0d) + Math.pow((double) sensorEvent.values[2], 2.0d));
        } else {
            ((TextView) findViewById(R.id.units_single)).setText(this.j);
            textView = (TextView) findViewById(R.id.norm_single);
            numberFormat = this.d;
            d2 = (double) sensorEvent.values[0];
        }
        textView.setText(numberFormat.format(d2));
    }

    public void prefs(View view) {
        startActivity(new Intent(this, Preferences.class));
    }
}
