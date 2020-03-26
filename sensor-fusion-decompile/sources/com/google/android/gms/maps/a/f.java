package com.google.android.gms.maps.a;

import com.google.android.gms.maps.f;

public final class f {
    public static byte a(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : 0;
        }
        return -1;
    }

    public static Boolean a(byte b) {
        switch (b) {
            case f.a.MapAttrs_ambientEnabled /*0*/:
                return Boolean.FALSE;
            case f.a.MapAttrs_cameraBearing /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }
}
