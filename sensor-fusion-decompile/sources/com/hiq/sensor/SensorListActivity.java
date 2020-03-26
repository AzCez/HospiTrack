package com.hiq.sensor;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.a;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorListActivity extends Activity {
    static final Map<Integer, String> d = new HashMap<Integer, String>() {
        {
            put(1, "m/s^2");
            put(4, "rad/s");
            if (Build.VERSION.SDK_INT >= 18) {
                put(16, "rad/s");
            }
            put(2, "uT");
            if (Build.VERSION.SDK_INT >= 18) {
                put(14, "uT");
            }
            put(7, "deg C");
            put(6, "hPa");
            put(8, "cm");
            put(5, "lux");
            put(11, "");
        }
    };
    ExpandableListAdapter a;
    List<Map<String, String>> b;
    List<List<Map<String, String>>> c;

    private int a(List<Map<String, String>> list, String str) {
        int i = 0;
        while (i < list.size() && ((String) list.get(i).get("ROOT")).compareToIgnoreCase(str) <= 0) {
            i++;
        }
        return i;
    }

    private String a(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 18 && getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            final String a2 = a(getResources().getString(R.string.RSS_BLE));
            int a3 = a(this.b, a2);
            this.b.add(a3, new HashMap<String, String>() {
                {
                    put("ROOT", a2);
                }
            });
            if (a.a(this, "android.permission.BLUETOOTH_ADMIN") == 0) {
                final BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
                this.c.add(a3, new ArrayList<Map<String, String>>() {
                    {
                        add(new HashMap<String, String>() {
                            {
                                put("SENSOR_INFO", "Supported: \ttrue");
                            }
                        });
                        add(new HashMap<String, String>() {
                            {
                                put("SENSOR_INFO", "Name: \t" + adapter.getName());
                            }
                        });
                        add(new HashMap<String, String>() {
                            {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Status: \t");
                                sb.append(adapter.isEnabled() ? "on" : "off");
                                put("SENSOR_INFO", sb.toString());
                            }
                        });
                    }
                });
                return;
            }
            this.c.add(a3, new ArrayList<Map<String, String>>() {
                {
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Permissions to access BLE device not granted!  Please, make sure to grant the app access to Bluetooth to use BLE.");
                        }
                    });
                }
            });
        }
    }

    private void b() {
        if (getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            final String a2 = a(getResources().getString(R.string.RSS_CELL));
            int a3 = a(this.b, a2);
            this.b.add(a3, new HashMap<String, String>() {
                {
                    put("ROOT", a2);
                }
            });
            this.c.add(a3, new ArrayList<Map<String, String>>() {
                {
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Supported: \ttrue");
                        }
                    });
                }
            });
        }
    }

    private void c() {
        if (getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            final String a2 = a(getResources().getString(R.string.GPS));
            int a3 = a(this.b, a2);
            this.b.add(a3, new HashMap<String, String>() {
                {
                    put("ROOT", a2);
                }
            });
            if (a.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                final LocationManager locationManager = (LocationManager) getSystemService("location");
                this.c.add(a3, new ArrayList<Map<String, String>>() {
                    {
                        add(new HashMap<String, String>() {
                            {
                                put("SENSOR_INFO", "Supported: \ttrue");
                            }
                        });
                        add(new HashMap<String, String>() {
                            {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Status: \t");
                                sb.append(locationManager.isProviderEnabled("gps") ? "on" : "off");
                                put("SENSOR_INFO", sb.toString());
                            }
                        });
                    }
                });
                return;
            }
            this.c.add(a3, new ArrayList<Map<String, String>>() {
                {
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Permissions to access GPS data not granted!  Please, make sure to grant the app access to location information.");
                        }
                    });
                }
            });
        }
    }

    private void d() {
        if (getPackageManager().hasSystemFeature("android.hardware.wifi")) {
            final String a2 = a(getResources().getString(R.string.RSS_WIFI));
            int a3 = a(this.b, a2);
            this.b.add(a3, new HashMap<String, String>() {
                {
                    put("ROOT", a2);
                }
            });
            if (a.a(this, "android.permission.CHANGE_WIFI_STATE") == 0) {
                final WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
                final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                this.c.add(a3, new ArrayList<Map<String, String>>() {
                    {
                        add(new HashMap<String, String>() {
                            {
                                put("SENSOR_INFO", "Supported: \ttrue");
                            }
                        });
                        add(new HashMap<String, String>() {
                            {
                                try {
                                    byte[] byteArray = BigInteger.valueOf((long) connectionInfo.getIpAddress()).toByteArray();
                                    byte[] bArr = new byte[4];
                                    byte b = 0;
                                    bArr[0] = byteArray.length > 3 ? byteArray[3] : 0;
                                    bArr[1] = byteArray.length > 2 ? byteArray[2] : 0;
                                    bArr[2] = byteArray.length > 1 ? byteArray[1] : 0;
                                    bArr[3] = byteArray.length > 0 ? byteArray[0] : b;
                                    put("SENSOR_INFO", "IP: \t" + InetAddress.getByAddress(bArr).getHostAddress());
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        if (Build.VERSION.SDK_INT >= 21) {
                            add(new HashMap<String, String>() {
                                {
                                    put("SENSOR_INFO", "Support 5GHz: \t" + wifiManager.is5GHzBandSupported());
                                }
                            });
                        }
                        add(new HashMap<String, String>() {
                            {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Status: \t");
                                sb.append(wifiManager.isWifiEnabled() ? "on" : "off");
                                put("SENSOR_INFO", sb.toString());
                            }
                        });
                    }
                });
                return;
            }
            this.c.add(a3, new ArrayList<Map<String, String>>() {
                {
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Permissions to access GPS data not granted!  Please, make sure to grant the app access to location information.");
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sensor_list);
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.sensorlist);
        this.b = new ArrayList();
        this.c = new ArrayList();
        for (final Sensor next : ((SensorManager) getSystemService("sensor")).getSensorList(-1)) {
            final boolean containsKey = d.containsKey(Integer.valueOf(next.getType()));
            final String str = containsKey ? d.get(Integer.valueOf(next.getType())) : "<unknown>";
            final String a2 = a(next.getName());
            int a3 = a(this.b, a2);
            this.b.add(a3, new HashMap<String, String>() {
                {
                    put("ROOT", a2);
                }
            });
            this.c.add(a3, new ArrayList<Map<String, String>>() {
                {
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Unit: \t" + str);
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Supported: \t");
                            sb.append(containsKey ? "true" : "false");
                            put("SENSOR_INFO", sb.toString());
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Resolution:\t" + next.getResolution());
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Range:\t" + next.getMaximumRange());
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Power usage:\t" + next.getPower() + " mA");
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Vendor: \t" + next.getVendor());
                        }
                    });
                    add(new HashMap<String, String>() {
                        {
                            put("SENSOR_INFO", "Version: \t" + next.getVersion());
                        }
                    });
                }
            });
        }
        a();
        b();
        c();
        d();
        this.a = new SimpleExpandableListAdapter(this, this.b, R.layout.sensor_name_row, new String[]{"ROOT"}, new int[]{R.id.sensor_name}, this.c, R.layout.sensor_info_row, new String[]{"SENSOR_INFO"}, new int[]{R.id.sensor_info});
        expandableListView.setAdapter(this.a);
    }
}
