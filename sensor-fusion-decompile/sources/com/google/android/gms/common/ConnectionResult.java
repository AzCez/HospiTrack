package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.f;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new j();
    public static final ConnectionResult a = new ConnectionResult(0);
    private final int b;
    private final int c;
    private final PendingIntent d;
    private final String e;

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null, (String) null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.b = i;
        this.c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case f.a.MapAttrs_ambientEnabled /*0*/:
                return "SUCCESS";
            case f.a.MapAttrs_cameraBearing /*1*/:
                return "SERVICE_MISSING";
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return "SERVICE_DISABLED";
            case f.a.MapAttrs_cameraTargetLat /*4*/:
                return "SIGN_IN_REQUIRED";
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                return "INVALID_ACCOUNT";
            case f.a.MapAttrs_cameraTilt /*6*/:
                return "RESOLUTION_REQUIRED";
            case f.a.MapAttrs_cameraZoom /*7*/:
                return "NETWORK_ERROR";
            case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                return "INTERNAL_ERROR";
            case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                return "SERVICE_INVALID";
            case f.a.MapAttrs_latLngBoundsSouthWestLatitude /*10*/:
                return "DEVELOPER_ERROR";
            case f.a.MapAttrs_latLngBoundsSouthWestLongitude /*11*/:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case f.a.MapAttrs_mapType /*13*/:
                        return "CANCELED";
                    case f.a.MapAttrs_uiCompass /*14*/:
                        return "TIMEOUT";
                    case f.a.MapAttrs_uiMapToolbar /*15*/:
                        return "INTERRUPTED";
                    case f.a.MapAttrs_uiRotateGestures /*16*/:
                        return "API_UNAVAILABLE";
                    case f.a.MapAttrs_uiScrollGestures /*17*/:
                        return "SIGN_IN_FAILED";
                    case f.a.MapAttrs_uiScrollGesturesDuringRotateOrZoom /*18*/:
                        return "SERVICE_UPDATING";
                    case f.a.MapAttrs_uiTiltGestures /*19*/:
                        return "SERVICE_MISSING_PERMISSION";
                    case f.a.MapAttrs_uiZoomControls /*20*/:
                        return "RESTRICTED_PROFILE";
                    case f.a.MapAttrs_uiZoomGestures /*21*/:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean a() {
        return (this.c == 0 || this.d == null) ? false : true;
    }

    public final boolean b() {
        return this.c == 0;
    }

    public final int c() {
        return this.c;
    }

    public final PendingIntent d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.c == connectionResult.c && m.a(this.d, connectionResult.d) && m.a(this.e, connectionResult.e);
    }

    public final int hashCode() {
        return m.a(Integer.valueOf(this.c), this.d, this.e);
    }

    public final String toString() {
        return m.a((Object) this).a("statusCode", a(this.c)).a("resolution", this.d).a("message", this.e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.b);
        b.a(parcel, 2, c());
        b.a(parcel, 3, (Parcelable) d(), i, false);
        b.a(parcel, 4, e(), false);
        b.a(parcel, a2);
    }
}
