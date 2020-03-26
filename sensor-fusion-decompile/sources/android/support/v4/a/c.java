package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class c extends BroadcastReceiver {
    private static final SparseArray<PowerManager.WakeLock> a = new SparseArray<>();
    private static int b = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (a) {
            PowerManager.WakeLock wakeLock = a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
