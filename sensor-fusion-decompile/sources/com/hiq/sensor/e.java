package com.hiq.sensor;

import android.hardware.SensorEvent;
import android.location.Location;
import android.os.Build;
import com.google.android.gms.maps.f;
import se.hendeby.b.a;
import se.hendeby.b.d;
import se.hendeby.b.g;
import se.hendeby.b.h;
import se.hendeby.b.i;
import se.hendeby.b.j;
import se.hendeby.b.k;
import se.hendeby.b.l;
import se.hendeby.b.m;
import se.hendeby.b.o;

public class e {
    static long a = 0;
    private static final boolean b = (Build.DEVICE.compareTo("tilapia") == 0);

    public static m a(SensorEvent sensorEvent) {
        double d = (double) sensorEvent.timestamp;
        Double.isNaN(d);
        long round = Math.round(d / 1000000.0d);
        if (!b || sensorEvent.sensor.getType() != 2) {
            a = Math.max(a, round);
        } else {
            round = a;
        }
        switch (sensorEvent.sensor.getType()) {
            case f.a.MapAttrs_cameraBearing:
                return new a(round, sensorEvent.values);
            case f.a.MapAttrs_cameraMaxZoomPreference:
                return new g(round, sensorEvent.values);
            case f.a.MapAttrs_cameraTargetLat:
                return new se.hendeby.b.e(round, sensorEvent.values);
            case f.a.MapAttrs_cameraTargetLng:
                return new se.hendeby.b.f(round, sensorEvent.values);
            case f.a.MapAttrs_cameraTilt:
                return new i(round, sensorEvent.values);
            case f.a.MapAttrs_cameraZoom:
                return new o(round, sensorEvent.values);
            case f.a.MapAttrs_latLngBoundsNorthEastLatitude:
                return new j(round, sensorEvent.values);
            case f.a.MapAttrs_latLngBoundsSouthWestLongitude:
                if (sensorEvent.values.length <= 3) {
                    return new h(round, sensorEvent.values);
                }
                return new h(round, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
            case f.a.MapAttrs_uiCompass:
                return new l(round, sensorEvent.values);
            case f.a.MapAttrs_uiRotateGestures:
                return new k(round, sensorEvent.values);
            default:
                return new a(1, new float[]{1.0f, 2.0f, 3.0f});
        }
    }

    public static m a(Location location) {
        long j = a;
        if (j <= 0) {
            j = location.getTime();
        }
        return new d(j, (float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude());
    }
}
