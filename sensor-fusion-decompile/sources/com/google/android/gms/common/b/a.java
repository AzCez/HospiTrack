package com.google.android.gms.common.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public class a {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    public ApplicationInfo a(String str, int i) {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence a(String str) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo b(String str, int i) {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }
}
