package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.internal.d;

public abstract class e implements DialogInterface.OnClickListener {
    public static e a(Activity activity, Intent intent, int i) {
        return new p(intent, activity, i);
    }

    public static e a(d dVar, Intent intent, int i) {
        return new q(intent, dVar, i);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
