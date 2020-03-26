package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

@Deprecated
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new ag();
    private final int a;

    zzr(int i) {
        this.a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, a2);
    }
}
