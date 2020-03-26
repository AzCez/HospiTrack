package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class e implements Parcelable.Creator<LatLng> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    d = a.i(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                    d2 = a.i(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new LatLng(d, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLng[i];
    }
}
