package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zaa extends AbstractSafeParcelable implements i {
    public static final Parcelable.Creator<zaa> CREATOR = new b();
    private final int a;
    private int b;
    private Intent c;

    public zaa() {
        this(0, (Intent) null);
    }

    zaa(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    private zaa(int i, Intent intent) {
        this(2, 0, (Intent) null);
    }

    public final Status a() {
        return this.b == 0 ? Status.a : Status.e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, 2, this.b);
        b.a(parcel, 3, (Parcelable) this.c, i, false);
        b.a(parcel, a2);
    }
}
