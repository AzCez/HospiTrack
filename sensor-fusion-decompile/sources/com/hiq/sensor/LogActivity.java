package com.hiq.sensor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.b.b;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.hendeby.sfapp.LogService;
import se.hendeby.sfapp.a;

public class LogActivity extends Activity {
    private List<String> a = null;
    /* access modifiers changed from: private */
    public ToggleButton b;
    private SensorManager c;
    /* access modifiers changed from: private */
    public ListView d;
    /* access modifiers changed from: private */
    public boolean e = true;
    /* access modifiers changed from: private */
    public boolean f = false;
    private List<String> g = null;
    /* access modifiers changed from: private */
    public Map<String, Sensor> h = null;
    private SharedPreferences i;
    /* access modifiers changed from: private */
    public a j;

    private Map<String, Sensor> c() {
        int i2;
        Resources resources = getResources();
        this.c = (SensorManager) getSystemService("sensor");
        List<Sensor> sensorList = this.c.getSensorList(-1);
        HashMap hashMap = new HashMap();
        for (Sensor next : sensorList) {
            if (next == this.c.getDefaultSensor(next.getType())) {
                switch (next.getType()) {
                    case f.a.MapAttrs_cameraBearing:
                        i2 = R.string.ACCELEROMETER;
                        break;
                    case f.a.MapAttrs_cameraMaxZoomPreference:
                        i2 = R.string.MAGNETIC_FIELD;
                        break;
                    case f.a.MapAttrs_cameraTargetLat:
                        i2 = R.string.GYROSCOPE;
                        break;
                    case f.a.MapAttrs_cameraTargetLng:
                        i2 = R.string.LIGHT;
                        break;
                    case f.a.MapAttrs_cameraTilt:
                        i2 = R.string.PREASSURE;
                        break;
                    case f.a.MapAttrs_cameraZoom:
                        i2 = R.string.TEMPERATURE;
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLatitude:
                        i2 = R.string.PROXIMITY;
                        break;
                    case f.a.MapAttrs_latLngBoundsSouthWestLongitude:
                        i2 = R.string.ORIENTATION;
                        break;
                    case f.a.MapAttrs_uiCompass:
                        i2 = R.string.MAGNETIC_FIELD_UNCALIBRATED;
                        break;
                    case f.a.MapAttrs_uiRotateGestures:
                        i2 = R.string.GYROSCOPE_UNCALIBRATED;
                        break;
                }
                hashMap.put(resources.getString(i2), next);
            }
        }
        if (android.support.v4.app.a.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            hashMap.put(resources.getString(R.string.GPS), (Object) null);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            hashMap.put(resources.getString(R.string.RSS_BLE), (Object) null);
        }
        hashMap.put(resources.getString(R.string.RSS_CELL), (Object) null);
        hashMap.put(resources.getString(R.string.RSS_WIFI), (Object) null);
        return hashMap;
    }

    public void ToggleLogService(View view) {
        if (((ToggleButton) view).isChecked()) {
            this.g = new ArrayList();
            if (this.j.b()) {
                Toast.makeText(getApplicationContext(), "Service already running", 0).show();
                return;
            }
            SparseBooleanArray checkedItemPositions = this.d.getCheckedItemPositions();
            for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
                if (checkedItemPositions.get(checkedItemPositions.keyAt(i2))) {
                    this.g.add(this.d.getItemAtPosition(checkedItemPositions.keyAt(i2)).toString());
                }
            }
            if (this.e || this.f) {
                startService(new Intent(this, LogService.class));
                this.j.a(this.e, this.f);
                return;
            }
            Toast.makeText(getApplicationContext(), "Please select at least one sensor and one target", 1).show();
            a(false);
            return;
        }
        this.j.a();
        stopService(new Intent(this, LogService.class));
    }

    public void a() {
        ArrayAdapter arrayAdapter = (ArrayAdapter) this.d.getAdapter();
        for (int i2 = 0; i2 < arrayAdapter.getCount(); i2++) {
            String str = (String) arrayAdapter.getItem(i2);
            boolean isItemChecked = this.d.isItemChecked(i2);
            if (this.h.get(str) != null) {
                this.j.a(this.h.get(str), isItemChecked);
            } else {
                this.j.a(str.toString(), isItemChecked);
            }
        }
    }

    public void a(final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                LogActivity.this.b.setChecked(z);
                View findViewById = LogActivity.this.findViewById(R.id.streamRadio);
                findViewById.setEnabled(!z);
                findViewById.setClickable(!z);
                View findViewById2 = LogActivity.this.findViewById(R.id.logRadio);
                findViewById2.setEnabled(!z);
                findViewById2.setClickable(!z);
            }
        });
    }

    public void b() {
        TextView textView = (TextView) findViewById(R.id.outputInfo);
        String str = new String("");
        if (this.e) {
            str = str + "<b>Target:</b> " + this.i.getString("ip", "0.0.0.0") + ":" + this.i.getString("port", "3400");
            if (this.f) {
                str = str + "<br>";
            }
        }
        if (this.f) {
            str = str + "<b>Log file:</b> " + this.i.getString("logfile", getString(R.string.logfile_default));
        }
        textView.setText(Html.fromHtml(str));
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.j = new a(this);
        bindService(new Intent(this, LogService.class), this.j, 1);
        requestWindowFeature(1);
        setContentView(R.layout.stream);
        this.i = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.g = new ArrayList(this.i.getStringSet("checkedSensors", new b()));
        this.e = this.i.getBoolean("doStream", false);
        CheckBox checkBox = (CheckBox) findViewById(R.id.streamRadio);
        checkBox.setChecked(this.e);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = LogActivity.this.e = z;
                LogActivity.this.b();
            }
        });
        this.f = this.i.getBoolean("doLog", false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.logRadio);
        if (android.support.v4.app.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.f = false;
            checkBox2.setEnabled(false);
        }
        checkBox2.setChecked(this.f);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = LogActivity.this.f = z;
                LogActivity.this.b();
            }
        });
        this.b = (ToggleButton) findViewById(R.id.streamButton);
        if (this.h == null) {
            this.h = c();
            this.a = new ArrayList(this.h.keySet());
            Collections.sort(this.a);
        }
        this.d = (ListView) findViewById(R.id.sensorList);
        final String string = getResources().getString(R.string.GPS);
        this.d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CharSequence text = ((TextView) view).getText();
                boolean isItemChecked = LogActivity.this.d.isItemChecked(i);
                if (text.equals(string) && isItemChecked && !((LocationManager) LogActivity.this.getSystemService("location")).isProviderEnabled("gps")) {
                    isItemChecked = false;
                    new a(this).show();
                }
                Sensor sensor = (Sensor) LogActivity.this.h.get(text);
                if (sensor != null) {
                    LogActivity.this.j.a(sensor, isItemChecked);
                } else {
                    LogActivity.this.j.a(text.toString(), isItemChecked);
                }
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367056, this.a);
        this.d.setAdapter(arrayAdapter);
        if (this.g != null) {
            for (int i2 = 0; i2 < arrayAdapter.getCount(); i2++) {
                String str = (String) arrayAdapter.getItem(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.g.size()) {
                        z = false;
                        break;
                    } else if (str.equals(this.g.get(i3))) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                this.d.setItemChecked(i2, z);
            }
        }
    }

    public void onDestroy() {
        unbindService(this.j);
        this.g = new ArrayList();
        SparseBooleanArray checkedItemPositions = this.d.getCheckedItemPositions();
        for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
            if (checkedItemPositions.get(checkedItemPositions.keyAt(i2))) {
                this.g.add(this.d.getItemAtPosition(checkedItemPositions.keyAt(i2)).toString());
            }
        }
        this.i.edit().putStringSet("checkedSensors", new b(this.g)).putBoolean("doLog", this.f).putBoolean("doStream", this.e).apply();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        a(this.j.b());
        b();
    }

    public void prefs(View view) {
        startActivity(new Intent(this, Preferences.class));
    }
}
