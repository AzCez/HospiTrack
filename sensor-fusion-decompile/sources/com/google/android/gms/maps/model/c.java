package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class c implements Parcelable.Creator<CameraPosition> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        float f = 0.0f;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    latLng = (LatLng) a.a(parcel, a, LatLng.CREATOR);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                    f = a.g(parcel, a);
                    break;
                case f.a.MapAttrs_cameraTargetLat:
                    f2 = a.g(parcel, a);
                    break;
                case f.a.MapAttrs_cameraTargetLng:
                    f3 = a.g(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new CameraPosition(latLng, f, f2, f3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}
