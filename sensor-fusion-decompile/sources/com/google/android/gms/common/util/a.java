package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.m;

public final class a {
    public static <T> boolean a(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m.a(tArr[i], t)) {
                break;
            } else {
                i++;
            }
        }
        return i >= 0;
    }
}
