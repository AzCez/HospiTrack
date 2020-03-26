package android.support.v4.a;

import android.support.v4.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b<D> {
    int a;
    C0003b<D> b;
    a<D> c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public interface a<D> {
    }

    /* renamed from: android.support.v4.a.b$b  reason: collision with other inner class name */
    public interface C0003b<D> {
    }

    public String a(D d2) {
        StringBuilder sb = new StringBuilder(64);
        d.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public final void a() {
        this.d = true;
        this.f = false;
        this.e = false;
        b();
    }

    public void a(int i, C0003b<D> bVar) {
        if (this.b == null) {
            this.b = bVar;
            this.a = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void a(a<D> aVar) {
        if (this.c == null) {
            this.c = aVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void a(C0003b<D> bVar) {
        C0003b<D> bVar2 = this.b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.d || this.g || this.h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void b(a<D> aVar) {
        a<D> aVar2 = this.c;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (aVar2 == aVar) {
            this.c = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void c() {
        this.d = false;
        d();
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    public void e() {
        f();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        d.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
