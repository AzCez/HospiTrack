package se.hendeby.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.SparseIntArray;
import java.util.List;
import se.hendeby.b.p;
import se.hendeby.sfapp.LogService;

public class g extends BroadcastReceiver implements d {
    private boolean a = false;
    private WifiManager b;
    private WifiManager.WifiLock c;
    private long d = 0;
    private LogService.c e;
    private SparseIntArray f = null;

    public g(Context context) {
        this.b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void b() {
        this.f = new SparseIntArray();
        if (this.b.getConfiguredNetworks() != null) {
            for (WifiConfiguration next : this.b.getConfiguredNetworks()) {
                this.f.put(next.networkId, next.status);
                this.b.disableNetwork(next.networkId);
            }
        }
    }

    private void c() {
        SparseIntArray sparseIntArray = this.f;
        if (sparseIntArray != null) {
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                this.b.enableNetwork(this.f.keyAt(i), this.f.valueAt(i) != 0);
            }
            this.f = null;
        }
    }

    public void a() {
        this.c.release();
        c();
    }

    public void a(Context context) {
        if (this.a) {
            context.unregisterReceiver(this);
            this.a = false;
            a();
        }
    }

    public void a(Context context, LogService.c cVar) {
        a(false);
        this.a = true;
        context.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        ((WifiManager) context.getApplicationContext().getSystemService("wifi")).startScan();
        this.e = cVar;
    }

    public void a(boolean z) {
        this.c = this.b.createWifiLock(2, "SenorFusionApp WiFi Scan");
        this.c.acquire();
        b();
        if (z) {
            this.b.disconnect();
        }
    }

    @TargetApi(17)
    public void onReceive(Context context, Intent intent) {
        List<ScanResult> scanResults = this.b.getScanResults();
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.d;
        for (ScanResult next : scanResults) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (next.timestamp > j) {
                    this.d = Math.max(this.d, next.timestamp);
                }
            }
            this.e.a(new p(currentTimeMillis, next.BSSID, next.SSID, next.frequency, next.level));
        }
        this.b.startScan();
    }
}
