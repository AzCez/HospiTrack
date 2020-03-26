package com.google.android.gms.d.a;

import android.os.Handler;
import android.os.Looper;

public class e extends Handler {
    private static volatile f a;

    public e() {
    }

    public e(Looper looper) {
        super(looper);
    }

    public e(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
