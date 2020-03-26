package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class t implements Parcelable.Creator<ResolveAccountRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    account = (Account) a.a(parcel, a, Account.CREATOR);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    i2 = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraTargetLat /*4*/:
                    googleSignInAccount = (GoogleSignInAccount) a.a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
