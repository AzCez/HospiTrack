package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new v();
    Bundle a;
    Feature[] b;

    public zzb() {
    }

    zzb(Bundle bundle, Feature[] featureArr) {
        this.a = bundle;
        this.b = featureArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a, false);
        b.a(parcel, 2, (T[]) this.b, i, false);
        b.a(parcel, a2);
    }
}
