package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class l implements Parcelable.Creator<Scope> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    str = a.j(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new Scope(i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Scope[i];
    }
}
