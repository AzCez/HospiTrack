package com.google.android.gms.common.api;

import android.support.v4.b.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ae;
import java.util.ArrayList;

public class c extends Exception {
    private final a<ae<?>, ConnectionResult> a;

    public c(a<ae<?>, ConnectionResult> aVar) {
        this.a = aVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ae next : this.a.keySet()) {
            ConnectionResult connectionResult = this.a.get(next);
            if (connectionResult.b()) {
                z = false;
            }
            String a2 = next.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
