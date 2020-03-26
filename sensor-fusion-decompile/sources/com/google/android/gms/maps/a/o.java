package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.b;
import com.google.android.gms.d.d.a;
import com.google.android.gms.d.d.c;

public final class o extends a implements b {
    o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final int a() {
        Parcel a = a(15, b_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final void a(int i) {
        Parcel b_ = b_();
        b_.writeInt(i);
        b(16, b_);
    }

    public final void a(int i, int i2, int i3, int i4) {
        Parcel b_ = b_();
        b_.writeInt(i);
        b_.writeInt(i2);
        b_.writeInt(i3);
        b_.writeInt(i4);
        b(39, b_);
    }

    public final void a(b bVar) {
        Parcel b_ = b_();
        c.a(b_, (IInterface) bVar);
        b(4, b_);
    }

    public final void a(boolean z) {
        Parcel b_ = b_();
        c.a(b_, z);
        b(22, b_);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.a.d b() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.b_()
            r1 = 25
            android.os.Parcel r0 = r4.a(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IUiSettingsDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.maps.a.d
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.maps.a.d r1 = (com.google.android.gms.maps.a.d) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.maps.a.j r2 = new com.google.android.gms.maps.a.j
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.o.b():com.google.android.gms.maps.a.d");
    }
}
