package com.hiq.sensor;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.h;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.b;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.LatLng;

public class GpsActivity extends h implements LocationListener {
    static final LatLng m = new LatLng(58.3992d, 15.5769d);
    private LocationManager n;
    /* access modifiers changed from: private */
    public c o;
    private String p;
    private TextView q;
    private TextView r;

    private void g() {
        if (this.o == null) {
            ((SupportMapFragment) f().a(R.id.map)).a((e) new e() {
                public void a(c cVar) {
                    c unused = GpsActivity.this.o = cVar;
                    GpsActivity.this.o.a(0, 100, 0, 0);
                    GpsActivity.this.o.a(true);
                    GpsActivity.this.o.b().a(true);
                }
            });
        }
    }

    public void info(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sensor information");
        builder.setIcon(R.drawable.info);
        builder.setMessage(R.string.GPSInfo);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.o == null) {
            return super.onContextItemSelected(menuItem);
        }
        switch (menuItem.getItemId()) {
            case R.id.map_hybrid /*2131165234*/:
                this.o.a(4);
                return true;
            case R.id.map_normal /*2131165235*/:
                this.o.a(1);
                return true;
            case R.id.map_satellite /*2131165236*/:
                this.o.a(2);
                return true;
            case R.id.map_terrain /*2131165237*/:
                this.o.a(3);
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        c cVar;
        LatLng latLng;
        super.onCreate(bundle);
        setContentView(R.layout.gps);
        this.q = (TextView) findViewById(R.id.latitude_value);
        this.r = (TextView) findViewById(R.id.longitude_value);
        this.n = (LocationManager) getSystemService("location");
        if (!this.n.isProviderEnabled("gps")) {
            new a(this).show();
        }
        this.p = "gps";
        Location lastKnownLocation = this.n.getLastKnownLocation(this.p);
        this.o = null;
        if (Build.VERSION.SDK_INT >= 11) {
            registerForContextMenu(findViewById(R.id.linearLayout1));
        }
        g();
        if (lastKnownLocation != null) {
            this.q.setText(String.format("%2.5f", new Object[]{Double.valueOf(lastKnownLocation.getLatitude())}));
            this.r.setText(String.format("%2.5f", new Object[]{Double.valueOf(lastKnownLocation.getLongitude())}));
            if (this.o != null) {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                cVar = this.o;
            } else {
                return;
            }
        } else {
            String string = getResources().getString(R.string.noProviderAvailable);
            this.q.setText(string);
            this.r.setText(string);
            cVar = this.o;
            if (cVar != null) {
                latLng = m;
            } else {
                return;
            }
        }
        cVar.a(b.a(latLng, 13.0f));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.o != null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            getMenuInflater().inflate(R.menu.mapmenu, contextMenu);
            contextMenu.getItem(this.o.a() - 1).setChecked(true);
        }
    }

    public void onLocationChanged(Location location) {
        this.q.setText(String.format("%2.5f", new Object[]{Double.valueOf(location.getLatitude())}));
        this.r.setText(String.format("%2.5f", new Object[]{Double.valueOf(location.getLongitude())}));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.n.removeUpdates(this);
    }

    public void onProviderDisabled(String str) {
        Context applicationContext = getApplicationContext();
        Toast.makeText(applicationContext, "Disabled provider " + str, 0).show();
    }

    public void onProviderEnabled(String str) {
        Context applicationContext = getApplicationContext();
        Toast.makeText(applicationContext, "Enabled new provider " + str, 0).show();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.n.requestLocationUpdates(this.p, 1000, 0.0f, this);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
