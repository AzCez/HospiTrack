package com.hiq.sensor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class a extends AlertDialog {
    public a(Context context) {
        super(context);
        setMessage("GPS is disabled! Would you like to enable it?");
        setCancelable(false);
        setButton(-1, "YES! Enable GPS.", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.a();
            }
        });
        setButton(-2, "No thanks!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
    }

    /* access modifiers changed from: private */
    public void a() {
        getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
}
