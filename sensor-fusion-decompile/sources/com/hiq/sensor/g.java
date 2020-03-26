package com.hiq.sensor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;

public class g {
    static int[] a = new int[3];
    static int b;
    static Paint c = new Paint();
    public static Bitmap d = null;
    static int e = R.drawable.settings_red;
    static String f = "";

    public static void a(Context context) {
        Resources resources;
        int i;
        f = PreferenceManager.getDefaultSharedPreferences(context).getString("colorScheme", "brightSelected");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inDither = true;
        if (f.equals("darkSelected")) {
            int[] iArr = a;
            iArr[0] = -65536;
            iArr[1] = -16711936;
            iArr[2] = -16776961;
            c.setColor(-1);
            b = -1;
            resources = context.getResources();
            i = R.drawable.black_bkg;
        } else {
            int[] iArr2 = a;
            iArr2[0] = -65536;
            iArr2[1] = Color.rgb(0, 165, 0);
            a[2] = -16776961;
            c.setColor(-1);
            b = -16777216;
            resources = context.getResources();
            i = R.drawable.sensor_bkg_white;
        }
        d = BitmapFactory.decodeResource(resources, i, options);
    }

    public static void a(Canvas canvas) {
        Bitmap bitmap = d;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = d.getHeight();
            float width2 = ((float) canvas.getWidth()) / ((float) width);
            float height2 = ((float) canvas.getHeight()) / ((float) height);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            Matrix matrix = new Matrix();
            matrix.postScale(width2, height2);
            canvas.drawBitmap(d, matrix, paint);
            return;
        }
        canvas.drawColor(c.getColor());
    }
}
