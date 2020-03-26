package com.hiq.sensor;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.preference.PreferenceManager;
import android.view.SurfaceHolder;

public class b extends Thread {
    SharedPreferences a;
    private boolean b;
    private SurfaceHolder c;
    private c d;
    private long e;
    private volatile long f = 10;

    protected b(SurfaceHolder surfaceHolder, c cVar) {
        this.c = surfaceHolder;
        this.d = cVar;
        this.e = 0;
    }

    public void a() {
        this.a = PreferenceManager.getDefaultSharedPreferences(this.d.getContext());
        this.f = this.a.getString("updateSpeed", "Normal").equals("Fast") ? 1 : this.a.getString("updateSpeed", "Normal").equals("Slow") ? 1000 : 100;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.b = z;
    }

    @SuppressLint({"WrongCall"})
    public void run() {
        a();
        Canvas canvas = null;
        while (this.b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.e < this.f) {
                try {
                    Thread.sleep(this.f - (currentTimeMillis - this.e));
                } catch (InterruptedException unused) {
                }
            } else {
                try {
                    this.e = currentTimeMillis;
                    canvas = this.c.lockCanvas();
                    synchronized (this.c) {
                        this.d.onDraw(canvas);
                    }
                    if (canvas != null) {
                        this.c.unlockCanvasAndPost(canvas);
                    }
                } catch (Throwable th) {
                    if (canvas != null) {
                        this.c.unlockCanvasAndPost(canvas);
                    }
                    throw th;
                }
            }
        }
    }
}
