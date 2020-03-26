package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class i implements Parcelable.Creator<zaj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    connectionResult = (ConnectionResult) a.a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                    resolveAccountResponse = (ResolveAccountResponse) a.a(parcel, a, ResolveAccountResponse.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new zaj(i, connectionResult, resolveAccountResponse);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zaj[i];
    }
}
