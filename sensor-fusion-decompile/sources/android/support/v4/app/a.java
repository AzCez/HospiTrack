package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class a extends android.support.v4.a.a {

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public interface C0004a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface b {
        void a(int i);
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof b) {
                ((b) activity).a(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0004a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0004a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
