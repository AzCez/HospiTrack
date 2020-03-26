package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new t();
    private final int a;
    private final Account b;
    private final int c;
    private final GoogleSignInAccount d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.a = i;
        this.b = account;
        this.c = i2;
        this.d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public GoogleSignInAccount c() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.a);
        b.a(parcel, 2, (Parcelable) a(), i, false);
        b.a(parcel, 3, b());
        b.a(parcel, 4, (Parcelable) c(), i, false);
        b.a(parcel, a2);
    }
}
