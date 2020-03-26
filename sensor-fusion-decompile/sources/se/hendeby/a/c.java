package se.hendeby.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.hiq.sensor.e;
import se.hendeby.sfapp.LogService;

public class c implements LocationListener, d {
    private LocationManager a;
    private LogService.c b;

    public c(Context context) {
        this.a = (LocationManager) context.getSystemService("location");
    }

    public void a(Context context) {
        this.a.removeUpdates(this);
    }

    public void a(Context context, LogService.c cVar) {
        this.a.removeUpdates(this);
        this.a.requestLocationUpdates("gps", 1000, 0.0f, this);
        this.b = cVar;
    }

    public void onLocationChanged(Location location) {
        this.b.a(e.a(location));
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
