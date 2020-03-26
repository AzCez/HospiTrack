package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Status extends AbstractSafeParcelable implements i, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new m();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    public static final Status f = new Status(18);
    private static final Status g = new Status(17);
    private final int h;
    private final int i;
    private final String j;
    private final PendingIntent k;

    public Status(int i2) {
        this(i2, (String) null);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.h = i2;
        this.i = i3;
        this.j = str;
        this.k = pendingIntent;
    }

    public Status(int i2, String str) {
        this(1, i2, str, (PendingIntent) null);
    }

    public final Status a() {
        return this;
    }

    public final String b() {
        return this.j;
    }

    public final int c() {
        return this.i;
    }

    public final String d() {
        String str = this.j;
        return str != null ? str : d.a(this.i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.h == status.h && this.i == status.i && m.a(this.j, status.j) && m.a(this.k, status.k);
    }

    public final int hashCode() {
        return m.a(Integer.valueOf(this.h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final String toString() {
        return m.a((Object) this).a("statusCode", d()).a("resolution", this.k).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, c());
        b.a(parcel, 2, b(), false);
        b.a(parcel, 3, (Parcelable) this.k, i2, false);
        b.a(parcel, 1000, this.h);
        b.a(parcel, a2);
    }
}
