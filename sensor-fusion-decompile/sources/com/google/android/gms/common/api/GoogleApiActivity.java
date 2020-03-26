package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.maps.f;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    private int a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, a(context, pendingIntent, i, true), 134217728);
    }

    public static Intent a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.a = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                b a2 = b.a((Context) this);
                switch (i2) {
                    case -1:
                        a2.a();
                        break;
                    case f.a.MapAttrs_ambientEnabled /*0*/:
                        a2.b(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                }
            }
        } else if (i == 2) {
            this.a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("resolution");
        }
        if (this.a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                str = "GoogleApiActivity";
                str2 = "Activity started without extras";
            } else {
                PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
                Integer num = (Integer) extras.get("error_code");
                if (pendingIntent == null && num == null) {
                    str = "GoogleApiActivity";
                    str2 = "Activity started without resolution";
                } else if (pendingIntent != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                        this.a = 1;
                        return;
                    } catch (IntentSender.SendIntentException e) {
                        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    }
                } else {
                    com.google.android.gms.common.b.a().b(this, num.intValue(), 2, this);
                    this.a = 1;
                    return;
                }
            }
            Log.e(str, str2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle);
    }
}
