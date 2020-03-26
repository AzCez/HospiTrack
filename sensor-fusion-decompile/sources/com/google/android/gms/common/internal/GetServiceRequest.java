package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new w();
    String a;
    IBinder b;
    Scope[] c;
    Bundle d;
    Account e;
    Feature[] f;
    Feature[] g;
    private final int h;
    private final int i;
    private int j;
    private boolean k;

    public GetServiceRequest(int i2) {
        this.h = 4;
        this.j = c.b;
        this.i = i2;
        this.k = true;
    }

    GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z) {
        this.h = i2;
        this.i = i3;
        this.j = i4;
        if ("com.google.android.gms".equals(str)) {
            this.a = "com.google.android.gms";
        } else {
            this.a = str;
        }
        if (i2 < 2) {
            this.e = iBinder != null ? a.a(i.a.a(iBinder)) : null;
        } else {
            this.b = iBinder;
            this.e = account;
        }
        this.c = scopeArr;
        this.d = bundle;
        this.f = featureArr;
        this.g = featureArr2;
        this.k = z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.h);
        b.a(parcel, 2, this.i);
        b.a(parcel, 3, this.j);
        b.a(parcel, 4, this.a, false);
        b.a(parcel, 5, this.b, false);
        b.a(parcel, 6, (T[]) this.c, i2, false);
        b.a(parcel, 7, this.d, false);
        b.a(parcel, 8, (Parcelable) this.e, i2, false);
        b.a(parcel, 10, (T[]) this.f, i2, false);
        b.a(parcel, 11, (T[]) this.g, i2, false);
        b.a(parcel, 12, this.k);
        b.a(parcel, a2);
    }
}
