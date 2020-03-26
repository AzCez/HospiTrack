package com.hiq.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.c.b;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.maps.f;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import se.hendeby.b.m;

@SuppressLint({"ViewConstructor"})
public class c extends SurfaceView implements SurfaceHolder.Callback {
    b a;
    float[][] b;
    final int c = getResources().getDisplayMetrics().widthPixels;
    int d;
    boolean e;
    float f;
    float g;
    DecimalFormat h;
    boolean i = true;
    Paint j = new Paint();
    int k;
    private ScaleGestureDetector l;
    private a m;
    private final int n = 0;
    private int o = 0;
    private float p;
    private float q;
    private float r;
    private float s;

    private class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        float a;
        float b;
        float c;

        private a() {
            this.a = 1.0f;
            this.b = 1.0f;
            this.c = 100000.0f;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            this.a *= scaleGestureDetector.getScaleFactor();
            this.a = Math.max(this.b, Math.min(this.a, this.c));
            c.this.invalidate();
            return true;
        }
    }

    protected c(Context context, Float f2, int i2) {
        super(context);
        this.b = (float[][]) Array.newInstance(float.class, new int[]{i2, this.c});
        this.g = f2.floatValue();
        g.a(context);
        getHolder().addCallback(this);
        setFocusable(true);
        this.m = new a();
        this.l = new ScaleGestureDetector(context, this.m);
        this.h = new DecimalFormat();
        this.h.setPositivePrefix(" ");
        DecimalFormatSymbols decimalFormatSymbols = this.h.getDecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        this.h.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.a = new b(getHolder(), this);
        this.a.a(true);
        this.a.start();
        this.e = true;
    }

    /* access modifiers changed from: protected */
    public void a(FrameLayout frameLayout, String str) {
        ((ImageView) frameLayout.findViewById(R.id.settingsIcon)).setImageResource(g.e);
    }

    /* access modifiers changed from: protected */
    public void a(m mVar) {
        int i2 = 0;
        while (true) {
            float[][] fArr = this.b;
            if (i2 < fArr.length) {
                fArr[i2][this.k] = mVar.b()[i2];
                i2++;
            } else {
                this.k++;
                this.k %= this.c;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.a.a(false);
        while (true) {
            b bVar = this.a;
            if (bVar != null) {
                try {
                    bVar.join();
                    this.a = null;
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        g.a(canvas);
        float f2 = this.m.a * this.s;
        float f3 = this.m.a * this.f;
        canvas.save();
        canvas2.translate(0.0f, f2);
        double d2 = 1.0d;
        int ceil = (int) Math.ceil((-Math.log10((double) ((((float) this.d) * 0.4f) / f3))) + 1.0d);
        this.h.setMinimumFractionDigits(ceil);
        this.h.setMaximumFractionDigits(ceil);
        this.j.setColor(g.b);
        this.j.setAlpha(90);
        this.j.setStrokeWidth(0.0f);
        int round = Math.round(f2 / (((float) this.d) * 0.4f));
        int i2 = -2;
        while (i2 < 3) {
            double d3 = (double) (i2 + round);
            Double.isNaN(d3);
            double d4 = d2 - (d3 * 0.4d);
            double d5 = (double) this.d;
            Double.isNaN(d5);
            int round2 = (int) Math.round(d4 * d5);
            float f4 = ((float) (-(round2 - this.d))) / f3;
            float f5 = (float) round2;
            canvas.drawLine(0.0f, f5, (float) this.c, f5, this.j);
            canvas2.drawText(this.h.format((double) f4), 10.0f, (float) (round2 - 10), this.j);
            i2++;
            d2 = 1.0d;
        }
        this.j.setAlpha(255);
        this.j.setStrokeWidth(0.0f);
        int i3 = this.d;
        canvas.drawLine(0.0f, (float) i3, (float) this.c, (float) i3, this.j);
        canvas2.drawText(this.h.format(0), 10.0f, (float) (this.d - 10), this.j);
        for (int i4 = 0; i4 < this.b.length; i4++) {
            this.j.setColor(g.a[i4]);
            this.j.setStrokeWidth(2.0f);
            int i5 = this.k;
            int i6 = 0;
            while (true) {
                int i7 = this.c;
                if (i6 >= i7 - 1) {
                    break;
                }
                float f6 = (float) i6;
                float f7 = -f3;
                float[][] fArr = this.b;
                int i8 = this.d;
                float f8 = (fArr[i4][i5] * f7) + ((float) i8);
                int i9 = i6 + 1;
                int i10 = i5 + 1;
                canvas.drawLine(f6, f8, (float) i9, (f7 * fArr[i4][i10 % i7]) + ((float) i8), this.j);
                i5 = i10 % this.c;
                i6 = i9;
            }
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int b2;
        this.l.onTouchEvent(motionEvent);
        int a2 = b.a(motionEvent);
        int i2 = 0;
        if (a2 != 6) {
            switch (a2) {
                case f.a.MapAttrs_ambientEnabled:
                    int b3 = b.b(motionEvent);
                    this.p = b.c(motionEvent, b3);
                    this.q = b.d(motionEvent, b3);
                    b2 = b.b(motionEvent, b3);
                    break;
                case f.a.MapAttrs_cameraBearing:
                case f.a.MapAttrs_cameraMinZoomPreference:
                    this.o = 0;
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    int a3 = b.a(motionEvent, this.o);
                    float c2 = b.c(motionEvent, a3);
                    float d2 = b.d(motionEvent, a3);
                    if (!this.l.isInProgress()) {
                        this.r += (c2 - this.p) / this.m.a;
                        this.s += (d2 - this.q) / this.m.a;
                        invalidate();
                    }
                    this.p = c2;
                    this.q = d2;
                    break;
            }
        } else {
            int b4 = b.b(motionEvent);
            if (b.b(motionEvent, b4) == this.o) {
                if (b4 == 0) {
                    i2 = 1;
                }
                this.p = b.c(motionEvent, i2);
                this.q = b.d(motionEvent, i2);
                b2 = b.b(motionEvent, i2);
            }
            return true;
        }
        this.o = b2;
        return true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        int applyDimension = (int) (((float) i4) - TypedValue.applyDimension(1, 266.0f, getResources().getDisplayMetrics()));
        this.f = (((float) applyDimension) * 0.5f) / this.g;
        this.d = applyDimension / 2;
        if (this.i) {
            for (int i5 = 0; i5 < this.b.length; i5++) {
                for (int i6 = 0; i6 < this.c; i6++) {
                    this.b[i5][i6] = 0.0f;
                }
            }
            this.i = false;
            this.k = 0;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        a();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e = false;
    }
}
