package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new i();
    private final int a;
    private final ConnectionResult b;
    private final ResolveAccountResponse c;

    public zaj(int i) {
        this(new ConnectionResult(8, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    zaj(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.a = i;
        this.b = connectionResult;
        this.c = resolveAccountResponse;
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }

    public final ConnectionResult a() {
        return this.b;
    }

    public final ResolveAccountResponse b() {
        return this.c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, 2, (Parcelable) this.b, i, false);
        b.a(parcel, 3, (Parcelable) this.c, i, false);
        b.a(parcel, a2);
    }
}
