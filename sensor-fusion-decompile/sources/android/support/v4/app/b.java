package android.support.v4.app;

import android.os.Build;
import android.support.v4.app.g;
import android.support.v4.app.m;
import android.support.v4.b.e;
import android.util.Log;
import com.google.android.gms.maps.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b extends o implements m.f {
    static final boolean a = (Build.VERSION.SDK_INT >= 21);
    final m b;
    ArrayList<a> c = new ArrayList<>();
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k = true;
    String l;
    boolean m;
    int n = -1;
    int o;
    CharSequence p;
    int q;
    CharSequence r;
    ArrayList<String> s;
    ArrayList<String> t;
    boolean u = false;
    ArrayList<Runnable> v;

    static final class a {
        int a;
        g b;
        int c;
        int d;
        int e;
        int f;

        a() {
        }

        a(int i, g gVar) {
            this.a = i;
            this.b = gVar;
        }
    }

    public b(m mVar) {
        this.b = mVar;
    }

    private void a(int i2, g gVar, String str, int i3) {
        Class<?> cls = gVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        gVar.A = this.b;
        if (str != null) {
            if (gVar.H == null || str.equals(gVar.H)) {
                gVar.H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + gVar + ": was " + gVar.H + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + gVar + " with tag " + str + " to container view with no id");
            } else if (gVar.F == 0 || gVar.F == i2) {
                gVar.F = i2;
                gVar.G = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + gVar + ": was " + gVar.F + " now " + i2);
            }
        }
        a(new a(i3, gVar));
    }

    private static boolean b(a aVar) {
        g gVar = aVar.b;
        return gVar != null && gVar.t && gVar.Q != null && !gVar.J && !gVar.I && gVar.W();
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z) {
        if (!this.m) {
            if (m.a) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
                a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.m = true;
            this.n = this.j ? this.b.a(this) : -1;
            this.b.a((m.f) this, z);
            return this.n;
        }
        throw new IllegalStateException("commit already called");
    }

    /* access modifiers changed from: package-private */
    public g a(ArrayList<g> arrayList, g gVar) {
        g gVar2 = gVar;
        int i2 = 0;
        while (i2 < this.c.size()) {
            a aVar = this.c.get(i2);
            switch (aVar.a) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                case f.a.MapAttrs_cameraZoom /*7*/:
                    arrayList.add(aVar.b);
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    g gVar3 = aVar.b;
                    int i3 = gVar3.G;
                    g gVar4 = gVar2;
                    int i4 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        g gVar5 = arrayList.get(size);
                        if (gVar5.G == i3) {
                            if (gVar5 == gVar3) {
                                z = true;
                            } else {
                                if (gVar5 == gVar4) {
                                    this.c.add(i4, new a(9, gVar5));
                                    i4++;
                                    gVar4 = null;
                                }
                                a aVar2 = new a(3, gVar5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.c.add(i4, aVar2);
                                arrayList.remove(gVar5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.c.remove(i4);
                        i4--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(gVar3);
                    }
                    i2 = i4;
                    gVar2 = gVar4;
                    break;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                case f.a.MapAttrs_cameraTilt /*6*/:
                    arrayList.remove(aVar.b);
                    if (aVar.b != gVar2) {
                        break;
                    } else {
                        this.c.add(i2, new a(9, aVar.b));
                        i2++;
                        gVar2 = null;
                        break;
                    }
                case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                    this.c.add(i2, new a(9, gVar2));
                    i2++;
                    gVar2 = aVar.b;
                    break;
            }
            i2++;
        }
        return gVar2;
    }

    public o a(g gVar) {
        a(new a(3, gVar));
        return this;
    }

    public o a(g gVar, String str) {
        a(0, gVar, str, 1);
        return this;
    }

    public void a() {
        ArrayList<Runnable> arrayList = this.v;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.v.get(i2).run();
            }
            this.v = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.j) {
            if (m.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.c.get(i3);
                if (aVar.b != null) {
                    aVar.b.z += i2;
                    if (m.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.z);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.c.add(aVar);
        aVar.c = this.d;
        aVar.d = this.e;
        aVar.e = this.f;
        aVar.f = this.g;
    }

    /* access modifiers changed from: package-private */
    public void a(g.c cVar) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            a aVar = this.c.get(i2);
            if (b(aVar)) {
                aVar.b.a(cVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.n);
            printWriter.print(" mCommitted=");
            printWriter.println(this.m);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (!(this.d == 0 && this.e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.p);
            }
            if (!(this.q == 0 && this.r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.r);
            }
        }
        if (!this.c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.c.get(i2);
                switch (aVar.a) {
                    case f.a.MapAttrs_ambientEnabled /*0*/:
                        str2 = "NULL";
                        break;
                    case f.a.MapAttrs_cameraBearing /*1*/:
                        str2 = "ADD";
                        break;
                    case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                        str2 = "REPLACE";
                        break;
                    case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                        str2 = "REMOVE";
                        break;
                    case f.a.MapAttrs_cameraTargetLat /*4*/:
                        str2 = "HIDE";
                        break;
                    case f.a.MapAttrs_cameraTargetLng /*5*/:
                        str2 = "SHOW";
                        break;
                    case f.a.MapAttrs_cameraTilt /*6*/:
                        str2 = "DETACH";
                        break;
                    case f.a.MapAttrs_cameraZoom /*7*/:
                        str2 = "ATTACH";
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<b> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.c.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = this.c.get(i5);
            int i6 = aVar.b != null ? aVar.b.G : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    b bVar = arrayList.get(i7);
                    int size2 = bVar.c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        a aVar2 = bVar.c.get(i8);
                        if ((aVar2.b != null ? aVar2.b.G : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.j) {
            return true;
        }
        this.b.b(this);
        return true;
    }

    public int b() {
        return a(false);
    }

    /* access modifiers changed from: package-private */
    public g b(ArrayList<g> arrayList, g gVar) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            a aVar = this.c.get(i2);
            int i3 = aVar.a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case f.a.MapAttrs_cameraTilt /*6*/:
                            break;
                        case f.a.MapAttrs_cameraZoom /*7*/:
                            break;
                        case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                            gVar = null;
                            break;
                        case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                            gVar = aVar.b;
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            a aVar = this.c.get(size);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(m.d(this.h), this.i);
            }
            int i2 = aVar.a;
            if (i2 != 1) {
                switch (i2) {
                    case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                        gVar.a(aVar.e);
                        this.b.a(gVar, false);
                        break;
                    case f.a.MapAttrs_cameraTargetLat /*4*/:
                        gVar.a(aVar.e);
                        this.b.j(gVar);
                        break;
                    case f.a.MapAttrs_cameraTargetLng /*5*/:
                        gVar.a(aVar.f);
                        this.b.i(gVar);
                        break;
                    case f.a.MapAttrs_cameraTilt /*6*/:
                        gVar.a(aVar.e);
                        this.b.l(gVar);
                        break;
                    case f.a.MapAttrs_cameraZoom /*7*/:
                        gVar.a(aVar.f);
                        this.b.k(gVar);
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                        this.b.o((g) null);
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                        this.b.o(gVar);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.f);
                this.b.h(gVar);
            }
            if (!(this.u || aVar.a == 3 || gVar == null)) {
                this.b.e(gVar);
            }
        }
        if (!this.u && z) {
            m mVar = this.b;
            mVar.a(mVar.l, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.c.get(i3);
            int i4 = aVar.b != null ? aVar.b.G : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public int c() {
        return a(true);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.c.get(i2);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(this.h, this.i);
            }
            int i3 = aVar.a;
            if (i3 != 1) {
                switch (i3) {
                    case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                        gVar.a(aVar.d);
                        this.b.h(gVar);
                        break;
                    case f.a.MapAttrs_cameraTargetLat /*4*/:
                        gVar.a(aVar.d);
                        this.b.i(gVar);
                        break;
                    case f.a.MapAttrs_cameraTargetLng /*5*/:
                        gVar.a(aVar.c);
                        this.b.j(gVar);
                        break;
                    case f.a.MapAttrs_cameraTilt /*6*/:
                        gVar.a(aVar.d);
                        this.b.k(gVar);
                        break;
                    case f.a.MapAttrs_cameraZoom /*7*/:
                        gVar.a(aVar.c);
                        this.b.l(gVar);
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                        this.b.o(gVar);
                        break;
                    case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                        this.b.o((g) null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.c);
                this.b.a(gVar, false);
            }
            if (!(this.u || aVar.a == 1 || gVar == null)) {
                this.b.e(gVar);
            }
        }
        if (!this.u) {
            m mVar = this.b;
            mVar.a(mVar.l, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (b(this.c.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.n >= 0) {
            sb.append(" #");
            sb.append(this.n);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append("}");
        return sb.toString();
    }
}
