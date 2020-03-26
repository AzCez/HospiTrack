package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class k implements Parcelable.Creator<Feature> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    str = a.j(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    j = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new Feature(str, i, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Feature[i];
    }
}
