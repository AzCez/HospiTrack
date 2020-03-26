package com.hiq.sensor;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoreActivity extends Activity {
    int[] a = new int[20];
    Boolean b;
    private SensorManager c;

    public List<String> a(List<Sensor> list, boolean z) {
        int i;
        Resources resources = getResources();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            switch (list.get(i2).getType()) {
                case f.a.MapAttrs_cameraBearing:
                    i = R.string.ACCELEROMETER;
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    i = R.string.MAGNETIC_FIELD;
                    break;
                case f.a.MapAttrs_cameraTargetLat:
                    i = R.string.GYROSCOPE;
                    break;
                case f.a.MapAttrs_cameraTargetLng:
                    i = R.string.LIGHT;
                    break;
                case f.a.MapAttrs_cameraTilt:
                    i = R.string.PREASSURE;
                    break;
                case f.a.MapAttrs_cameraZoom:
                    i = R.string.TEMPERATURE;
                    break;
                case f.a.MapAttrs_latLngBoundsNorthEastLatitude:
                    i = R.string.PROXIMITY;
                    break;
            }
            arrayList.add(resources.getString(i));
        }
        if (z) {
            arrayList.add(resources.getString(R.string.GPS));
        }
        Collections.sort(arrayList);
        int i3 = 1;
        while (i3 < arrayList.size()) {
            if (((String) arrayList.get(i3 - 1)).equals(arrayList.get(i3))) {
                arrayList.remove(i3);
            } else {
                i3++;
            }
        }
        return arrayList;
    }

    public void a(List<String> list) {
        final Class cls;
        int i;
        int i2;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.availableSensors);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(30, 40, 30, 0);
        Resources resources = getResources();
        for (int i3 = 0; i3 < list.size(); i3++) {
            final Button button = new Button(this);
            button.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            StateListDrawable stateListDrawable = new StateListDrawable();
            if (list.get(i3).equals(resources.getString(R.string.ACCELEROMETER))) {
                i2 = R.drawable.acc;
                i = R.drawable.acc_pressed;
                cls = AccelerationActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.GPS))) {
                i2 = R.drawable.gps;
                i = R.drawable.gps_pressed;
                cls = GpsActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.GYROSCOPE))) {
                i2 = R.drawable.gyro;
                i = R.drawable.gyro_pressed;
                cls = GyroActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.LIGHT))) {
                i2 = R.drawable.light;
                i = R.drawable.light_pressed;
                cls = LightActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.MAGNETIC_FIELD))) {
                i2 = R.drawable.magnetic;
                i = R.drawable.magnetic_pressed;
                cls = MagneticActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.PREASSURE))) {
                i2 = R.drawable.press;
                i = R.drawable.press_pressed;
                cls = PressureActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.PROXIMITY))) {
                i2 = R.drawable.prox;
                i = R.drawable.prox_pressed;
                cls = ProximityActivity.class;
            } else if (list.get(i3).equals(resources.getString(R.string.TEMPERATURE))) {
                i2 = R.drawable.therm;
                i = R.drawable.therm_pressed;
                cls = TemperatureActivity.class;
            } else {
                i2 = R.drawable.empty_more;
                i = R.drawable.empty_more_pressed;
                cls = null;
            }
            if (cls != null) {
                stateListDrawable.addState(new int[]{16842919}, getResources().getDrawable(i));
                stateListDrawable.addState(new int[0], getResources().getDrawable(i2));
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MoreActivity.this.startActivity(new Intent(button.getContext(), cls));
                    }
                });
                button.setBackgroundDrawable(stateListDrawable);
                linearLayout.addView(button);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = true;
        requestWindowFeature(1);
        setContentView(R.layout.more);
        this.c = (SensorManager) getSystemService("sensor");
        if (!((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            this.b = false;
        }
        if (a.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            this.b = false;
        }
        a(a(this.c.getSensorList(-1), this.b.booleanValue()));
    }
}
