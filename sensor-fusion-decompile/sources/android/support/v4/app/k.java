package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.b.h;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class k<E> extends i {
    private final Activity a;
    final Context b;
    final int c;
    final m d;
    private final Handler e;
    private h<String, r> f;
    private boolean g;
    private s h;
    private boolean i;
    private boolean j;

    k(Activity activity, Context context, Handler handler, int i2) {
        this.d = new m();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i2;
    }

    k(h hVar) {
        this(hVar, hVar, hVar.c, 0);
    }

    /* access modifiers changed from: package-private */
    public s a(String str, boolean z, boolean z2) {
        if (this.f == null) {
            this.f = new h<>();
        }
        s sVar = (s) this.f.get(str);
        if (sVar == null && z2) {
            s sVar2 = new s(str, this, z);
            this.f.put(str, sVar2);
            return sVar2;
        } else if (!z || sVar == null || sVar.e) {
            return sVar;
        } else {
            sVar.b();
            return sVar;
        }
    }

    public View a(int i2) {
        return null;
    }

    public void a(g gVar, Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            this.b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    /* access modifiers changed from: package-private */
    public void a(h<String, r> hVar) {
        if (hVar != null) {
            int size = hVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((s) hVar.c(i2)).a(this);
            }
        }
        this.f = hVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        s sVar;
        h<String, r> hVar = this.f;
        if (hVar != null && (sVar = (s) hVar.get(str)) != null && !sVar.f) {
            sVar.h();
            this.f.remove(str);
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
        s sVar = this.h;
        if (sVar != null && this.j) {
            this.j = false;
            if (z) {
                sVar.d();
            } else {
                sVar.c();
            }
        }
    }

    public boolean a() {
        return true;
    }

    public boolean a(g gVar) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) {
    }

    /* access modifiers changed from: package-private */
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            s sVar = this.h;
            sVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public Activity f() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public Context g() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public Handler h() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public m i() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (!this.j) {
            this.j = true;
            s sVar = this.h;
            if (sVar == null) {
                if (!this.i) {
                    this.h = a("(root)", this.j, false);
                    s sVar2 = this.h;
                    if (sVar2 != null && !sVar2.e) {
                        sVar = this.h;
                    }
                }
                this.i = true;
            }
            sVar.b();
            this.i = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        s sVar = this.h;
        if (sVar != null) {
            sVar.h();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        h<String, r> hVar = this.f;
        if (hVar != null) {
            int size = hVar.size();
            s[] sVarArr = new s[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                sVarArr[i2] = (s) this.f.c(i2);
            }
            for (int i3 = 0; i3 < size; i3++) {
                s sVar = sVarArr[i3];
                sVar.e();
                sVar.g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public h<String, r> n() {
        h<String, r> hVar = this.f;
        int i2 = 0;
        if (hVar != null) {
            int size = hVar.size();
            s[] sVarArr = new s[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                sVarArr[i3] = (s) this.f.c(i3);
            }
            boolean j2 = j();
            int i4 = 0;
            while (i2 < size) {
                s sVar = sVarArr[i2];
                if (!sVar.f && j2) {
                    if (!sVar.e) {
                        sVar.b();
                    }
                    sVar.d();
                }
                if (sVar.f) {
                    i4 = 1;
                } else {
                    sVar.h();
                    this.f.remove(sVar.d);
                }
                i2++;
            }
            i2 = i4;
        }
        if (i2 != 0) {
            return this.f;
        }
        return null;
    }
}
