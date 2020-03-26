package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.b;
import com.google.android.gms.d.d.a;
import com.google.android.gms.d.d.c;
import com.google.android.gms.d.d.e;
import com.google.android.gms.d.d.f;

public final class n extends a implements m {
    n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.a.c a(com.google.android.gms.b.b r4) {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.b_()
            com.google.android.gms.d.d.c.a((android.os.Parcel) r0, (android.os.IInterface) r4)
            r4 = 2
            android.os.Parcel r4 = r3.a(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.maps.internal.IMapFragmentDelegate"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.maps.a.c
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.maps.a.c r0 = (com.google.android.gms.maps.a.c) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.maps.a.p r1 = new com.google.android.gms.maps.a.p
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.n.a(com.google.android.gms.b.b):com.google.android.gms.maps.a.c");
    }

    public final void a(b bVar, int i) {
        Parcel b_ = b_();
        c.a(b_, (IInterface) bVar);
        b_.writeInt(i);
        b(6, b_);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.a.a a_() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.b_()
            r1 = 4
            android.os.Parcel r0 = r4.a(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.maps.a.a
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.maps.a.a r1 = (com.google.android.gms.maps.a.a) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.maps.a.i r2 = new com.google.android.gms.maps.a.i
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.n.a_():com.google.android.gms.maps.a.a");
    }

    public final e b() {
        Parcel a = a(5, b_());
        e a2 = f.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
