package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new d();
    public final LatLng a;
    public final LatLng b;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        n.a(latLng, (Object) "null southwest");
        n.a(latLng2, (Object) "null northeast");
        n.a(latLng2.a >= latLng.a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.a), Double.valueOf(latLng2.a));
        this.a = latLng;
        this.b = latLng2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.a.equals(latLngBounds.a) && this.b.equals(latLngBounds.b);
    }

    public final int hashCode() {
        return m.a(this.a, this.b);
    }

    public final String toString() {
        return m.a((Object) this).a("southwest", this.a).a("northeast", this.b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, (Parcelable) this.a, i, false);
        b.a(parcel, 3, (Parcelable) this.b, i, false);
        b.a(parcel, a2);
    }
}
