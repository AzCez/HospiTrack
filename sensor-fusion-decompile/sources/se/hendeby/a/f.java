package se.hendeby.a;

import android.content.Context;
import android.os.PowerManager;

public class f {
    private PowerManager.WakeLock a;

    public f(Context context, String str) {
        this.a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
    }

    public void a() {
        this.a.acquire();
    }

    public void b() {
        if (this.a.isHeld()) {
            this.a.release();
        }
    }
}
