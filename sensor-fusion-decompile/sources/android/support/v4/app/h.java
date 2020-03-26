package android.support.v4.app;

import android.arch.lifecycle.b;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.support.v4.b.i;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.google.android.gms.maps.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class h extends d implements a.C0004a, a.b {
    final Handler c = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    if (h.this.g) {
                        h.this.a(false);
                        return;
                    }
                    return;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    h.this.b();
                    h.this.d.n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final j d = j.a((k<?>) new a());
    boolean e;
    boolean f;
    boolean g = true;
    boolean h = true;
    boolean i;
    boolean j;
    int k;
    i<String> l;

    class a extends k<h> {
        public a() {
            super(h.this);
        }

        public View a(int i) {
            return h.this.findViewById(i);
        }

        public void a(g gVar, Intent intent, int i, Bundle bundle) {
            h.this.a(gVar, intent, i, bundle);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            h.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a() {
            Window window = h.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean a(g gVar) {
            return !h.this.isFinishing();
        }

        public LayoutInflater b() {
            return h.this.getLayoutInflater().cloneInContext(h.this);
        }

        public void b(g gVar) {
            h.this.a(gVar);
        }

        public void c() {
            h.this.d();
        }

        public boolean d() {
            return h.this.getWindow() != null;
        }

        public int e() {
            Window window = h.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    static final class b {
        Object a;
        n b;
        android.support.v4.b.h<String, r> c;

        b() {
        }
    }

    private static void a(l lVar, b.C0001b bVar) {
        for (g next : lVar.c()) {
            if (next != null) {
                next.ad.a(bVar);
                a(next.m(), bVar);
            }
        }
    }

    private int b(g gVar) {
        if (this.l.b() < 65534) {
            while (this.l.f(this.k) >= 0) {
                this.k = (this.k + 1) % 65534;
            }
            int i2 = this.k;
            this.l.b(i2, gVar.o);
            this.k = (this.k + 1) % 65534;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    public android.arch.lifecycle.b a() {
        return super.a();
    }

    /* access modifiers changed from: package-private */
    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    public final void a(int i2) {
        if (!this.j && i2 != -1) {
            b(i2);
        }
    }

    public void a(g gVar) {
    }

    public void a(g gVar, Intent intent, int i2, Bundle bundle) {
        this.b = true;
        if (i2 == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            b(i2);
            a.a(this, intent, ((b(gVar) + 1) << 16) + (i2 & 65535), bundle);
            this.b = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            e();
        } else if (z) {
            this.d.o();
            this.d.c(true);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.d.h();
    }

    public Object c() {
        return null;
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.e);
        printWriter.print("mResumed=");
        printWriter.print(this.f);
        printWriter.print(" mStopped=");
        printWriter.print(this.g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.h);
        this.d.a(str2, fileDescriptor, printWriter, strArr);
        this.d.a().a(str, fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.d.c(this.i);
        this.d.k();
    }

    public l f() {
        return this.d.a();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.d.b();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String a2 = this.l.a(i5);
            this.l.c(i5);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            g a3 = this.d.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i2 & 65535, i3, intent);
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        l a2 = this.d.a();
        boolean d2 = a2.d();
        if (d2 && Build.VERSION.SDK_INT <= 25) {
            return;
        }
        if (d2 || !a2.b()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        n nVar = null;
        this.d.a((g) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.d.a(bVar.c);
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            j jVar = this.d;
            if (bVar != null) {
                nVar = bVar.b;
            }
            jVar.a(parcelable, nVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new i<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.l.b(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new i<>();
            this.k = 0;
        }
        this.d.e();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return i2 == 0 ? super.onCreatePanelMenu(i2, menu) | this.d.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i2, menu);
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.d.l();
        this.d.p();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.d.a(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.d.b(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.d.b(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            b();
        }
        this.d.i();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        b();
        this.d.n();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return (i2 != 0 || menu == null) ? super.onPreparePanel(i2, view, menu) : a(view, menu) | this.d.a(menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a2 = this.l.a(i4);
            this.l.c(i4);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            g a3 = this.d.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i2 & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.n();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.g) {
            a(true);
        }
        Object c2 = c();
        n d2 = this.d.d();
        android.support.v4.b.h<String, r> r = this.d.r();
        if (d2 == null && r == null && c2 == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = c2;
        bVar.b = d2;
        bVar.c = r;
        return bVar;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a(f(), b.C0001b.CREATED);
        Parcelable c2 = this.d.c();
        if (c2 != null) {
            bundle.putParcelable("android:support:fragments", c2);
        }
        if (this.l.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.l.b()];
            String[] strArr = new String[this.l.b()];
            for (int i2 = 0; i2 < this.l.b(); i2++) {
                iArr[i2] = this.l.d(i2);
                strArr[i2] = this.l.e(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.o();
        this.d.g();
        this.d.q();
    }

    public void onStateNotSaved() {
        this.d.b();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.g = true;
        a(f(), b.C0001b.CREATED);
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public void startActivityForResult(Intent intent, int i2) {
        if (!this.b && i2 != -1) {
            b(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
