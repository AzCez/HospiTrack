package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.f;

public final class m implements Parcelable.Creator<Status> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            int a2 = a.a(a);
            if (a2 != 1000) {
                switch (a2) {
                    case f.a.MapAttrs_cameraBearing /*1*/:
                        i2 = a.e(parcel, a);
                        break;
                    case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                        str = a.j(parcel, a);
                        break;
                    case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                        pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                        break;
                    default:
                        a.b(parcel, a);
                        break;
                }
            } else {
                i = a.e(parcel, a);
            }
        }
        a.m(parcel, b);
        return new Status(i, i2, str, pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
