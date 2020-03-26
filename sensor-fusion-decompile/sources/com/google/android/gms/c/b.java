package com.google.android.gms.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

@Deprecated
public class b extends k {
    static void a(Context context, i iVar) {
        iVar.b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }

    public void a() {
    }

    public void a(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            a a = a.a(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 34 + String.valueOf(stringExtra2).length());
                sb.append("Service command. subtype:");
                sb.append(stringExtra);
                sb.append(" command:");
                sb.append(stringExtra2);
                Log.d("InstanceID", sb.toString());
            }
            if ("RST".equals(stringExtra2)) {
                a.b();
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!a.c().a()) {
                    a.c().b();
                } else {
                    return;
                }
            } else if ("SYNC".equals(stringExtra2)) {
                i c = a.c();
                String valueOf = String.valueOf(stringExtra);
                String valueOf2 = String.valueOf("|T|");
                c.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                String valueOf3 = String.valueOf(stringExtra);
                String valueOf4 = String.valueOf("|T-timestamp|");
                c.a(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
                a();
                return;
            } else {
                return;
            }
            a();
        }
    }
}
