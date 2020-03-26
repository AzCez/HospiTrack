package com.google.android.gms.d.d;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public class c {
    private static final ClassLoader a = c.class.getClassLoader();

    private c() {
    }

    public static void a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
