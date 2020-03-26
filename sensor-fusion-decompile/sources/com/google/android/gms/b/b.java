package com.google.android.gms.b;

import android.os.IBinder;
import android.os.IInterface;

public interface b extends IInterface {

    public static abstract class a extends com.google.android.gms.d.b.b implements b {

        /* renamed from: com.google.android.gms.b.b$a$a  reason: collision with other inner class name */
        public static class C0019a extends com.google.android.gms.d.b.a implements b {
            C0019a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof b ? (b) queryLocalInterface : new C0019a(iBinder);
        }
    }
}
