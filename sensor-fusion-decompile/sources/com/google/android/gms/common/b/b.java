package com.google.android.gms.common.b;

import android.content.Context;

public class b {
    private static b b = new b();
    private a a = null;

    public static a a(Context context) {
        return b.b(context);
    }

    private final synchronized a b(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new a(context);
        }
        return this.a;
    }
}
