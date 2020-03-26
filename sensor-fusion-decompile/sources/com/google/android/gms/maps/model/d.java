package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class d implements Parcelable.Creator<LatLngBounds> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    latLng = (LatLng) a.a(parcel, a, LatLng.CREATOR);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                    latLng2 = (LatLng) a.a(parcel, a, LatLng.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new LatLngBounds(latLng, latLng2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
