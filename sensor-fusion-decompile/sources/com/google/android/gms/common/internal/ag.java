package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ag implements Parcelable.Creator<zzr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            if (a.a(a) != 1) {
                a.b(parcel, a);
            } else {
                i = a.e(parcel, a);
            }
        }
        a.m(parcel, b);
        return new zzr(i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
