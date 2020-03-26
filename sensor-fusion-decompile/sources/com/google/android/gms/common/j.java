package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class j implements Parcelable.Creator<ConnectionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    i = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    i2 = a.e(parcel, a);
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case f.a.MapAttrs_cameraTargetLat /*4*/:
                    str = a.j(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        a.m(parcel, b);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
