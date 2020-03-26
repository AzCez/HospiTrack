package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public abstract class g {
    private static final Object a = new Object();
    private static g b;

    protected static final class a {
        private final String a;
        private final String b;
        private final ComponentName c = null;
        private final int d;

        public a(String str, String str2, int i) {
            this.a = n.a(str);
            this.b = n.a(str2);
            this.d = i;
        }

        public final Intent a(Context context) {
            String str = this.a;
            return str != null ? new Intent(str).setPackage(this.b) : new Intent().setComponent(this.c);
        }

        public final String a() {
            return this.b;
        }

        public final ComponentName b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.a, aVar.a) && m.a(this.b, aVar.b) && m.a(this.c, aVar.c) && this.d == aVar.d;
        }

        public final int hashCode() {
            return m.a(this.a, this.b, this.c, Integer.valueOf(this.d));
        }

        public final String toString() {
            String str = this.a;
            return str == null ? this.c.flattenToString() : str;
        }
    }

    public static g a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new x(context.getApplicationContext());
            }
        }
        return b;
    }

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new a(str, str2, i), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);
}
