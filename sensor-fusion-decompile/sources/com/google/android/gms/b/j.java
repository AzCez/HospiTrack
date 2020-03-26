package com.google.android.gms.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class j implements View.OnClickListener {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Intent b;

    j(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public final void onClick(View view) {
        try {
            this.a.startActivity(this.b);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
