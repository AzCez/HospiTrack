package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new u();
    private final int a;
    private IBinder b;
    private ConnectionResult c;
    private boolean d;
    private boolean e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public i a() {
        return i.a.a(this.b);
    }

    public ConnectionResult b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.c.equals(resolveAccountResponse.c) && a().equals(resolveAccountResponse.a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, 2, this.b, false);
        b.a(parcel, 3, (Parcelable) b(), i, false);
        b.a(parcel, 4, c());
        b.a(parcel, 5, d());
        b.a(parcel, a2);
    }
}
