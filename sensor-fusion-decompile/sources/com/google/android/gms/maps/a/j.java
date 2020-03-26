package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.d.d.a;
import com.google.android.gms.d.d.c;

public final class j extends a implements d {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final void a(boolean z) {
        Parcel b_ = b_();
        c.a(b_, z);
        b(2, b_);
    }
}
