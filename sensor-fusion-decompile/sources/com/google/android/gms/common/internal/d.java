package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v4.b.h;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.a.a;
import com.google.android.gms.common.b.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.maps.f;
import javax.annotation.concurrent.GuardedBy;

public final class d {
    @GuardedBy("sCache")
    private static final h<String, String> a = new h<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return b.a(context).a(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        android.util.Log.e(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3, int r4) {
        /*
            android.content.res.Resources r0 = r3.getResources()
            r1 = 20
            if (r4 == r1) goto L_0x0081
            r1 = 0
            switch(r4) {
                case 1: goto L_0x007a;
                case 2: goto L_0x0073;
                case 3: goto L_0x006c;
                case 4: goto L_0x006b;
                case 5: goto L_0x005d;
                case 6: goto L_0x006b;
                case 7: goto L_0x004f;
                case 8: goto L_0x004a;
                case 9: goto L_0x0045;
                case 10: goto L_0x0040;
                case 11: goto L_0x003b;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r4) {
                case 16: goto L_0x0036;
                case 17: goto L_0x0028;
                case 18: goto L_0x006b;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.String r3 = "GoogleApiAvailability"
            r0 = 33
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Unexpected error code "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L_0x0024:
            android.util.Log.e(r3, r4)
            return r1
        L_0x0028:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "The specified account could not be signed in."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_sign_in_failed_title"
            java.lang.String r3 = a((android.content.Context) r3, (java.lang.String) r4)
            return r3
        L_0x0036:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "One of the API components you attempted to connect to is not available."
            goto L_0x0024
        L_0x003b:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "The application is not licensed to the user."
            goto L_0x0024
        L_0x0040:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Developer error occurred. Please see logs for detailed information"
            goto L_0x0024
        L_0x0045:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Google Play services is invalid. Cannot recover."
            goto L_0x0024
        L_0x004a:
            java.lang.String r3 = "GoogleApiAvailability"
            java.lang.String r4 = "Internal error occurred. Please see logs for detailed information"
            goto L_0x0024
        L_0x004f:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "Network error occurred. Please retry request later."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_network_error_title"
            java.lang.String r3 = a((android.content.Context) r3, (java.lang.String) r4)
            return r3
        L_0x005d:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "An invalid account was specified when connecting. Please provide a valid account."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_invalid_account_title"
            java.lang.String r3 = a((android.content.Context) r3, (java.lang.String) r4)
            return r3
        L_0x006b:
            return r1
        L_0x006c:
            int r3 = com.google.android.gms.a.a.b.common_google_play_services_enable_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L_0x0073:
            int r3 = com.google.android.gms.a.a.b.common_google_play_services_update_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L_0x007a:
            int r3 = com.google.android.gms.a.a.b.common_google_play_services_install_title
            java.lang.String r3 = r0.getString(r3)
            return r3
        L_0x0081:
            java.lang.String r4 = "GoogleApiAvailability"
            java.lang.String r0 = "The current user profile is restricted and could not use authenticated features."
            android.util.Log.e(r4, r0)
            java.lang.String r4 = "common_google_play_services_restricted_profile_title"
            java.lang.String r3 = a((android.content.Context) r3, (java.lang.String) r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.d.a(android.content.Context, int):java.lang.String");
    }

    private static String a(Context context, String str) {
        synchronized (a) {
            String str2 = a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources a2 = e.a(context);
            if (a2 == null) {
                return null;
            }
            int identifier = a2.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = a2.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            a.put(str, string);
            return string;
        }
    }

    private static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a2 = a(context, str);
        if (a2 == null) {
            a2 = resources.getString(h.a.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a2, new Object[]{str2});
    }

    public static String b(Context context) {
        return context.getResources().getString(a.b.common_google_play_services_notification_channel_name);
    }

    public static String b(Context context, int i) {
        String a2 = i == 6 ? a(context, "common_google_play_services_resolution_required_title") : a(context, i);
        return a2 == null ? context.getResources().getString(a.b.common_google_play_services_notification_ticker) : a2;
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String a2 = a(context);
        if (i == 5) {
            return a(context, "common_google_play_services_invalid_account_text", a2);
        }
        if (i == 7) {
            return a(context, "common_google_play_services_network_error_text", a2);
        }
        if (i == 9) {
            return resources.getString(a.b.common_google_play_services_unsupported_text, new Object[]{a2});
        } else if (i == 20) {
            return a(context, "common_google_play_services_restricted_profile_text", a2);
        } else {
            switch (i) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    return resources.getString(a.b.common_google_play_services_install_text, new Object[]{a2});
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    if (com.google.android.gms.common.util.f.b(context)) {
                        return resources.getString(a.b.common_google_play_services_wear_update_text);
                    }
                    return resources.getString(a.b.common_google_play_services_update_text, new Object[]{a2});
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    return resources.getString(a.b.common_google_play_services_enable_text, new Object[]{a2});
                default:
                    switch (i) {
                        case f.a.MapAttrs_uiRotateGestures /*16*/:
                            return a(context, "common_google_play_services_api_unavailable_text", a2);
                        case f.a.MapAttrs_uiScrollGestures /*17*/:
                            return a(context, "common_google_play_services_sign_in_failed_text", a2);
                        case f.a.MapAttrs_uiScrollGesturesDuringRotateOrZoom /*18*/:
                            return resources.getString(a.b.common_google_play_services_updating_text, new Object[]{a2});
                        default:
                            return resources.getString(h.a.common_google_play_services_unknown_issue, new Object[]{a2});
                    }
            }
        }
    }

    public static String d(Context context, int i) {
        return i == 6 ? a(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i);
    }

    public static String e(Context context, int i) {
        int i2;
        Resources resources = context.getResources();
        switch (i) {
            case f.a.MapAttrs_cameraBearing /*1*/:
                i2 = a.b.common_google_play_services_install_button;
                break;
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                i2 = a.b.common_google_play_services_update_button;
                break;
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                i2 = a.b.common_google_play_services_enable_button;
                break;
            default:
                i2 = 17039370;
                break;
        }
        return resources.getString(i2);
    }
}
