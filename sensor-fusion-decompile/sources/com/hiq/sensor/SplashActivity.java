package com.hiq.sensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SplashActivity extends Activity {
    private a a;

    private static class a extends Handler {
        private final WeakReference<Activity> a;
        private int b = 1;

        a(Activity activity) {
            this.a = new WeakReference<>(activity);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.b++;
        }

        public void handleMessage(Message message) {
            Activity activity = (Activity) this.a.get();
            if (activity != null) {
                super.handleMessage(message);
                this.b--;
                if (this.b == 0) {
                    Intent intent = new Intent();
                    intent.setClass(activity, MainMenu.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.a = new a(this);
        setContentView(R.layout.activity_splash);
        Message message = new Message();
        message.what = 0;
        this.a.sendMessageDelayed(message, 3000);
        ArrayList arrayList = new ArrayList();
        if (android.support.v4.app.a.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (android.support.v4.app.a.a(this, "android.permission.BLUETOOTH") != 0) {
            arrayList.add("android.permission.BLUETOOTH");
        }
        if (android.support.v4.app.a.a(this, "android.permission.BLUETOOTH_ADMIN") != 0) {
            arrayList.add("android.permission.BLUETOOTH_ADMIN");
        }
        if (android.support.v4.app.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (android.support.v4.app.a.a(this, "android.permission.WAKE_LOCK") != 0) {
            arrayList.add("android.permission.WAKE_LOCK");
        }
        int size = arrayList.size();
        if (size > 0) {
            this.a.a();
            android.support.v4.app.a.a(this, (String[]) arrayList.toArray(new String[size]), 1300);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.a.sendMessage(new Message());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        b a2 = b.a();
        int a3 = a2.a(getApplicationContext());
        if (a2.a(a3)) {
            this.a.a();
            a2.a((Activity) this, a3, 1301).show();
        }
    }
}
