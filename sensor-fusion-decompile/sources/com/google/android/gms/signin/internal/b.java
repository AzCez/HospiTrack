package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class b implements Parcelable.Creator<zaa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    i2 = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                    intent = (Intent) a.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new zaa(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zaa[i];
    }
}
