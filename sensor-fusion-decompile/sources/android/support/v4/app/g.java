package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.d;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.h;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class g implements android.arch.lifecycle.c, ComponentCallbacks, View.OnCreateContextMenuListener {
    private static final h<String, Class<?>> a = new h<>();
    static final Object j = new Object();
    m A;
    k B;
    m C;
    n D;
    g E;
    int F;
    int G;
    String H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N = true;
    boolean O;
    ViewGroup P;
    View Q;
    View R;
    boolean S;
    boolean T = true;
    s U;
    boolean V;
    boolean W;
    a X;
    boolean Y;
    boolean Z;
    float aa;
    LayoutInflater ab;
    boolean ac;
    d ad = new d(this);
    int k = 0;
    Bundle l;
    SparseArray<Parcelable> m;
    int n = -1;
    String o;
    Bundle p;
    g q;
    int r = -1;
    int s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    int z;

    static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        ai g = null;
        ai h = null;
        boolean i;
        c j;
        boolean k;
        /* access modifiers changed from: private */
        public Object l = null;
        /* access modifiers changed from: private */
        public Object m = g.j;
        /* access modifiers changed from: private */
        public Object n = null;
        /* access modifiers changed from: private */
        public Object o = g.j;
        /* access modifiers changed from: private */
        public Object p = null;
        /* access modifiers changed from: private */
        public Object q = g.j;
        /* access modifiers changed from: private */
        public Boolean r;
        /* access modifiers changed from: private */
        public Boolean s;

        a() {
        }
    }

    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface c {
        void a();

        void b();
    }

    private a Y() {
        if (this.X == null) {
            this.X = new a();
        }
        return this.X;
    }

    public static g a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            g gVar = (g) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(gVar.getClass().getClassLoader());
                gVar.g(bundle);
            }
            return gVar;
        } catch (ClassNotFoundException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    static boolean a(Context context, String str) {
        try {
            Class<?> cls = a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            return g.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        c cVar;
        a aVar = this.X;
        if (aVar == null) {
            cVar = null;
        } else {
            aVar.i = false;
            cVar = aVar.j;
            this.X.j = null;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean A() {
        a aVar = this.X;
        if (aVar == null || aVar.s == null) {
            return true;
        }
        return this.X.s.booleanValue();
    }

    public boolean B() {
        a aVar = this.X;
        if (aVar == null || aVar.r == null) {
            return true;
        }
        return this.X.r.booleanValue();
    }

    public void C() {
        m mVar = this.A;
        if (mVar == null || mVar.m == null) {
            Y().i = false;
        } else if (Looper.myLooper() != this.A.m.h().getLooper()) {
            this.A.m.h().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    g.this.b();
                }
            });
        } else {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        if (this.B != null) {
            this.C = new m();
            this.C.a(this.B, (i) new i() {
                public g a(Context context, String str, Bundle bundle) {
                    return g.this.B.a(context, str, bundle);
                }

                public View a(int i) {
                    if (g.this.Q != null) {
                        return g.this.Q.findViewById(i);
                    }
                    throw new IllegalStateException("Fragment does not have a view");
                }

                public boolean a() {
                    return g.this.Q != null;
                }
            }, this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    /* access modifiers changed from: package-private */
    public void E() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
            this.C.f();
        }
        this.k = 4;
        this.O = false;
        d();
        if (this.O) {
            m mVar2 = this.C;
            if (mVar2 != null) {
                mVar2.o();
            }
            s sVar = this.U;
            if (sVar != null) {
                sVar.g();
            }
            this.ad.a(b.a.ON_START);
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void F() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
            this.C.f();
        }
        this.k = 5;
        this.O = false;
        p();
        if (this.O) {
            m mVar2 = this.C;
            if (mVar2 != null) {
                mVar2.p();
                this.C.f();
            }
            this.ad.a(b.a.ON_RESUME);
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void G() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
        }
    }

    /* access modifiers changed from: package-private */
    public void H() {
        onLowMemory();
        m mVar = this.C;
        if (mVar != null) {
            mVar.v();
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        this.ad.a(b.a.ON_PAUSE);
        m mVar = this.C;
        if (mVar != null) {
            mVar.q();
        }
        this.k = 4;
        this.O = false;
        q();
        if (!this.O) {
            throw new aj("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void J() {
        this.ad.a(b.a.ON_STOP);
        m mVar = this.C;
        if (mVar != null) {
            mVar.r();
        }
        this.k = 3;
        this.O = false;
        e();
        if (!this.O) {
            throw new aj("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.s();
        }
        this.k = 2;
        if (this.V) {
            this.V = false;
            if (!this.W) {
                this.W = true;
                this.U = this.B.a(this.o, this.V, false);
            }
            if (this.U == null) {
                return;
            }
            if (this.B.j()) {
                this.U.d();
            } else {
                this.U.c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void L() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.t();
        }
        this.k = 1;
        this.O = false;
        f();
        if (this.O) {
            s sVar = this.U;
            if (sVar != null) {
                sVar.f();
            }
            this.y = false;
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void M() {
        this.ad.a(b.a.ON_DESTROY);
        m mVar = this.C;
        if (mVar != null) {
            mVar.u();
        }
        this.k = 0;
        this.O = false;
        this.ac = false;
        r();
        if (this.O) {
            this.C = null;
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* access modifiers changed from: package-private */
    public void N() {
        this.O = false;
        c();
        this.ab = null;
        if (this.O) {
            m mVar = this.C;
            if (mVar == null) {
                return;
            }
            if (this.L) {
                mVar.u();
                this.C = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
        throw new aj("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* access modifiers changed from: package-private */
    public int O() {
        a aVar = this.X;
        if (aVar == null) {
            return 0;
        }
        return aVar.d;
    }

    /* access modifiers changed from: package-private */
    public int P() {
        a aVar = this.X;
        if (aVar == null) {
            return 0;
        }
        return aVar.e;
    }

    /* access modifiers changed from: package-private */
    public int Q() {
        a aVar = this.X;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    /* access modifiers changed from: package-private */
    public ai R() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.g;
    }

    /* access modifiers changed from: package-private */
    public ai S() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.h;
    }

    /* access modifiers changed from: package-private */
    public View T() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    /* access modifiers changed from: package-private */
    public Animator U() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.b;
    }

    /* access modifiers changed from: package-private */
    public int V() {
        a aVar = this.X;
        if (aVar == null) {
            return 0;
        }
        return aVar.c;
    }

    /* access modifiers changed from: package-private */
    public boolean W() {
        a aVar = this.X;
        if (aVar == null) {
            return false;
        }
        return aVar.i;
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        a aVar = this.X;
        if (aVar == null) {
            return false;
        }
        return aVar.k;
    }

    public android.arch.lifecycle.b a() {
        return this.ad;
    }

    /* access modifiers changed from: package-private */
    public g a(String str) {
        if (str.equals(this.o)) {
            return this;
        }
        m mVar = this.C;
        if (mVar != null) {
            return mVar.b(str);
        }
        return null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z2, int i2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (this.X != null || i != 0) {
            Y().d = i;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.X != null || i != 0 || i2 != 0) {
            Y();
            a aVar = this.X;
            aVar.e = i;
            aVar.f = i2;
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, g gVar) {
        String str;
        StringBuilder sb;
        this.n = i;
        if (gVar != null) {
            sb = new StringBuilder();
            sb.append(gVar.o);
            str = ":";
        } else {
            sb = new StringBuilder();
            str = "android:fragment:";
        }
        sb.append(str);
        sb.append(this.n);
        this.o = sb.toString();
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    public void a(Animator animator) {
        Y().b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.O = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.O = true;
    }

    public void a(Context context) {
        this.O = true;
        k kVar = this.B;
        Activity f = kVar == null ? null : kVar.f();
        if (f != null) {
            this.O = false;
            a(f);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.O = true;
        k kVar = this.B;
        Activity f = kVar == null ? null : kVar.f();
        if (f != null) {
            this.O = false;
            a(f, attributeSet, bundle);
        }
    }

    public void a(Intent intent, int i) {
        a(intent, i, (Bundle) null);
    }

    public void a(Intent intent, int i, Bundle bundle) {
        k kVar = this.B;
        if (kVar != null) {
            kVar.a(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        m mVar = this.C;
        if (mVar != null) {
            mVar.a(configuration);
        }
    }

    public void a(Bundle bundle) {
        this.O = true;
        j(bundle);
        m mVar = this.C;
        if (mVar != null && !mVar.b(1)) {
            this.C.m();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        Y();
        if (cVar != this.X.j) {
            if (cVar == null || this.X.j == null) {
                if (this.X.i) {
                    this.X.j = cVar;
                }
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void a(g gVar) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        Y().a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mTag=");
        printWriter.println(this.H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.n);
        printWriter.print(" mWho=");
        printWriter.print(this.o);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.t);
        printWriter.print(" mRemoving=");
        printWriter.print(this.u);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.v);
        printWriter.print(" mInLayout=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.I);
        printWriter.print(" mDetached=");
        printWriter.print(this.J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.T);
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.A);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.B);
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.E);
        }
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.p);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.l);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.m);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.q);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.s);
        }
        if (O() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(O());
        }
        if (this.P != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.P);
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.Q);
        }
        if (T() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(T());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(V());
        }
        if (this.U != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            s sVar = this.U;
            sVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.C + ":");
            m mVar = this.C;
            mVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z2, int i2) {
        return null;
    }

    public LayoutInflater b(Bundle bundle) {
        return i(bundle);
    }

    /* access modifiers changed from: package-private */
    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
        }
        this.y = true;
        return a(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        Y().c = i;
    }

    public void b(Menu menu) {
    }

    /* access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.I) {
            return false;
        }
        if (this.M && this.N) {
            a(menu, menuInflater);
            z2 = true;
        }
        m mVar = this.C;
        return mVar != null ? z2 | mVar.a(menu, menuInflater) : z2;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c() {
        this.O = true;
    }

    public void c(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public boolean c(Menu menu) {
        boolean z2 = false;
        if (this.I) {
            return false;
        }
        if (this.M && this.N) {
            a(menu);
            z2 = true;
        }
        m mVar = this.C;
        return mVar != null ? z2 | mVar.a(menu) : z2;
    }

    /* access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.I) {
            return false;
        }
        if (this.M && this.N && a(menuItem)) {
            return true;
        }
        m mVar = this.C;
        return mVar != null && mVar.a(menuItem);
    }

    public void d() {
        this.O = true;
        if (!this.V) {
            this.V = true;
            if (!this.W) {
                this.W = true;
                this.U = this.B.a(this.o, this.V, false);
                return;
            }
            s sVar = this.U;
            if (sVar != null) {
                sVar.b();
            }
        }
    }

    public void d(Bundle bundle) {
        this.O = true;
    }

    /* access modifiers changed from: package-private */
    public void d(Menu menu) {
        if (!this.I) {
            if (this.M && this.N) {
                b(menu);
            }
            m mVar = this.C;
            if (mVar != null) {
                mVar.b(menu);
            }
        }
    }

    public void d(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.I) {
            return false;
        }
        if (b(menuItem)) {
            return true;
        }
        m mVar = this.C;
        return mVar != null && mVar.b(menuItem);
    }

    public void e() {
        this.O = true;
    }

    public void e(Bundle bundle) {
    }

    public void e(boolean z2) {
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f() {
        this.O = true;
    }

    /* access modifiers changed from: package-private */
    public final void f(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.m;
        if (sparseArray != null) {
            this.R.restoreHierarchyState(sparseArray);
            this.m = null;
        }
        this.O = false;
        k(bundle);
        if (!this.O) {
            throw new aj("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        d(z2);
        m mVar = this.C;
        if (mVar != null) {
            mVar.a(z2);
        }
    }

    public void g(Bundle bundle) {
        if (this.n < 0 || !i()) {
            this.p = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z2) {
        e(z2);
        m mVar = this.C;
        if (mVar != null) {
            mVar.b(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.z > 0;
    }

    public final Bundle h() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater h(Bundle bundle) {
        this.ab = b(bundle);
        return this.ab;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z2) {
        Y().k = z2;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Deprecated
    public LayoutInflater i(Bundle bundle) {
        k kVar = this.B;
        if (kVar != null) {
            LayoutInflater b2 = kVar.b();
            m();
            android.support.v4.c.a.b(b2, this.C.x());
            return b2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final boolean i() {
        m mVar = this.A;
        if (mVar == null) {
            return false;
        }
        return mVar.d();
    }

    public final h j() {
        k kVar = this.B;
        if (kVar == null) {
            return null;
        }
        return (h) kVar.f();
    }

    /* access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.C == null) {
                D();
            }
            this.C.a(parcelable, this.D);
            this.D = null;
            this.C.m();
        }
    }

    public final Resources k() {
        k kVar = this.B;
        if (kVar != null) {
            return kVar.g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void k(Bundle bundle) {
        this.O = true;
    }

    public final l l() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public void l(Bundle bundle) {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
        }
        this.k = 1;
        this.O = false;
        a(bundle);
        this.ac = true;
        if (this.O) {
            this.ad.a(b.a.ON_CREATE);
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onCreate()");
    }

    public final l m() {
        if (this.C == null) {
            D();
            int i = this.k;
            if (i >= 5) {
                this.C.p();
            } else if (i >= 4) {
                this.C.o();
            } else if (i >= 2) {
                this.C.n();
            } else if (i >= 1) {
                this.C.m();
            }
        }
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public void m(Bundle bundle) {
        m mVar = this.C;
        if (mVar != null) {
            mVar.l();
        }
        this.k = 2;
        this.O = false;
        d(bundle);
        if (this.O) {
            m mVar2 = this.C;
            if (mVar2 != null) {
                mVar2.n();
                return;
            }
            return;
        }
        throw new aj("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public l n() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public void n(Bundle bundle) {
        Parcelable k2;
        e(bundle);
        m mVar = this.C;
        if (mVar != null && (k2 = mVar.k()) != null) {
            bundle.putParcelable("android:support:fragments", k2);
        }
    }

    public View o() {
        return this.Q;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.O = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        j().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.O = true;
    }

    public void p() {
        this.O = true;
    }

    public void q() {
        this.O = true;
    }

    public void r() {
        this.O = true;
        if (!this.W) {
            this.W = true;
            this.U = this.B.a(this.o, this.V, false);
        }
        s sVar = this.U;
        if (sVar != null) {
            sVar.h();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.n = -1;
        this.o = null;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.z = 0;
        this.A = null;
        this.C = null;
        this.B = null;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = false;
        this.J = false;
        this.L = false;
        this.U = null;
        this.V = false;
        this.W = false;
    }

    public void t() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        android.support.v4.b.d.a(this, sb);
        if (this.n >= 0) {
            sb.append(" #");
            sb.append(this.n);
        }
        if (this.F != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.F));
        }
        if (this.H != null) {
            sb.append(" ");
            sb.append(this.H);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.l;
    }

    public Object v() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.m == j ? u() : this.X.m;
    }

    public Object w() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.n;
    }

    public Object x() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.o == j ? w() : this.X.o;
    }

    public Object y() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    public Object z() {
        a aVar = this.X;
        if (aVar == null) {
            return null;
        }
        return aVar.q == j ? y() : this.X.q;
    }
}
