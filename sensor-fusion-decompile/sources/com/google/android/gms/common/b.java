package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.h;
import android.support.v4.app.v;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.a.a;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.g;
import com.google.android.gms.d.a.e;
import com.google.android.gms.maps.f;

public class b extends c {
    public static final int a = c.b;
    private static final Object c = new Object();
    private static final b d = new b();
    private String e;

    @SuppressLint({"HandlerLeak"})
    private class a extends e {
        private final Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what != 1) {
                int i = message.what;
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int a2 = b.this.a(this.a);
            if (b.this.a(a2)) {
                b.this.a(this.a, a2);
            }
        }
    }

    b() {
    }

    public static Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(d.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        a(activity, (Dialog) create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog a(Context context, int i, com.google.android.gms.common.internal.e eVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(d.c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String e2 = d.e(context, i);
        if (e2 != null) {
            builder.setPositiveButton(e2, eVar);
        }
        String a2 = d.a(context, i);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }

    public static b a() {
        return d;
    }

    static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof h) {
            i.a(dialog, onCancelListener).a(((h) activity).f(), str);
            return;
        }
        a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void a(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            b(context);
        } else if (pendingIntent != null) {
            String b = d.b(context, i);
            String d2 = d.d(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            v.c a2 = new v.c(context).c(true).b(true).a((CharSequence) b).a((v.m) new v.b().a((CharSequence) d2));
            if (f.a(context)) {
                n.a(g.e());
                a2.a(context.getApplicationInfo().icon).b(2);
                if (f.b(context)) {
                    a2.a(a.C0017a.common_full_open_on_phone, resources.getString(a.b.common_open_on_phone), pendingIntent);
                } else {
                    a2.a(pendingIntent);
                }
            } else {
                a2.a(17301642).c((CharSequence) resources.getString(a.b.common_google_play_services_notification_ticker)).a(System.currentTimeMillis()).a(pendingIntent).b((CharSequence) d2);
            }
            if (g.h()) {
                n.a(g.h());
                String c2 = c();
                if (c2 == null) {
                    c2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(c2);
                    String b2 = d.b(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel(c2, b2, 4);
                    } else if (!b2.equals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                a2.a(c2);
            }
            Notification a3 = a2.a();
            switch (i) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    i2 = 10436;
                    f.c.set(false);
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            notificationManager.notify(i2, a3);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    private final String c() {
        String str;
        synchronized (c) {
            str = this.e;
        }
        return str;
    }

    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int i, int i2) {
        return a(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public Dialog a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return a((Context) activity, i, com.google.android.gms.common.internal.e.a(activity, a((Context) activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        return connectionResult.a() ? connectionResult.d() : a(context, connectionResult.c(), 0);
    }

    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    public final r a(Context context, s sVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        r rVar = new r(sVar);
        context.registerReceiver(rVar, intentFilter);
        rVar.a(context);
        if (a(context, "com.google.android.gms")) {
            return rVar;
        }
        sVar.a();
        rVar.a();
        return null;
    }

    public void a(Context context, int i) {
        a(context, i, (String) null, a(context, i, 0, "n"));
    }

    public final boolean a(int i) {
        return super.a(i);
    }

    public final boolean a(Activity activity, com.google.android.gms.common.api.internal.d dVar, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a((Context) activity, i, com.google.android.gms.common.internal.e.a(dVar, a((Context) activity, i, "d"), 2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a2 = a(context, connectionResult);
        if (a2 == null) {
            return false;
        }
        a(context, connectionResult.c(), (String) null, GoogleApiActivity.a(context, a2, i));
        return true;
    }

    public int b(Context context, int i) {
        return super.b(context, i);
    }

    public final String b(int i) {
        return super.b(i);
    }

    /* access modifiers changed from: package-private */
    public final void b(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }

    public boolean b(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i, i2, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
