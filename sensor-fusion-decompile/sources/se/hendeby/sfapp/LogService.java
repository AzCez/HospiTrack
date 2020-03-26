package se.hendeby.sfapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.v;
import android.text.format.Time;
import android.widget.Toast;
import com.hiq.sensor.LogActivity;
import com.hiq.sensor.R;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.net.UnknownHostException;
import se.hendeby.a.d;
import se.hendeby.a.e;
import se.hendeby.a.f;
import se.hendeby.a.g;
import se.hendeby.b.m;

public class LogService extends Service {
    static final /* synthetic */ boolean f = (!LogService.class.desiredAssertionStatus());
    BufferedWriter a;
    WeakReference<a> b = new WeakReference<>((Object) null);
    String c = null;
    OutputStream d = null;
    Socket e = null;
    private SharedPreferences g;
    private f h;
    private d i;
    private d j;
    private d k;
    private se.hendeby.a.a l;
    private e m;
    private File n;
    private float o;
    /* access modifiers changed from: private */
    public boolean p;

    private class a implements Runnable {
        String a;
        int b;
        String c = "";

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.c;
        }

        public void run() {
            String str;
            try {
                LogService.this.e = new Socket(this.a, this.b);
                LogService.this.e.setReuseAddress(true);
                LogService.this.e.setSoTimeout(2000);
                return;
            } catch (UnknownHostException unused) {
                str = "Cannot determine IP, connection unsuccessful";
            } catch (IOException unused2) {
                str = "I/O error, connection unsuccessful";
            }
            this.c = str;
            LogService.this.e = null;
        }
    }

    public class b extends Binder {
        public b() {
        }

        /* access modifiers changed from: package-private */
        public LogService a() {
            return LogService.this;
        }
    }

    public class c {
        WeakReference<LogService> a;

        c(LogService logService) {
            this.a = new WeakReference<>(logService);
        }

        public void a(m mVar) {
            LogService logService = (LogService) this.a.get();
            if (logService != null) {
                logService.a(mVar);
            }
        }
    }

    private void a(boolean z) {
        this.p = z;
        if (this.b.get() != null) {
            ((a) this.b.get()).c();
        }
    }

    private v.c e() {
        NotificationChannel notificationChannel = new NotificationChannel("com.hiq.sensor", "SF App Background Service", 0);
        notificationChannel.setLightColor(-16776961);
        notificationChannel.setLockscreenVisibility(0);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (f || notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
            return new v.c(this, "com.hiq.sensor");
        }
        throw new AssertionError();
    }

    private File f() {
        String string = this.g.getString("logfile", getString(R.string.logfile_default));
        if (string.contains("%d")) {
            Time time = new Time();
            time.setToNow();
            string = string.replace("%d", time.format2445());
        }
        if (string.contains("%I")) {
            string = string.replace("%I", com.google.android.gms.c.a.b(getApplicationContext()).a());
        }
        File file = new File(string);
        return !file.isAbsolute() ? new File(Environment.getExternalStorageDirectory(), string) : file;
    }

    /* access modifiers changed from: private */
    public void g() {
        AnonymousClass3 r1;
        Handler handler;
        if (this.d != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        LogService.this.d.flush();
                        LogService.this.d.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        LogService.this.d = null;
                        throw th;
                    }
                    LogService.this.d = null;
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Socket socket = this.e;
        if (socket != null) {
            try {
                if (!socket.isClosed()) {
                    this.e.close();
                }
                this.e = null;
                handler = new Handler(getMainLooper());
                r1 = new Runnable() {
                    public void run() {
                        Toast.makeText(LogService.this.getApplicationContext(), "Streaming stopped", 0).show();
                    }
                };
            } catch (IOException e3) {
                e3.printStackTrace();
                this.e = null;
                handler = new Handler(getMainLooper());
                r1 = new Runnable() {
                    public void run() {
                        Toast.makeText(LogService.this.getApplicationContext(), "Streaming stopped", 0).show();
                    }
                };
            } catch (Throwable th) {
                this.e = null;
                new Handler(getMainLooper()).post(new Runnable() {
                    public void run() {
                        Toast.makeText(LogService.this.getApplicationContext(), "Streaming stopped", 0).show();
                    }
                });
                throw th;
            }
            handler.post(r1);
        }
    }

    private void h() {
        BufferedWriter bufferedWriter = this.a;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.flush();
                this.a.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.a = null;
                Toast.makeText(getApplicationContext(), "Logging stopped", 0).show();
                throw th;
            }
            this.a = null;
            Toast.makeText(getApplicationContext(), "Logging stopped", 0).show();
        }
    }

    private int i() {
        double parseInt = (double) Integer.parseInt(this.g.getString("frequency", "100"));
        Double.isNaN(parseInt);
        return (int) Math.round(1000000.0d / parseInt);
    }

    public void a(Sensor sensor, boolean z) {
        if (z) {
            this.m.a(sensor, i());
        } else {
            this.m.a(sensor);
        }
    }

    public void a(String str) {
        synchronized (this) {
            double length = (double) (this.n.length() + ((long) str.getBytes().length));
            double d2 = (double) this.o;
            Double.isNaN(d2);
            if (length < d2 * 1000000.0d) {
                try {
                    this.a.append(str);
                    this.a.newLine();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Max size of file reached: logging ended", 1).show();
                h();
                if (this.e == null) {
                    d();
                }
            }
        }
    }

    public void a(String str, boolean z) {
        d dVar;
        c cVar;
        Resources resources = getResources();
        if (str.equals(resources.getString(R.string.GPS))) {
            if (z) {
                this.k = new se.hendeby.a.c(this);
                if (a()) {
                    dVar = this.k;
                    cVar = new c(this);
                } else {
                    return;
                }
            } else {
                if (a()) {
                    this.k.a(this);
                }
                this.k = null;
                return;
            }
        } else if (Build.VERSION.SDK_INT < 21 || !str.equals(resources.getString(R.string.RSS_BLE))) {
            if (str.equals(resources.getString(R.string.RSS_WIFI))) {
                if (z) {
                    this.j = new g(this);
                    if (!a()) {
                        return;
                    }
                    if (this.e == null) {
                        dVar = this.j;
                        cVar = new c(this);
                    } else {
                        new Handler(getMainLooper()).post(new Runnable() {
                            public void run() {
                                Toast.makeText(LogService.this.getApplicationContext(), "Logging WiFi RSS is not available when streaming.", 0).show();
                            }
                        });
                        return;
                    }
                } else {
                    if (a()) {
                        this.j.a(this);
                    }
                    this.j = null;
                    return;
                }
            } else if (!str.equals(resources.getString(R.string.RSS_CELL))) {
                return;
            } else {
                if (z) {
                    this.i = new se.hendeby.a.b(this);
                    if (a()) {
                        dVar = this.i;
                        cVar = new c(this);
                    } else {
                        return;
                    }
                } else {
                    if (a()) {
                        this.i.a(this);
                    }
                    this.i = null;
                    return;
                }
            }
        } else if (z) {
            this.l = new se.hendeby.a.a(this);
            if (a()) {
                this.l.a(this, new c(this));
                return;
            }
            return;
        } else {
            if (a()) {
                this.l.a(this);
            }
            this.l = null;
            return;
        }
        dVar.a(this, cVar);
    }

    public void a(m mVar) {
        final byte[] a2 = mVar.a();
        if (this.a != null) {
            a(new String(a2));
        }
        if (this.e != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        LogService.this.d.write(a2);
                        LogService.this.d.write(10);
                        LogService.this.d.flush();
                    } catch (IOException unused) {
                        if (LogService.this.p) {
                            new Handler(LogService.this.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    Toast.makeText(LogService.this.getApplicationContext(), "Connection to server lost. Streaming stopped.", 1).show();
                                }
                            });
                            LogService.this.g();
                            if (LogService.this.a == null) {
                                LogService.this.d();
                            }
                        }
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.b = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f  */
    @android.annotation.TargetApi(18)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            se.hendeby.a.e r0 = r5.m
            int r1 = r5.i()
            r0.a((int) r1)
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x006d
            android.content.SharedPreferences r6 = r5.g
            java.lang.String r2 = "ip"
            java.lang.String r3 = "0.0.0.0"
            java.lang.String r6 = r6.getString(r2, r3)
            android.content.SharedPreferences r2 = r5.g
            java.lang.String r3 = "port"
            java.lang.String r4 = "3400"
            java.lang.String r2 = r2.getString(r3, r4)
            int r2 = java.lang.Integer.parseInt(r2)
            r5.e = r1
            se.hendeby.sfapp.LogService$a r3 = new se.hendeby.sfapp.LogService$a     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r3.<init>(r6, r2)     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.lang.Thread r6 = new java.lang.Thread     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r6.<init>(r3)     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r6.start()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r6.join()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.net.Socket r6 = r5.e     // Catch:{ IOException | InterruptedException -> 0x0060 }
            if (r6 != 0) goto L_0x004b
            android.content.Context r6 = r5.getApplicationContext()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.lang.String r2 = r3.a()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r2, r0)     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r6.show()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            goto L_0x006f
        L_0x004b:
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.net.Socket r3 = r5.e     // Catch:{ IOException | InterruptedException -> 0x0060 }
            java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r4 = 512(0x200, float:7.175E-43)
            r2.<init>(r3, r4)     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r6.<init>(r2)     // Catch:{ IOException | InterruptedException -> 0x0060 }
            r5.d = r6     // Catch:{ IOException | InterruptedException -> 0x0060 }
            goto L_0x006f
        L_0x0060:
            android.content.Context r6 = r5.getApplicationContext()
            java.lang.String r2 = "Connection cannot be created, please check IP/Port"
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r2, r0)
            r6.show()
        L_0x006d:
            r5.e = r1
        L_0x006f:
            if (r7 == 0) goto L_0x0086
            android.content.SharedPreferences r6 = r5.g
            java.lang.String r7 = "maxLogSize"
            java.lang.String r1 = "5"
            java.lang.String r6 = r6.getString(r7, r1)
            int r6 = java.lang.Integer.parseInt(r6)
            float r6 = (float) r6
            r5.o = r6
            r5.c()
            goto L_0x0088
        L_0x0086:
            r5.a = r1
        L_0x0088:
            java.io.BufferedWriter r6 = r5.a
            r7 = 0
            if (r6 != 0) goto L_0x0093
            java.net.Socket r6 = r5.e
            if (r6 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r0 = 0
        L_0x0093:
            r5.a((boolean) r0)
            java.io.BufferedWriter r6 = r5.a
            if (r6 != 0) goto L_0x009f
            java.net.Socket r6 = r5.e
            if (r6 != 0) goto L_0x009f
            return
        L_0x009f:
            android.app.Notification r6 = r5.b()
            se.hendeby.a.e r0 = r5.m
            se.hendeby.sfapp.LogService$c r1 = new se.hendeby.sfapp.LogService$c
            r1.<init>(r5)
            r0.a((android.content.Context) r5, (se.hendeby.sfapp.LogService.c) r1)
            se.hendeby.a.d r0 = r5.k
            if (r0 == 0) goto L_0x00b9
            se.hendeby.sfapp.LogService$c r1 = new se.hendeby.sfapp.LogService$c
            r1.<init>(r5)
            r0.a(r5, r1)
        L_0x00b9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x00cb
            se.hendeby.a.a r0 = r5.l
            if (r0 == 0) goto L_0x00cb
            se.hendeby.sfapp.LogService$c r1 = new se.hendeby.sfapp.LogService$c
            r1.<init>(r5)
            r0.a(r5, r1)
        L_0x00cb:
            se.hendeby.a.d r0 = r5.j
            if (r0 == 0) goto L_0x00ed
            java.net.Socket r1 = r5.e
            if (r1 != 0) goto L_0x00dc
            se.hendeby.sfapp.LogService$c r1 = new se.hendeby.sfapp.LogService$c
            r1.<init>(r5)
            r0.a(r5, r1)
            goto L_0x00ed
        L_0x00dc:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = r5.getMainLooper()
            r0.<init>(r1)
            se.hendeby.sfapp.LogService$4 r1 = new se.hendeby.sfapp.LogService$4
            r1.<init>()
            r0.post(r1)
        L_0x00ed:
            se.hendeby.a.d r0 = r5.i
            if (r0 == 0) goto L_0x00f9
            se.hendeby.sfapp.LogService$c r1 = new se.hendeby.sfapp.LogService$c
            r1.<init>(r5)
            r0.a(r5, r1)
        L_0x00f9:
            se.hendeby.a.f r0 = new se.hendeby.a.f
            java.lang.String r1 = "Sensor Fusion App Awake"
            r0.<init>(r5, r1)
            r5.h = r0
            android.content.SharedPreferences r0 = r5.g
            java.lang.String r1 = "powersave"
            boolean r0 = r0.getBoolean(r1, r7)
            if (r0 != 0) goto L_0x0111
            se.hendeby.a.f r0 = r5.h
            r0.a()
        L_0x0111:
            r0 = 105(0x69, float:1.47E-43)
            r5.startForeground(r0, r6)
            android.content.Context r6 = r5.getApplicationContext()
            java.lang.String r0 = "Service Started"
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r7)
            r6.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: se.hendeby.sfapp.LogService.a(boolean, boolean):void");
    }

    public boolean a() {
        return this.p;
    }

    public Notification b() {
        System.currentTimeMillis();
        PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, LogActivity.class), 0);
        v.c e2 = Build.VERSION.SDK_INT >= 26 ? e() : new v.c(this, "SFapp");
        e2.a((int) R.drawable.notification_icon).a((CharSequence) "Sensor").b((CharSequence) "Sensor data logging is still active").a(true);
        Notification a2 = e2.a();
        a2.flags |= 32;
        a2.flags |= 64;
        return a2;
    }

    public void c() {
        try {
            this.n = f();
            File parentFile = this.n.getParentFile();
            if ((this.n.exists() || parentFile == null || !parentFile.canWrite()) && !this.n.canWrite()) {
                Toast.makeText(getApplicationContext(), "File creation failed", 1).show();
                stopSelf();
                return;
            }
            this.a = new BufferedWriter(new FileWriter(this.n), 10485760);
            Context applicationContext = getApplicationContext();
            Toast.makeText(applicationContext, "File created:\n" + this.n.getName(), 1).show();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        a(false);
        e eVar = this.m;
        if (eVar != null) {
            eVar.a((Context) this);
        }
        d dVar = this.k;
        if (dVar != null) {
            dVar.a(this);
        }
        d dVar2 = this.i;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        d dVar3 = this.j;
        if (dVar3 != null) {
            dVar3.a(this);
        }
        if (this.l != null && Build.VERSION.SDK_INT >= 21) {
            this.l.a(this);
        }
        g();
        h();
        f fVar = this.h;
        if (fVar != null) {
            fVar.b();
        }
        Toast.makeText(getApplicationContext(), "Service Stopped", 0).show();
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        }
    }

    public IBinder onBind(Intent intent) {
        return new b();
    }

    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "Service Created", 0).show();
        this.g = PreferenceManager.getDefaultSharedPreferences(this);
        this.m = new e(this);
        a(false);
    }

    public void onDestroy() {
        d();
        this.m = null;
        this.k = null;
        this.i = null;
        this.j = null;
        this.l = null;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }
}
