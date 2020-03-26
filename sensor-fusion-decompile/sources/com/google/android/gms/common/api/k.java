package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class k extends UnsupportedOperationException {
    private final Feature a;

    public k(Feature feature) {
        this.a = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
