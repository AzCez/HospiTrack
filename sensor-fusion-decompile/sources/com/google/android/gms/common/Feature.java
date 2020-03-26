package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new k();
    private final String a;
    @Deprecated
    private final int b;
    private final long c;

    public Feature(String str, int i, long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        long j = this.c;
        return j == -1 ? (long) this.b : j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return ((a() != null && a().equals(feature.a())) || (a() == null && feature.a() == null)) && b() == feature.b();
        }
    }

    public int hashCode() {
        return m.a(a(), Long.valueOf(b()));
    }

    public String toString() {
        return m.a((Object) this).a("name", a()).a("version", Long.valueOf(b())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, a(), false);
        b.a(parcel, 2, this.b);
        b.a(parcel, 3, b());
        b.a(parcel, a2);
    }
}
