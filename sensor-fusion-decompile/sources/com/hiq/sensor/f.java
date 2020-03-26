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
import android.view.View;
import android.widget.TextView;

public class f extends Activity implements SensorEventListener {
    private SensorManager a;
    private TextView b;
    private TextView c;
    private String d;
    private int e;
    private int f;
    private String g;

    public f(String str, int i, int i2, String str2) {
        this.d = str;
        this.e = i;
        this.f = i2;
        this.g = str2;
    }

    public void info(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sensor information");
        builder.setIcon(R.drawable.info);
        builder.setMessage(this.f);
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

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (SensorManager) getSystemService("sensor");
        setContentView(R.layout.textlayout);
        this.b = (TextView) findViewById(R.id.sensor_Type);
        this.b.setText(this.d);
        this.c = (TextView) findViewById(R.id.sensor_Value);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.a.unregisterListener(this);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SensorManager sensorManager = this.a;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(this.e), 3);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        TextView textView;
        String str;
        if (this.g.equals("Near/Far")) {
            if (sensorEvent.values[0] > 0.0f) {
                textView = this.c;
                str = "Far";
            } else {
                textView = this.c;
                str = "Near";
            }
            textView.setText(str);
            return;
        }
        TextView textView2 = this.c;
        textView2.setText(String.valueOf(sensorEvent.values[0]) + this.g);
    }

    public void prefs(View view) {
        startActivity(new Intent(this, Preferences.class));
    }
}
