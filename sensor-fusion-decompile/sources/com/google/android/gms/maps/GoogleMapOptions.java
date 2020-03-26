package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.a.f;
import com.google.android.gms.maps.f;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new h();
    private Boolean a;
    private Boolean b;
    private int c = -1;
    private CameraPosition d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Float n = null;
    private Float o = null;
    private LatLngBounds p = null;
    private Boolean q;

    public GoogleMapOptions() {
    }

    GoogleMapOptions(byte b2, byte b3, int i2, CameraPosition cameraPosition, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, Float f2, Float f3, LatLngBounds latLngBounds, byte b13) {
        this.a = f.a(b2);
        this.b = f.a(b3);
        this.c = i2;
        this.d = cameraPosition;
        this.e = f.a(b4);
        this.f = f.a(b5);
        this.g = f.a(b6);
        this.h = f.a(b7);
        this.i = f.a(b8);
        this.j = f.a(b9);
        this.k = f.a(b10);
        this.l = f.a(b11);
        this.m = f.a(b12);
        this.n = f2;
        this.o = f3;
        this.p = latLngBounds;
        this.q = f.a(b13);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, f.a.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(f.a.MapAttrs_mapType)) {
            googleMapOptions.a(obtainAttributes.getInt(f.a.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_zOrderOnTop)) {
            googleMapOptions.a(obtainAttributes.getBoolean(f.a.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_useViewLifecycle)) {
            googleMapOptions.b(obtainAttributes.getBoolean(f.a.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiCompass)) {
            googleMapOptions.d(obtainAttributes.getBoolean(f.a.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiRotateGestures)) {
            googleMapOptions.h(obtainAttributes.getBoolean(f.a.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.i(obtainAttributes.getBoolean(f.a.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiScrollGestures)) {
            googleMapOptions.e(obtainAttributes.getBoolean(f.a.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiTiltGestures)) {
            googleMapOptions.g(obtainAttributes.getBoolean(f.a.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiZoomGestures)) {
            googleMapOptions.f(obtainAttributes.getBoolean(f.a.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiZoomControls)) {
            googleMapOptions.c(obtainAttributes.getBoolean(f.a.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_liteMode)) {
            googleMapOptions.j(obtainAttributes.getBoolean(f.a.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_uiMapToolbar)) {
            googleMapOptions.k(obtainAttributes.getBoolean(f.a.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_ambientEnabled)) {
            googleMapOptions.l(obtainAttributes.getBoolean(f.a.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.a(obtainAttributes.getFloat(f.a.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.b(obtainAttributes.getFloat(f.a.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.a(b(context, attributeSet));
        googleMapOptions.a(c(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds b(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, f.a.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(f.a.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(f.a.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(f.a.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(f.a.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(f.a.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(f.a.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(f.a.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(f.a.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition c(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, f.a.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(f.a.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(f.a.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(f.a.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(f.a.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        CameraPosition.a a2 = CameraPosition.a();
        a2.a(latLng);
        if (obtainAttributes.hasValue(f.a.MapAttrs_cameraZoom)) {
            a2.a(obtainAttributes.getFloat(f.a.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_cameraBearing)) {
            a2.c(obtainAttributes.getFloat(f.a.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(f.a.MapAttrs_cameraTilt)) {
            a2.b(obtainAttributes.getFloat(f.a.MapAttrs_cameraTilt, 0.0f));
        }
        obtainAttributes.recycle();
        return a2.a();
    }

    public final int a() {
        return this.c;
    }

    public final GoogleMapOptions a(float f2) {
        this.n = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions a(int i2) {
        this.c = i2;
        return this;
    }

    public final GoogleMapOptions a(CameraPosition cameraPosition) {
        this.d = cameraPosition;
        return this;
    }

    public final GoogleMapOptions a(LatLngBounds latLngBounds) {
        this.p = latLngBounds;
        return this;
    }

    public final GoogleMapOptions a(boolean z) {
        this.a = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions b(float f2) {
        this.o = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions b(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public final CameraPosition b() {
        return this.d;
    }

    public final GoogleMapOptions c(boolean z) {
        this.e = Boolean.valueOf(z);
        return this;
    }

    public final Float c() {
        return this.n;
    }

    public final GoogleMapOptions d(boolean z) {
        this.f = Boolean.valueOf(z);
        return this;
    }

    public final Float d() {
        return this.o;
    }

    public final GoogleMapOptions e(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public final LatLngBounds e() {
        return this.p;
    }

    public final GoogleMapOptions f(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions g(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions h(boolean z) {
        this.j = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions i(boolean z) {
        this.q = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions j(boolean z) {
        this.k = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions k(boolean z) {
        this.l = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions l(boolean z) {
        this.m = Boolean.valueOf(z);
        return this;
    }

    public final String toString() {
        return m.a((Object) this).a("MapType", Integer.valueOf(this.c)).a("LiteMode", this.k).a("Camera", this.d).a("CompassEnabled", this.f).a("ZoomControlsEnabled", this.e).a("ScrollGesturesEnabled", this.g).a("ZoomGesturesEnabled", this.h).a("TiltGesturesEnabled", this.i).a("RotateGesturesEnabled", this.j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.q).a("MapToolbarEnabled", this.l).a("AmbientEnabled", this.m).a("MinZoomPreference", this.n).a("MaxZoomPreference", this.o).a("LatLngBoundsForCameraTarget", this.p).a("ZOrderOnTop", this.a).a("UseViewLifecycleInFragment", this.b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, com.google.android.gms.maps.a.f.a(this.a));
        b.a(parcel, 3, com.google.android.gms.maps.a.f.a(this.b));
        b.a(parcel, 4, a());
        b.a(parcel, 5, (Parcelable) b(), i2, false);
        b.a(parcel, 6, com.google.android.gms.maps.a.f.a(this.e));
        b.a(parcel, 7, com.google.android.gms.maps.a.f.a(this.f));
        b.a(parcel, 8, com.google.android.gms.maps.a.f.a(this.g));
        b.a(parcel, 9, com.google.android.gms.maps.a.f.a(this.h));
        b.a(parcel, 10, com.google.android.gms.maps.a.f.a(this.i));
        b.a(parcel, 11, com.google.android.gms.maps.a.f.a(this.j));
        b.a(parcel, 12, com.google.android.gms.maps.a.f.a(this.k));
        b.a(parcel, 14, com.google.android.gms.maps.a.f.a(this.l));
        b.a(parcel, 15, com.google.android.gms.maps.a.f.a(this.m));
        b.a(parcel, 16, c(), false);
        b.a(parcel, 17, d(), false);
        b.a(parcel, 18, (Parcelable) e(), i2, false);
        b.a(parcel, 19, com.google.android.gms.maps.a.f.a(this.q));
        b.a(parcel, a2);
    }
}
