package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new h();
    private final int a;
    private final ResolveAccountRequest b;

    zah(int i, ResolveAccountRequest resolveAccountRequest) {
        this.a = i;
        this.b = resolveAccountRequest;
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, 2, (Parcelable) this.b, i, false);
        b.a(parcel, a2);
    }
}
