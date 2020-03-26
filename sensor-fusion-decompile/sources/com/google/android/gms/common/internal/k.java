package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.d.b.b;
import com.google.android.gms.d.b.c;
import com.google.android.gms.maps.f;

public interface k extends IInterface {

    public static abstract class a extends b implements k {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    a(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    a(parcel.readInt(), parcel.readStrongBinder(), (zzb) c.a(parcel, zzb.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, Bundle bundle);

    void a(int i, IBinder iBinder, Bundle bundle);

    void a(int i, IBinder iBinder, zzb zzb);
}
