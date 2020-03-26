package com.google.android.gms.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.d.a.b;
import com.google.android.gms.d.a.c;
import com.google.android.gms.maps.f;

public abstract class e extends b implements d {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case f.a.MapAttrs_cameraMinZoomPreference:
                a((ConnectionResult) c.a(parcel, ConnectionResult.CREATOR), (zaa) c.a(parcel, zaa.CREATOR));
                break;
            case f.a.MapAttrs_cameraTargetLat:
                a((Status) c.a(parcel, Status.CREATOR));
                break;
            case f.a.MapAttrs_cameraTilt:
                b((Status) c.a(parcel, Status.CREATOR));
                break;
            case f.a.MapAttrs_cameraZoom:
                a((Status) c.a(parcel, Status.CREATOR), (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case f.a.MapAttrs_latLngBoundsNorthEastLatitude:
                a((zaj) c.a(parcel, zaj.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
