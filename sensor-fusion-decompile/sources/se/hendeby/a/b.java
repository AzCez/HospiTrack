package se.hendeby.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.google.android.gms.maps.f;
import java.util.List;
import java.util.Locale;
import se.hendeby.b.c;
import se.hendeby.sfapp.LogService;

public class b extends PhoneStateListener implements d {
    private TelephonyManager a;
    private LogService.c b;

    public b(Context context) {
        this.a = (TelephonyManager) context.getSystemService("phone");
    }

    private int a(int i) {
        if (i < 0) {
            return i;
        }
        if (i == 99) {
            return -1;
        }
        return (i * 2) - 113;
    }

    private c a(long j, int i, int i2, CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (cellInfo instanceof CellInfoGsm) {
                return a(j, i, i2, (CellInfoGsm) cellInfo);
            } else if (cellInfo instanceof CellInfoCdma) {
                return a(j, i, i2, (CellInfoCdma) cellInfo);
            } else if (cellInfo instanceof CellInfoLte) {
                return a(j, i, i2, (CellInfoLte) cellInfo);
            }
        }
        if (Build.VERSION.SDK_INT < 18 || !(cellInfo instanceof CellInfoWcdma)) {
            Log.d("CELLRSS", "Unknown cell network encountered");
            return null;
        }
        return a(j, i, i2, (CellInfoWcdma) cellInfo);
    }

    private c a(long j, int i, int i2, CellInfoCdma cellInfoCdma) {
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        int systemId = cellIdentity.getSystemId() < Integer.MAX_VALUE ? cellIdentity.getSystemId() : -1;
        int networkId = cellIdentity.getNetworkId() < Integer.MAX_VALUE ? cellIdentity.getNetworkId() : -1;
        int basestationId = cellIdentity.getBasestationId() < Integer.MAX_VALUE ? cellIdentity.getBasestationId() : -1;
        int evdoDbm = cellInfoCdma.getCellSignalStrength().getEvdoDbm();
        if (basestationId == i && -1 == i2) {
            i3 = this.a.getNetworkType();
        } else {
            i3 = -1;
        }
        return new c(j, i3, "CDMA", String.format(Locale.US, "%03d%02d", new Object[]{Integer.valueOf(systemId), Integer.valueOf(networkId)}), basestationId, -1, evdoDbm);
    }

    private c a(long j, int i, int i2, CellInfoGsm cellInfoGsm) {
        int i3;
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        int mnc = cellIdentity.getMnc() < Integer.MAX_VALUE ? cellIdentity.getMnc() : -1;
        int mcc = cellIdentity.getMcc() < Integer.MAX_VALUE ? cellIdentity.getMcc() : -1;
        int cid = cellIdentity.getCid() < Integer.MAX_VALUE ? cellIdentity.getCid() : -1;
        int dbm = cellInfoGsm.getCellSignalStrength().getDbm();
        if (cid == i && -1 == i2) {
            i3 = this.a.getNetworkType();
        } else {
            i3 = -1;
        }
        return new c(j, i3, "GSM", String.format(Locale.US, "%03d%02d", new Object[]{Integer.valueOf(mcc), Integer.valueOf(mnc)}), cid, -1, dbm);
    }

    private c a(long j, int i, int i2, CellInfoLte cellInfoLte) {
        int i3;
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        int mnc = cellIdentity.getMnc() < Integer.MAX_VALUE ? cellIdentity.getMnc() : -1;
        int mcc = cellIdentity.getMcc() < Integer.MAX_VALUE ? cellIdentity.getMcc() : -1;
        int ci = cellIdentity.getCi() < Integer.MAX_VALUE ? cellIdentity.getCi() : -1;
        int pci = cellIdentity.getPci() < Integer.MAX_VALUE ? cellIdentity.getPci() : -1;
        int dbm = cellInfoLte.getCellSignalStrength().getDbm();
        if (ci == i && pci == i2) {
            i3 = this.a.getNetworkType();
        } else {
            i3 = -1;
        }
        return new c(j, i3, "LTE", String.format(Locale.US, "%03d%02d", new Object[]{Integer.valueOf(mcc), Integer.valueOf(mnc)}), ci, pci, dbm);
    }

    private c a(long j, int i, int i2, CellInfoWcdma cellInfoWcdma) {
        int i3;
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        int mnc = cellIdentity.getMnc() < Integer.MAX_VALUE ? cellIdentity.getMnc() : -1;
        int mcc = cellIdentity.getMcc() < Integer.MAX_VALUE ? cellIdentity.getMcc() : -1;
        int cid = cellIdentity.getCid() < Integer.MAX_VALUE ? cellIdentity.getCid() : -1;
        int psc = cellIdentity.getPsc() < Integer.MAX_VALUE ? cellIdentity.getPsc() : -1;
        int dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
        if (cid == i && psc == i2) {
            i3 = this.a.getNetworkType();
        } else {
            i3 = -1;
        }
        return new c(j, i3, "WCDMA", String.format(Locale.US, "%03d%02d", new Object[]{Integer.valueOf(mcc), Integer.valueOf(mnc)}), cid, psc, dbm);
    }

    @TargetApi(18)
    private void a(long j, int i, int i2) {
        List<CellInfo> allCellInfo = this.a.getAllCellInfo();
        if (allCellInfo != null) {
            for (CellInfo a2 : allCellInfo) {
                c a3 = a(j, i, i2, a2);
                if (a3 != null) {
                    this.b.a(a3);
                }
            }
        }
    }

    public void a(Context context) {
        this.a.listen(this, 0);
    }

    public void a(Context context, LogService.c cVar) {
        this.a.listen(this, 256);
        this.b = cVar;
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        int networkType = this.a.getNetworkType();
        String networkOperator = this.a.getNetworkOperator();
        if (this.a.getPhoneType() != 0 && this.a.getCellLocation() != null) {
            switch (networkType) {
                case f.a.MapAttrs_cameraBearing:
                case f.a.MapAttrs_cameraMaxZoomPreference:
                    str2 = "GSM";
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference:
                case f.a.MapAttrs_latLngBoundsNorthEastLatitude:
                case f.a.MapAttrs_latLngBoundsNorthEastLongitude:
                case f.a.MapAttrs_latLngBoundsSouthWestLatitude:
                case f.a.MapAttrs_uiMapToolbar:
                    str2 = "WCDMA";
                    break;
                case f.a.MapAttrs_cameraTargetLat:
                case f.a.MapAttrs_cameraTargetLng:
                case f.a.MapAttrs_cameraTilt:
                case f.a.MapAttrs_cameraZoom:
                case f.a.MapAttrs_liteMode:
                case f.a.MapAttrs_uiCompass:
                    str = "CDMA";
                    i3 = ((CdmaCellLocation) this.a.getCellLocation()).getBaseStationId();
                    i = signalStrength.getEvdoDbm();
                    i2 = -1;
                    break;
                default:
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) this.a.getCellLocation();
                    int cid = gsmCellLocation.getCid();
                    str = "LTE";
                    i2 = gsmCellLocation.getPsc();
                    i3 = cid;
                    i = -1;
                    break;
            }
            GsmCellLocation gsmCellLocation2 = (GsmCellLocation) this.a.getCellLocation();
            int cid2 = gsmCellLocation2.getCid();
            str = str2;
            i2 = gsmCellLocation2.getPsc();
            i3 = cid2;
            i = a(signalStrength.getGsmSignalStrength());
            if (Build.VERSION.SDK_INT >= 17) {
                a(currentTimeMillis, i3, i2);
                return;
            }
            this.b.a(new c(currentTimeMillis, networkType, str, networkOperator, i3, i2, i));
            for (NeighboringCellInfo neighboringCellInfo : this.a.getNeighboringCellInfo()) {
                int cid3 = neighboringCellInfo.getCid();
                int psc = neighboringCellInfo.getPsc();
                int rssi = neighboringCellInfo.getRssi();
                LogService.c cVar = this.b;
                c cVar2 = r1;
                c cVar3 = new c(currentTimeMillis, -1, str, networkOperator, cid3, psc, rssi);
                cVar.a(cVar2);
            }
        }
    }
}
