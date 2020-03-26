package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.d.b.b;
import com.google.android.gms.d.b.c;
import com.google.android.gms.maps.f;

public abstract class ac extends b implements ab {
    public ac() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case f.a.MapAttrs_cameraBearing /*1*/:
                com.google.android.gms.b.b a = a();
                parcel2.writeNoException();
                c.a(parcel2, (IInterface) a);
                return true;
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                int b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            default:
                return false;
        }
    }
}
