package se.hendeby.sfapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.hardware.Sensor;
import android.os.IBinder;
import android.util.Log;
import com.hiq.sensor.LogActivity;
import java.lang.ref.WeakReference;
import se.hendeby.sfapp.LogService;

public class a implements ServiceConnection {
    private WeakReference<LogService> a = new WeakReference<>((Object) null);
    private WeakReference<LogActivity> b;

    public a(LogActivity logActivity) {
        this.b = new WeakReference<>(logActivity);
    }

    public void a() {
        if (this.a.get() != null) {
            ((LogService) this.a.get()).d();
        }
    }

    public void a(Sensor sensor, boolean z) {
        if (this.a.get() != null) {
            ((LogService) this.a.get()).a(sensor, z);
        }
    }

    public void a(String str, boolean z) {
        if (this.a.get() != null) {
            ((LogService) this.a.get()).a(str, z);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.a.get() != null) {
            ((LogService) this.a.get()).a(z, z2);
        }
    }

    public boolean b() {
        WeakReference<LogService> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null || !((LogService) this.a.get()).a()) ? false : true;
    }

    public void c() {
        if (this.b.get() != null) {
            ((LogActivity) this.b.get()).a(b());
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a = new WeakReference<>(((LogService.b) iBinder).a());
        ((LogService) this.a.get()).a(this);
        c();
        ((LogActivity) this.b.get()).a();
        Log.d("SERVICE", "LogService bound");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.clear();
        Log.d("SERVICE", "LogService unbound");
    }
}
