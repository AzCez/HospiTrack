package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class v implements Parcelable.Creator<zzb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    bundle = a.l(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    featureArr = (Feature[]) a.b(parcel, a, Feature.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new zzb(bundle, featureArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzb[i];
    }
}
