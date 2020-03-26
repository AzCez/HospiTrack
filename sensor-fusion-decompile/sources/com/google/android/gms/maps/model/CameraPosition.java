package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new c();
    public final LatLng a;
    public final float b;
    public final float c;
    public final float d;

    public static final class a {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public final a a(float f) {
            this.b = f;
            return this;
        }

        public final a a(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public final CameraPosition a() {
            return new CameraPosition(this.a, this.b, this.c, this.d);
        }

        public final a b(float f) {
            this.c = f;
            return this;
        }

        public final a c(float f) {
            this.d = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        n.a(latLng, (Object) "null camera target");
        n.a(0.0f <= f2 && f2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.a = latLng;
        this.b = f;
        this.c = f2 + 0.0f;
        this.d = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public static a a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.a.equals(cameraPosition.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(cameraPosition.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(cameraPosition.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(cameraPosition.d);
    }

    public final int hashCode() {
        return m.a(this.a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d));
    }

    public final String toString() {
        return m.a((Object) this).a("target", this.a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, (Parcelable) this.a, i, false);
        b.a(parcel, 3, this.b);
        b.a(parcel, 4, this.c);
        b.a(parcel, 5, this.d);
        b.a(parcel, a2);
    }
}
