package se.hendeby.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.HashMap;
import java.util.Map;
import se.hendeby.sfapp.LogService;

public class e implements SensorEventListener, d {
    private SensorManager a;
    private Map<Sensor, Integer> b = a();
    private LogService.c c;

    public e(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
    }

    private Map<Sensor, Integer> a() {
        HashMap hashMap = new HashMap();
        for (Sensor next : this.a.getSensorList(-1)) {
            int type = next.getType();
            if ((type == 1 || type == 4 || type == 16 || type == 5 || type == 2 || type == 14 || type == 11 || type == 6 || type == 8 || type == 7) && next == this.a.getDefaultSensor(type)) {
                hashMap.put(next, -1);
            }
        }
        return hashMap;
    }

    public void a(int i) {
        for (Map.Entry next : this.b.entrySet()) {
            if (((Integer) next.getValue()).intValue() >= 0) {
                next.setValue(Integer.valueOf(i));
            }
        }
    }

    public void a(Context context) {
        this.a.unregisterListener(this);
        this.c = null;
    }

    public void a(Context context, LogService.c cVar) {
        this.c = cVar;
        for (Map.Entry next : this.b.entrySet()) {
            if (((Integer) next.getValue()).intValue() > 0) {
                this.a.registerListener(this, (Sensor) next.getKey(), ((Integer) next.getValue()).intValue());
            }
        }
    }

    public boolean a(Sensor sensor) {
        boolean containsKey = this.b.containsKey(sensor);
        if (containsKey) {
            this.b.put(sensor, -1);
            if (this.c != null) {
                this.a.unregisterListener(this, sensor);
            }
        }
        return containsKey;
    }

    public boolean a(Sensor sensor, int i) {
        boolean containsKey = this.b.containsKey(sensor);
        if (this.c != null) {
            this.a.registerListener(this, sensor, i);
        }
        this.b.put(sensor, Integer.valueOf(i));
        return containsKey;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.c.a(com.hiq.sensor.e.a(sensorEvent));
    }
}
