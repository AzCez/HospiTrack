package com.google.android.gms.maps.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.b;
import com.google.android.gms.d.d.a;
import com.google.android.gms.d.d.c;
import com.google.android.gms.maps.GoogleMapOptions;

public final class p extends a implements c {
    p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
    }

    public final b a(b bVar, b bVar2, Bundle bundle) {
        Parcel b_ = b_();
        c.a(b_, (IInterface) bVar);
        c.a(b_, (IInterface) bVar2);
        c.a(b_, (Parcelable) bundle);
        Parcel a = a(4, b_);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void a() {
        b(5, b_());
    }

    public final void a(Bundle bundle) {
        Parcel b_ = b_();
        c.a(b_, (Parcelable) bundle);
        b(3, b_);
    }

    public final void a(b bVar, GoogleMapOptions googleMapOptions, Bundle bundle) {
        Parcel b_ = b_();
        c.a(b_, (IInterface) bVar);
        c.a(b_, (Parcelable) googleMapOptions);
        c.a(b_, (Parcelable) bundle);
        b(2, b_);
    }

    public final void a(g gVar) {
        Parcel b_ = b_();
        c.a(b_, (IInterface) gVar);
        b(12, b_);
    }

    public final void b() {
        b(6, b_());
    }

    public final void b(Bundle bundle) {
        Parcel b_ = b_();
        c.a(b_, (Parcelable) bundle);
        Parcel a = a(10, b_);
        if (a.readInt() != 0) {
            bundle.readFromParcel(a);
        }
        a.recycle();
    }

    public final void c() {
        b(7, b_());
    }

    public final void d() {
        b(8, b_());
    }

    public final void e() {
        b(9, b_());
    }

    public final void f() {
        b(15, b_());
    }

    public final void g() {
        b(16, b_());
    }
}
