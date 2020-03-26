package com.google.android.gms.common.api;

import com.google.android.gms.maps.f;

public class d {
    public static String a(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case f.a.MapAttrs_ambientEnabled /*0*/:
                return "SUCCESS";
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
            case f.a.MapAttrs_latLngBoundsSouthWestLatitude /*10*/:
                return "DEVELOPER_ERROR";
            case f.a.MapAttrs_mapType /*13*/:
                return "ERROR";
            case f.a.MapAttrs_uiCompass /*14*/:
                return "INTERRUPTED";
            case f.a.MapAttrs_uiMapToolbar /*15*/:
                return "TIMEOUT";
            case f.a.MapAttrs_uiRotateGestures /*16*/:
                return "CANCELED";
            case f.a.MapAttrs_uiScrollGestures /*17*/:
                return "API_NOT_CONNECTED";
            case f.a.MapAttrs_uiScrollGesturesDuringRotateOrZoom /*18*/:
                return "DEAD_CLIENT";
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
        }
    }
}
