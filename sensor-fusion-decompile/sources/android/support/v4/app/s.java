package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.b;
import android.support.v4.app.r;
import android.support.v4.b.d;
import android.support.v4.b.i;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class s extends r {
    static boolean a = false;
    final i<a> b = new i<>();
    final i<a> c = new i<>();
    final String d;
    boolean e;
    boolean f;
    k g;

    final class a implements b.a<Object>, b.C0003b<Object> {
        final int a;
        final Bundle b;
        r.a<Object> c;
        b<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ s o;

        /* access modifiers changed from: package-private */
        public void a() {
            r.a<Object> aVar;
            if (this.i && this.j) {
                this.h = true;
            } else if (!this.h) {
                this.h = true;
                if (s.a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.d == null && (aVar = this.c) != null) {
                    this.d = aVar.a(this.a, this.b);
                }
                b<Object> bVar = this.d;
                if (bVar == null) {
                    return;
                }
                if (!bVar.getClass().isMemberClass() || Modifier.isStatic(this.d.getClass().getModifiers())) {
                    if (!this.m) {
                        this.d.a(this.a, this);
                        this.d.a(this);
                        this.m = true;
                    }
                    this.d.a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(b<Object> bVar, Object obj) {
            if (this.c != null) {
                String str = null;
                if (this.o.g != null) {
                    str = this.o.g.d.u;
                    this.o.g.d.u = "onLoadFinished";
                }
                try {
                    if (s.a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.a(obj));
                    }
                    this.c.a(bVar, obj);
                    this.f = true;
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.u = str;
                    }
                }
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            b<Object> bVar = this.d;
            if (bVar != null) {
                bVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                a aVar = this.n;
                aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (s.a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.i) {
                if (s.a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                boolean z = this.h;
                if (z != this.j && !z) {
                    e();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e && !this.i) {
                    a(this.d, this.g);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            b<Object> bVar;
            if (s.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (!this.i && (bVar = this.d) != null && this.m) {
                this.m = false;
                bVar.a((b.C0003b<Object>) this);
                this.d.b(this);
                this.d.c();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            String str;
            if (s.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z) {
                if (s.a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.o.g != null) {
                    str = this.o.g.d.u;
                    this.o.g.d.u = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.u = str;
                    }
                }
            }
            this.c = null;
            this.g = null;
            this.e = false;
            b<Object> bVar = this.d;
            if (bVar != null) {
                if (this.m) {
                    this.m = false;
                    bVar.a((b.C0003b<Object>) this);
                    this.d.b(this);
                }
                this.d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.f();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.a);
            sb.append(" : ");
            d.a(this.d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    s(String str, k kVar, boolean z) {
        this.d = str;
        this.g = kVar;
        this.e = z;
    }

    /* access modifiers changed from: package-private */
    public void a(k kVar) {
        this.g = kVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.b.b(); i++) {
                a e2 = this.b.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i));
                printWriter.print(": ");
                printWriter.println(e2.toString());
                e2.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.c.b(); i2++) {
                a e3 = this.c.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i2));
                printWriter.print(": ");
                printWriter.println(e3.toString());
                e3.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public boolean a() {
        int b2 = this.b.b();
        boolean z = false;
        for (int i = 0; i < b2; i++) {
            a e2 = this.b.e(i);
            z |= e2.h && !e2.f;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.e = true;
        for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
            this.b.e(b2).a();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
            this.b.e(b2).e();
        }
        this.e = false;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f = true;
        this.e = false;
        for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
            this.b.e(b2).b();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f = false;
            for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
                this.b.e(b2).c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
            this.b.e(b2).k = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
            this.b.e(b2).d();
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (!this.f) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int b2 = this.b.b() - 1; b2 >= 0; b2--) {
                this.b.e(b2).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int b3 = this.c.b() - 1; b3 >= 0; b3--) {
            this.c.e(b3).f();
        }
        this.c.c();
        this.g = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a(this.g, sb);
        sb.append("}}");
        return sb.toString();
    }
}
