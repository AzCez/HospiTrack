package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.b;
import com.google.android.gms.d.d.a;
import com.google.android.gms.d.d.c;
import com.google.android.gms.maps.model.LatLng;

public final class i extends a implements a {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final b a(LatLng latLng, float f) {
        Parcel b_ = b_();
        c.a(b_, (Parcelable) latLng);
        b_.writeFloat(f);
        Parcel a = a(9, b_);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
