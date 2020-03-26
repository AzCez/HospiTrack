package se.hendeby.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import java.util.List;
import se.hendeby.b.b;
import se.hendeby.sfapp.LogService;

public class a extends ScanCallback implements d {
    private BluetoothLeScanner a = null;
    private LogService.c b;
    private long c = 1000000;

    public a(Context context) {
        if (android.support.v4.app.a.a(context, "android.permission.BLUETOOTH_ADMIN") == 0) {
            BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
            if (adapter.isEnabled()) {
                this.a = adapter.getBluetoothLeScanner();
            }
        }
    }

    public void a(Context context) {
        BluetoothLeScanner bluetoothLeScanner = this.a;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this);
        }
    }

    public void a(Context context, LogService.c cVar) {
        this.b = cVar;
        if (this.a != null) {
            this.a.startScan((List) null, new ScanSettings.Builder().setScanMode(2).build(), this);
        }
    }

    public void onScanResult(int i, ScanResult scanResult) {
        this.b.a(new b(scanResult.getTimestampNanos() / this.c, scanResult.getDevice().getName(), scanResult.getDevice().getAddress(), scanResult.getRssi()));
    }
}
