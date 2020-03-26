package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.g;
import android.support.v4.app.l;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.maps.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class m extends l implements LayoutInflater.Factory2 {
    static final Interpolator E = new DecelerateInterpolator(2.5f);
    static final Interpolator F = new DecelerateInterpolator(1.5f);
    static final Interpolator G = new AccelerateInterpolator(2.5f);
    static final Interpolator H = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    SparseArray<Parcelable> A = null;
    ArrayList<h> B;
    n C;
    Runnable D = new Runnable() {
        public void run() {
            m.this.f();
        }
    };
    private final CopyOnWriteArrayList<android.support.v4.b.g<l.a, Boolean>> I = new CopyOnWriteArrayList<>();
    ArrayList<f> b;
    boolean c;
    int d = 0;
    final ArrayList<g> e = new ArrayList<>();
    SparseArray<g> f;
    ArrayList<b> g;
    ArrayList<g> h;
    ArrayList<b> i;
    ArrayList<Integer> j;
    ArrayList<l.b> k;
    int l = 0;
    k m;
    i n;
    g o;
    g p;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    ArrayList<b> w;
    ArrayList<Boolean> x;
    ArrayList<g> y;
    Bundle z = null;

    private static class a extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (android.support.v4.c.c.c(this.a) || Build.VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() {
                    public void run() {
                        a.this.a.setLayerType(0, (Paint) null);
                    }
                });
            } else {
                this.a.setLayerType(0, (Paint) null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        private b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    private static class c {
        public final Animation a;
        public final Animator b;

        private c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, (Paint) null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, (Paint) null);
        }
    }

    static class e {
        public static final int[] a = {16842755, 16842960, 16842961};
    }

    interface f {
        boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class g implements f {
        final String a;
        final int b;
        final int c;

        g(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
            l n;
            if (m.this.p != null && this.b < 0 && this.a == null && (n = m.this.p.n()) != null && n.b()) {
                return false;
            }
            return m.this.a(arrayList, arrayList2, this.a, this.b, this.c);
        }
    }

    static class h implements g.c {
        /* access modifiers changed from: private */
        public final boolean a;
        /* access modifiers changed from: private */
        public final b b;
        private int c;

        h(b bVar, boolean z) {
            this.a = z;
            this.b = bVar;
        }

        public void a() {
            this.c--;
            if (this.c == 0) {
                this.b.b.z();
            }
        }

        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            m mVar = this.b.b;
            int size = mVar.e.size();
            for (int i = 0; i < size; i++) {
                g gVar = mVar.e.get(i);
                gVar.a((g.c) null);
                if (z && gVar.W()) {
                    gVar.C();
                }
            }
            this.b.b.a(this.b, this.a, !z, true);
        }

        public void e() {
            this.b.b.a(this.b, this.a, false, false);
        }
    }

    m() {
    }

    private void A() {
        this.c = false;
        this.x.clear();
        this.w.clear();
    }

    private void B() {
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                this.B.remove(0).d();
            }
        }
    }

    private void C() {
        SparseArray<g> sparseArray = this.f;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            g valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.T() != null) {
                    int V = valueAt.V();
                    View T = valueAt.T();
                    valueAt.a((View) null);
                    Animation animation = T.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        T.clearAnimation();
                    }
                    a(valueAt, V, 0, 0, false);
                } else if (valueAt.U() != null) {
                    valueAt.U().end();
                }
            }
        }
    }

    private void D() {
        SparseArray<g> sparseArray = this.f;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    SparseArray<g> sparseArray2 = this.f;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, android.support.v4.b.b<g> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            b bVar2 = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (bVar2.e() && !bVar2.a(arrayList, i5 + 1, i3)) {
                if (this.B == null) {
                    this.B = new ArrayList<>();
                }
                h hVar = new h(bVar2, booleanValue);
                this.B.add(hVar);
                bVar2.a((g.c) hVar);
                if (booleanValue) {
                    bVar2.d();
                } else {
                    bVar2.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, bVar2);
                }
                b(bVar);
            }
        }
        return i4;
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220);
        return new c((Animation) alphaAnimation);
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c((Animation) animationSet);
    }

    private static Animation.AnimationListener a(Animation animation) {
        String str;
        String str2;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (NoSuchFieldException e2) {
            e = e2;
            str2 = "FragmentManager";
            str = "No field with the name mListener is found in Animation class";
            Log.e(str2, str, e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            str2 = "FragmentManager";
            str = "Cannot access Animation's mListener field";
            Log.e(str2, str, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            bVar.b(z4);
        } else {
            bVar.d();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(bVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            p.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.l, true);
        }
        SparseArray<g> sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null && valueAt.Q != null && valueAt.Y && bVar.b(valueAt.G)) {
                    if (valueAt.aa > 0.0f) {
                        valueAt.Q.setAlpha(valueAt.aa);
                    }
                    if (z4) {
                        valueAt.aa = 0.0f;
                    } else {
                        valueAt.aa = -1.0f;
                        valueAt.Y = false;
                    }
                }
            }
        }
    }

    private void a(final g gVar, c cVar, int i2) {
        final View view = gVar.Q;
        gVar.b(i2);
        if (cVar.a != null) {
            Animation animation = cVar.a;
            gVar.a(gVar.Q);
            animation.setAnimationListener(new b(a(animation)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (gVar.T() != null) {
                        gVar.a((View) null);
                        m mVar = m.this;
                        g gVar = gVar;
                        mVar.a(gVar, gVar.V(), 0, 0, false);
                    }
                }
            });
            b(view, cVar);
            gVar.Q.startAnimation(animation);
            return;
        }
        Animator animator = cVar.b;
        gVar.a(cVar.b);
        final ViewGroup viewGroup = gVar.P;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup = viewGroup;
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (gVar.U() != null) {
                    gVar.a((Animator) null);
                    m mVar = m.this;
                    g gVar = gVar;
                    mVar.a(gVar, gVar.V(), 0, 0, false);
                }
            }
        });
        animator.setTarget(gVar.Q);
        b(gVar.Q, cVar);
        animator.start();
    }

    private static void a(n nVar) {
        if (nVar != null) {
            List<g> a2 = nVar.a();
            if (a2 != null) {
                for (g gVar : a2) {
                    gVar.L = true;
                }
            }
            List<n> b2 = nVar.b();
            if (b2 != null) {
                for (n a3 : b2) {
                    a(a3);
                }
            }
        }
    }

    private void a(android.support.v4.b.b<g> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            g b2 = bVar.b(i2);
            if (!b2.t) {
                View o2 = b2.o();
                b2.aa = o2.getAlpha();
                o2.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
        k kVar = this.m;
        if (kVar != null) {
            try {
                kVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    private void a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<h> arrayList3 = this.B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            h hVar = this.B.get(i2);
            if (arrayList == null || hVar.a || (indexOf2 = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (hVar.c() || (arrayList != null && hVar.b.a(arrayList, 0, arrayList.size()))) {
                    this.B.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || hVar.a || (indexOf = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        hVar.d();
                    }
                }
                i2++;
            }
            hVar.e();
            i2++;
        }
    }

    private void a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        ArrayList<b> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = arrayList3.get(i5).u;
        ArrayList<g> arrayList5 = this.y;
        if (arrayList5 == null) {
            this.y = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.y.addAll(this.e);
        g w2 = w();
        boolean z3 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            b bVar = arrayList3.get(i7);
            w2 = !arrayList4.get(i7).booleanValue() ? bVar.a(this.y, w2) : bVar.b(this.y, w2);
            z3 = z3 || bVar.j;
        }
        this.y.clear();
        if (!z2) {
            p.a(this, arrayList, arrayList2, i2, i3, false);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z2) {
            android.support.v4.b.b bVar2 = new android.support.v4.b.b();
            b((android.support.v4.b.b<g>) bVar2);
            int a2 = a(arrayList, arrayList2, i2, i3, (android.support.v4.b.b<g>) bVar2);
            a((android.support.v4.b.b<g>) bVar2);
            i4 = a2;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z2) {
            p.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.l, true);
        }
        while (i5 < i6) {
            b bVar3 = arrayList3.get(i5);
            if (arrayList4.get(i5).booleanValue() && bVar3.n >= 0) {
                c(bVar3.n);
                bVar3.n = -1;
            }
            bVar3.a();
            i5++;
        }
        if (z3) {
            h();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.a instanceof AnimationSet)) {
            return a(cVar.b);
        }
        List<Animation> animations = ((AnimationSet) cVar.a).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && android.support.v4.c.c.b(view) && a(cVar);
    }

    private boolean a(String str, int i2, int i3) {
        l n2;
        f();
        c(true);
        g gVar = this.p;
        if (gVar != null && i2 < 0 && str == null && (n2 = gVar.n()) != null && n2.b()) {
            return true;
        }
        boolean a2 = a(this.w, this.x, str, i2, i3);
        if (a2) {
            this.c = true;
            try {
                b(this.w, this.x);
            } finally {
                A();
            }
        }
        g();
        D();
        return a2;
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    private void b(android.support.v4.b.b<g> bVar) {
        int i2 = this.l;
        if (i2 >= 1) {
            int min = Math.min(i2, 4);
            int size = this.e.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = this.e.get(i3);
                if (gVar.k < min) {
                    a(gVar, min, gVar.O(), gVar.P(), false);
                    if (gVar.Q != null && !gVar.I && gVar.Y) {
                        bVar.add(gVar);
                    }
                }
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a(view, cVar)) {
            if (cVar.b != null) {
                cVar.b.addListener(new d(view));
                return;
            }
            Animation.AnimationListener a2 = a(cVar.a);
            view.setLayerType(2, (Paint) null);
            cVar.a.setAnimationListener(new a(view, a2));
        }
    }

    private void b(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).u) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).u) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
            }
        }
    }

    private static void b(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            b bVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                bVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                bVar.b(z2);
            } else {
                bVar.a(1);
                bVar.d();
            }
            i2++;
        }
    }

    private void c(boolean z2) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() == this.m.h().getLooper()) {
            if (!z2) {
                y();
            }
            if (this.w == null) {
                this.w = new ArrayList<>();
                this.x = new ArrayList<>();
            }
            this.c = true;
            try {
                a((ArrayList<b>) null, (ArrayList<Boolean>) null);
            } finally {
                this.c = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.util.ArrayList<android.support.v4.app.b> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<android.support.v4.app.m$f> r0 = r4.b     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<android.support.v4.app.m$f> r0 = r4.b     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<android.support.v4.app.m$f> r0 = r4.b     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<android.support.v4.app.m$f> r3 = r4.b     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            android.support.v4.app.m$f r3 = (android.support.v4.app.m.f) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<android.support.v4.app.m$f> r5 = r4.b     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            android.support.v4.app.k r5 = r4.m     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.h()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.D     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: finally extract failed */
    private void e(int i2) {
        try {
            this.c = true;
            a(i2, false);
            this.c = false;
            f();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    private g p(g gVar) {
        ViewGroup viewGroup = gVar.P;
        View view = gVar.Q;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.e.indexOf(gVar) - 1; indexOf >= 0; indexOf--) {
                g gVar2 = this.e.get(indexOf);
                if (gVar2.P == viewGroup && gVar2.Q != null) {
                    return gVar2;
                }
            }
        }
        return null;
    }

    private void y() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.B != null && !this.B.isEmpty();
            if (this.b != null && this.b.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.m.h().removeCallbacks(this.D);
                this.m.h().post(this.D);
            }
        }
    }

    public int a(b bVar) {
        synchronized (this) {
            if (this.j != null) {
                if (this.j.size() > 0) {
                    int intValue = this.j.remove(this.j.size() - 1).intValue();
                    if (a) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + bVar);
                    }
                    this.i.set(intValue, bVar);
                    return intValue;
                }
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + bVar);
            }
            this.i.add(bVar);
            return size;
        }
    }

    public g a(int i2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null && gVar.F == i2) {
                return gVar;
            }
        }
        SparseArray<g> sparseArray = this.f;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            g valueAt = this.f.valueAt(size2);
            if (valueAt != null && valueAt.F == i2) {
                return valueAt;
            }
        }
        return null;
    }

    public g a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        g gVar = this.f.get(i2);
        if (gVar == null) {
            a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        }
        return gVar;
    }

    public g a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                g gVar = this.e.get(size);
                if (gVar != null && str.equals(gVar.H)) {
                    return gVar;
                }
            }
        }
        SparseArray<g> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            g valueAt = this.f.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.H)) {
                return valueAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c a(g gVar, int i2, boolean z2, int i3) {
        int b2;
        int O = gVar.O();
        Animation a2 = gVar.a(i2, z2, O);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = gVar.b(i2, z2, O);
        if (b3 != null) {
            return new c(b3);
        }
        if (O != 0) {
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(O));
            boolean z3 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), O);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.g(), O);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), O);
                        if (loadAnimation2 != null) {
                            return new c(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0 || (b2 = b(i2, z2)) < 0) {
            return null;
        }
        switch (b2) {
            case f.a.MapAttrs_cameraBearing /*1*/:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case f.a.MapAttrs_cameraTargetLat /*4*/:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                return a(this.m.g(), 0.0f, 1.0f);
            case f.a.MapAttrs_cameraTilt /*6*/:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i3 == 0 && this.m.d()) {
                    i3 = this.m.e();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    public o a() {
        return new b(this);
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((f) new g((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public void a(int i2, b bVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i2 < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + bVar);
                }
                this.i.set(i2, bVar);
            } else {
                while (size < i2) {
                    this.i.add((Object) null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + bVar);
                }
                this.i.add(bVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        k kVar;
        if (this.m == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.l) {
            this.l = i2;
            if (this.f != null) {
                int size = this.e.size();
                boolean z3 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    g gVar = this.e.get(i3);
                    e(gVar);
                    if (gVar.U != null) {
                        z3 |= gVar.U.a();
                    }
                }
                int size2 = this.f.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    g valueAt = this.f.valueAt(i4);
                    if (valueAt != null && ((valueAt.u || valueAt.J) && !valueAt.Y)) {
                        e(valueAt);
                        if (valueAt.U != null) {
                            z3 |= valueAt.U.a();
                        }
                    }
                }
                if (!z3) {
                    e();
                }
                if (this.r && (kVar = this.m) != null && this.l == 5) {
                    kVar.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, g gVar) {
        if (gVar.n < 0) {
            a((RuntimeException) new IllegalStateException("Fragment " + gVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, gVar.n);
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable, n nVar) {
        List<n> list;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                if (nVar != null) {
                    List<g> a2 = nVar.a();
                    list = nVar.b();
                    int size = a2 != null ? a2.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        g gVar = a2.get(i2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + gVar);
                        }
                        int i3 = 0;
                        while (i3 < fragmentManagerState.a.length && fragmentManagerState.a[i3].b != gVar.n) {
                            i3++;
                        }
                        if (i3 == fragmentManagerState.a.length) {
                            a((RuntimeException) new IllegalStateException("Could not find active fragment with index " + gVar.n));
                        }
                        FragmentState fragmentState = fragmentManagerState.a[i3];
                        fragmentState.l = gVar;
                        gVar.m = null;
                        gVar.z = 0;
                        gVar.w = false;
                        gVar.t = false;
                        gVar.q = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.m.g().getClassLoader());
                            gVar.m = fragmentState.k.getSparseParcelableArray("android:view_state");
                            gVar.l = fragmentState.k;
                        }
                    }
                } else {
                    list = null;
                }
                this.f = new SparseArray<>(fragmentManagerState.a.length);
                int i4 = 0;
                while (i4 < fragmentManagerState.a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i4];
                    if (fragmentState2 != null) {
                        g a3 = fragmentState2.a(this.m, this.n, this.o, (list == null || i4 >= list.size()) ? null : list.get(i4));
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a3);
                        }
                        this.f.put(a3.n, a3);
                        fragmentState2.l = null;
                    }
                    i4++;
                }
                if (nVar != null) {
                    List<g> a4 = nVar.a();
                    int size2 = a4 != null ? a4.size() : 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        g gVar2 = a4.get(i5);
                        if (gVar2.r >= 0) {
                            gVar2.q = this.f.get(gVar2.r);
                            if (gVar2.q == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + gVar2 + " target no longer exists: " + gVar2.r);
                            }
                        }
                    }
                }
                this.e.clear();
                if (fragmentManagerState.b != null) {
                    int i6 = 0;
                    while (i6 < fragmentManagerState.b.length) {
                        g gVar3 = this.f.get(fragmentManagerState.b[i6]);
                        if (gVar3 == null) {
                            a((RuntimeException) new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i6]));
                        }
                        gVar3.t = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + gVar3);
                        }
                        if (!this.e.contains(gVar3)) {
                            synchronized (this.e) {
                                this.e.add(gVar3);
                            }
                            i6++;
                        } else {
                            throw new IllegalStateException("Already added!");
                        }
                    }
                }
                if (fragmentManagerState.c != null) {
                    this.g = new ArrayList<>(fragmentManagerState.c.length);
                    for (int i7 = 0; i7 < fragmentManagerState.c.length; i7++) {
                        b a5 = fragmentManagerState.c[i7].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + a5.n + "): " + a5);
                            PrintWriter printWriter = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
                            a5.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a5);
                        if (a5.n >= 0) {
                            a(a5.n, a5);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.d >= 0) {
                    this.p = this.f.get(fragmentManagerState.d);
                }
                this.d = fragmentManagerState.e;
            }
        }
    }

    public void a(g gVar) {
        if (!gVar.S) {
            return;
        }
        if (this.c) {
            this.v = true;
            return;
        }
        gVar.S = false;
        a(gVar, this.l, 0, 0, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0231, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0313, code lost:
        if (r11 >= 4) goto L_0x0335;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0317, code lost:
        if (a == false) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0319, code lost:
        android.util.Log.v("FragmentManager", "movefrom STARTED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x032f, code lost:
        r16.J();
        e(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0335, code lost:
        if (r11 >= 3) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0339, code lost:
        if (a == false) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x033b, code lost:
        android.util.Log.v("FragmentManager", "movefrom STOPPED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0351, code lost:
        r16.K();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0354, code lost:
        if (r11 >= 2) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0358, code lost:
        if (a == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x035a, code lost:
        android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0372, code lost:
        if (r7.Q == null) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x037a, code lost:
        if (r6.m.a(r7) == false) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x037e, code lost:
        if (r7.m != null) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0380, code lost:
        m(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0383, code lost:
        r16.L();
        f(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x038b, code lost:
        if (r7.Q == null) goto L_0x03cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x038f, code lost:
        if (r7.P == null) goto L_0x03cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0391, code lost:
        r7.Q.clearAnimation();
        r7.P.endViewTransition(r7.Q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a0, code lost:
        if (r6.l <= 0) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a4, code lost:
        if (r6.t != false) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03ac, code lost:
        if (r7.Q.getVisibility() != 0) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03b2, code lost:
        if (r7.aa < 0.0f) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b4, code lost:
        r0 = a(r7, r18, false, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03bd, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03be, code lost:
        r7.aa = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c0, code lost:
        if (r0 == null) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03c2, code lost:
        a(r7, r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03c5, code lost:
        r7.P.removeView(r7.Q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03cc, code lost:
        r7.P = null;
        r7.Q = null;
        r7.R = null;
        r7.w = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03d4, code lost:
        if (r11 >= 1) goto L_0x044a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03d8, code lost:
        if (r6.t == false) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03de, code lost:
        if (r16.T() == null) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03e0, code lost:
        r0 = r16.T();
        r7.a((android.view.View) null);
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03ef, code lost:
        if (r16.U() == null) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03f1, code lost:
        r0 = r16.U();
        r7.a((android.animation.Animator) null);
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03ff, code lost:
        if (r16.T() != null) goto L_0x0446;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0405, code lost:
        if (r16.U() == null) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x040a, code lost:
        if (a == false) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x040c, code lost:
        android.util.Log.v("FragmentManager", "movefrom CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0424, code lost:
        if (r7.L != false) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0426, code lost:
        r16.M();
        g(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x042d, code lost:
        r7.k = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x042f, code lost:
        r16.N();
        h(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0435, code lost:
        if (r20 != false) goto L_0x044a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0439, code lost:
        if (r7.L != false) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x043b, code lost:
        g(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x043f, code lost:
        r7.B = null;
        r7.E = null;
        r7.A = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0446, code lost:
        r7.b(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x019a, code lost:
        c(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x019d, code lost:
        if (r11 <= 1) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a1, code lost:
        if (a == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a3, code lost:
        android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01bb, code lost:
        if (r7.v != false) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01bf, code lost:
        if (r7.G == 0) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c4, code lost:
        if (r7.G != -1) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c6, code lost:
        a((java.lang.RuntimeException) new java.lang.IllegalArgumentException("Cannot create fragment " + r7 + " for a container view with no id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e4, code lost:
        r0 = (android.view.ViewGroup) r6.n.a(r7.G);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ee, code lost:
        if (r0 != null) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f2, code lost:
        if (r7.x != false) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1 = r16.k().getResourceName(r7.G);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ff, code lost:
        r1 = "unknown";
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.support.v4.app.g r16, int r17, int r18, int r19, boolean r20) {
        /*
            r15 = this;
            r6 = r15
            r7 = r16
            boolean r0 = r7.t
            r8 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = r7.J
            if (r0 == 0) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            r0 = r17
            goto L_0x0015
        L_0x0010:
            r0 = r17
            if (r0 <= r8) goto L_0x0015
            r0 = 1
        L_0x0015:
            boolean r1 = r7.u
            if (r1 == 0) goto L_0x002b
            int r1 = r7.k
            if (r0 <= r1) goto L_0x002b
            int r0 = r7.k
            if (r0 != 0) goto L_0x0029
            boolean r0 = r16.g()
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002b
        L_0x0029:
            int r0 = r7.k
        L_0x002b:
            boolean r1 = r7.S
            r9 = 4
            r10 = 3
            if (r1 == 0) goto L_0x0039
            int r1 = r7.k
            if (r1 >= r9) goto L_0x0039
            if (r0 <= r10) goto L_0x0039
            r11 = 3
            goto L_0x003a
        L_0x0039:
            r11 = r0
        L_0x003a:
            int r0 = r7.k
            r12 = 2
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x02e5
            boolean r0 = r7.v
            if (r0 == 0) goto L_0x004a
            boolean r0 = r7.w
            if (r0 != 0) goto L_0x004a
            return
        L_0x004a:
            android.view.View r0 = r16.T()
            if (r0 != 0) goto L_0x0056
            android.animation.Animator r0 = r16.U()
            if (r0 == 0) goto L_0x0069
        L_0x0056:
            r7.a((android.view.View) r13)
            r7.a((android.animation.Animator) r13)
            int r2 = r16.V()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r15
            r1 = r16
            r0.a((android.support.v4.app.g) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x0069:
            int r0 = r7.k
            switch(r0) {
                case 0: goto L_0x0070;
                case 1: goto L_0x019a;
                case 2: goto L_0x0297;
                case 3: goto L_0x029b;
                case 4: goto L_0x02bd;
                default: goto L_0x006e;
            }
        L_0x006e:
            goto L_0x044a
        L_0x0070:
            if (r11 <= 0) goto L_0x019a
            boolean r0 = a
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x008c:
            android.os.Bundle r0 = r7.l
            if (r0 == 0) goto L_0x00d4
            android.os.Bundle r0 = r7.l
            android.support.v4.app.k r1 = r6.m
            android.content.Context r1 = r1.g()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.l
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.m = r0
            android.os.Bundle r0 = r7.l
            java.lang.String r1 = "android:target_state"
            android.support.v4.app.g r0 = r15.a((android.os.Bundle) r0, (java.lang.String) r1)
            r7.q = r0
            android.support.v4.app.g r0 = r7.q
            if (r0 == 0) goto L_0x00c1
            android.os.Bundle r0 = r7.l
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r14)
            r7.s = r0
        L_0x00c1:
            android.os.Bundle r0 = r7.l
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.T = r0
            boolean r0 = r7.T
            if (r0 != 0) goto L_0x00d4
            r7.S = r8
            if (r11 <= r10) goto L_0x00d4
            r11 = 3
        L_0x00d4:
            android.support.v4.app.k r0 = r6.m
            r7.B = r0
            android.support.v4.app.g r1 = r6.o
            r7.E = r1
            if (r1 == 0) goto L_0x00e1
            android.support.v4.app.m r0 = r1.C
            goto L_0x00e5
        L_0x00e1:
            android.support.v4.app.m r0 = r0.i()
        L_0x00e5:
            r7.A = r0
            android.support.v4.app.g r0 = r7.q
            if (r0 == 0) goto L_0x0130
            android.util.SparseArray<android.support.v4.app.g> r0 = r6.f
            android.support.v4.app.g r1 = r7.q
            int r1 = r1.n
            java.lang.Object r0 = r0.get(r1)
            android.support.v4.app.g r1 = r7.q
            if (r0 != r1) goto L_0x010a
            android.support.v4.app.g r0 = r7.q
            int r0 = r0.k
            if (r0 >= r8) goto L_0x0130
            android.support.v4.app.g r1 = r7.q
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r15
            r0.a((android.support.v4.app.g) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x0130
        L_0x010a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            android.support.v4.app.g r2 = r7.q
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0130:
            android.support.v4.app.k r0 = r6.m
            android.content.Context r0 = r0.g()
            r15.a((android.support.v4.app.g) r7, (android.content.Context) r0, (boolean) r14)
            r7.O = r14
            android.support.v4.app.k r0 = r6.m
            android.content.Context r0 = r0.g()
            r7.a((android.content.Context) r0)
            boolean r0 = r7.O
            if (r0 == 0) goto L_0x017e
            android.support.v4.app.g r0 = r7.E
            if (r0 != 0) goto L_0x0152
            android.support.v4.app.k r0 = r6.m
            r0.b(r7)
            goto L_0x0157
        L_0x0152:
            android.support.v4.app.g r0 = r7.E
            r0.a((android.support.v4.app.g) r7)
        L_0x0157:
            android.support.v4.app.k r0 = r6.m
            android.content.Context r0 = r0.g()
            r15.b((android.support.v4.app.g) r7, (android.content.Context) r0, (boolean) r14)
            boolean r0 = r7.ac
            if (r0 != 0) goto L_0x0174
            android.os.Bundle r0 = r7.l
            r15.a((android.support.v4.app.g) r7, (android.os.Bundle) r0, (boolean) r14)
            android.os.Bundle r0 = r7.l
            r7.l(r0)
            android.os.Bundle r0 = r7.l
            r15.b((android.support.v4.app.g) r7, (android.os.Bundle) r0, (boolean) r14)
            goto L_0x017b
        L_0x0174:
            android.os.Bundle r0 = r7.l
            r7.j(r0)
            r7.k = r8
        L_0x017b:
            r7.L = r14
            goto L_0x019a
        L_0x017e:
            android.support.v4.app.aj r0 = new android.support.v4.app.aj
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " did not call through to super.onAttach()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x019a:
            r15.c((android.support.v4.app.g) r16)
            if (r11 <= r8) goto L_0x0297
            boolean r0 = a
            if (r0 == 0) goto L_0x01b9
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x01b9:
            boolean r0 = r7.v
            if (r0 != 0) goto L_0x0282
            int r0 = r7.G
            if (r0 == 0) goto L_0x0231
            int r0 = r7.G
            r1 = -1
            if (r0 != r1) goto L_0x01e4
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r15.a((java.lang.RuntimeException) r0)
        L_0x01e4:
            android.support.v4.app.i r0 = r6.n
            int r1 = r7.G
            android.view.View r0 = r0.a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0232
            boolean r1 = r7.x
            if (r1 != 0) goto L_0x0232
            android.content.res.Resources r1 = r16.k()     // Catch:{ NotFoundException -> 0x01ff }
            int r2 = r7.G     // Catch:{ NotFoundException -> 0x01ff }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x01ff }
            goto L_0x0201
        L_0x01ff:
            java.lang.String r1 = "unknown"
        L_0x0201:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "No view found for id 0x"
            r3.append(r4)
            int r4 = r7.G
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r3.append(r4)
            java.lang.String r4 = " ("
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ") for fragment "
            r3.append(r1)
            r3.append(r7)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            r15.a((java.lang.RuntimeException) r2)
            goto L_0x0232
        L_0x0231:
            r0 = r13
        L_0x0232:
            r7.P = r0
            android.os.Bundle r1 = r7.l
            android.view.LayoutInflater r1 = r7.h((android.os.Bundle) r1)
            android.os.Bundle r2 = r7.l
            android.view.View r1 = r7.b((android.view.LayoutInflater) r1, (android.view.ViewGroup) r0, (android.os.Bundle) r2)
            r7.Q = r1
            android.view.View r1 = r7.Q
            if (r1 == 0) goto L_0x0280
            android.view.View r1 = r7.Q
            r7.R = r1
            android.view.View r1 = r7.Q
            r1.setSaveFromParentEnabled(r14)
            if (r0 == 0) goto L_0x0256
            android.view.View r1 = r7.Q
            r0.addView(r1)
        L_0x0256:
            boolean r0 = r7.I
            if (r0 == 0) goto L_0x0261
            android.view.View r0 = r7.Q
            r1 = 8
            r0.setVisibility(r1)
        L_0x0261:
            android.view.View r0 = r7.Q
            android.os.Bundle r1 = r7.l
            r7.a((android.view.View) r0, (android.os.Bundle) r1)
            android.view.View r0 = r7.Q
            android.os.Bundle r1 = r7.l
            r15.a((android.support.v4.app.g) r7, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r14)
            android.view.View r0 = r7.Q
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x027c
            android.view.ViewGroup r0 = r7.P
            if (r0 == 0) goto L_0x027c
            goto L_0x027d
        L_0x027c:
            r8 = 0
        L_0x027d:
            r7.Y = r8
            goto L_0x0282
        L_0x0280:
            r7.R = r13
        L_0x0282:
            android.os.Bundle r0 = r7.l
            r7.m(r0)
            android.os.Bundle r0 = r7.l
            r15.c(r7, r0, r14)
            android.view.View r0 = r7.Q
            if (r0 == 0) goto L_0x0295
            android.os.Bundle r0 = r7.l
            r7.f((android.os.Bundle) r0)
        L_0x0295:
            r7.l = r13
        L_0x0297:
            if (r11 <= r12) goto L_0x029b
            r7.k = r10
        L_0x029b:
            if (r11 <= r10) goto L_0x02bd
            boolean r0 = a
            if (r0 == 0) goto L_0x02b7
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02b7:
            r16.E()
            r15.b((android.support.v4.app.g) r7, (boolean) r14)
        L_0x02bd:
            if (r11 <= r9) goto L_0x044a
            boolean r0 = a
            if (r0 == 0) goto L_0x02d9
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02d9:
            r16.F()
            r15.c((android.support.v4.app.g) r7, (boolean) r14)
            r7.l = r13
            r7.m = r13
            goto L_0x044a
        L_0x02e5:
            int r0 = r7.k
            if (r0 <= r11) goto L_0x044a
            int r0 = r7.k
            switch(r0) {
                case 1: goto L_0x03d4;
                case 2: goto L_0x0354;
                case 3: goto L_0x0335;
                case 4: goto L_0x0313;
                case 5: goto L_0x02f0;
                default: goto L_0x02ee;
            }
        L_0x02ee:
            goto L_0x044a
        L_0x02f0:
            r0 = 5
            if (r11 >= r0) goto L_0x0313
            boolean r0 = a
            if (r0 == 0) goto L_0x030d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x030d:
            r16.I()
            r15.d(r7, r14)
        L_0x0313:
            if (r11 >= r9) goto L_0x0335
            boolean r0 = a
            if (r0 == 0) goto L_0x032f
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x032f:
            r16.J()
            r15.e(r7, r14)
        L_0x0335:
            if (r11 >= r10) goto L_0x0354
            boolean r0 = a
            if (r0 == 0) goto L_0x0351
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STOPPED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0351:
            r16.K()
        L_0x0354:
            if (r11 >= r12) goto L_0x03d4
            boolean r0 = a
            if (r0 == 0) goto L_0x0370
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0370:
            android.view.View r0 = r7.Q
            if (r0 == 0) goto L_0x0383
            android.support.v4.app.k r0 = r6.m
            boolean r0 = r0.a((android.support.v4.app.g) r7)
            if (r0 == 0) goto L_0x0383
            android.util.SparseArray<android.os.Parcelable> r0 = r7.m
            if (r0 != 0) goto L_0x0383
            r15.m(r16)
        L_0x0383:
            r16.L()
            r15.f(r7, r14)
            android.view.View r0 = r7.Q
            if (r0 == 0) goto L_0x03cc
            android.view.ViewGroup r0 = r7.P
            if (r0 == 0) goto L_0x03cc
            android.view.View r0 = r7.Q
            r0.clearAnimation()
            android.view.ViewGroup r0 = r7.P
            android.view.View r1 = r7.Q
            r0.endViewTransition(r1)
            int r0 = r6.l
            r1 = 0
            if (r0 <= 0) goto L_0x03bd
            boolean r0 = r6.t
            if (r0 != 0) goto L_0x03bd
            android.view.View r0 = r7.Q
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x03bd
            float r0 = r7.aa
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x03bd
            r0 = r18
            r2 = r19
            android.support.v4.app.m$c r0 = r15.a((android.support.v4.app.g) r7, (int) r0, (boolean) r14, (int) r2)
            goto L_0x03be
        L_0x03bd:
            r0 = r13
        L_0x03be:
            r7.aa = r1
            if (r0 == 0) goto L_0x03c5
            r15.a((android.support.v4.app.g) r7, (android.support.v4.app.m.c) r0, (int) r11)
        L_0x03c5:
            android.view.ViewGroup r0 = r7.P
            android.view.View r1 = r7.Q
            r0.removeView(r1)
        L_0x03cc:
            r7.P = r13
            r7.Q = r13
            r7.R = r13
            r7.w = r14
        L_0x03d4:
            if (r11 >= r8) goto L_0x044a
            boolean r0 = r6.t
            if (r0 == 0) goto L_0x03fb
            android.view.View r0 = r16.T()
            if (r0 == 0) goto L_0x03eb
            android.view.View r0 = r16.T()
            r7.a((android.view.View) r13)
            r0.clearAnimation()
            goto L_0x03fb
        L_0x03eb:
            android.animation.Animator r0 = r16.U()
            if (r0 == 0) goto L_0x03fb
            android.animation.Animator r0 = r16.U()
            r7.a((android.animation.Animator) r13)
            r0.cancel()
        L_0x03fb:
            android.view.View r0 = r16.T()
            if (r0 != 0) goto L_0x0446
            android.animation.Animator r0 = r16.U()
            if (r0 == 0) goto L_0x0408
            goto L_0x0446
        L_0x0408:
            boolean r0 = a
            if (r0 == 0) goto L_0x0422
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom CREATED: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0422:
            boolean r0 = r7.L
            if (r0 != 0) goto L_0x042d
            r16.M()
            r15.g(r7, r14)
            goto L_0x042f
        L_0x042d:
            r7.k = r14
        L_0x042f:
            r16.N()
            r15.h(r7, r14)
            if (r20 != 0) goto L_0x044a
            boolean r0 = r7.L
            if (r0 != 0) goto L_0x043f
            r15.g(r16)
            goto L_0x044a
        L_0x043f:
            r7.B = r13
            r7.E = r13
            r7.A = r13
            goto L_0x044a
        L_0x0446:
            r7.b((int) r11)
            goto L_0x044b
        L_0x044a:
            r8 = r11
        L_0x044b:
            int r0 = r7.k
            if (r0 == r8) goto L_0x047e
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveToState: Fragment state for "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " not updated inline; "
            r1.append(r2)
            java.lang.String r2 = "expected state "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " found "
            r1.append(r2)
            int r2 = r7.k
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            r7.k = r8
        L_0x047e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.a(android.support.v4.app.g, int, int, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, Context context, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).a(gVar, context, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a((l) this, gVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, Bundle bundle, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).a(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a((l) this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, View view, Bundle bundle, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).a(gVar, view, bundle, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a(this, gVar, view, bundle);
            }
        }
    }

    public void a(g gVar, boolean z2) {
        if (a) {
            Log.v("FragmentManager", "add: " + gVar);
        }
        f(gVar);
        if (gVar.J) {
            return;
        }
        if (!this.e.contains(gVar)) {
            synchronized (this.e) {
                this.e.add(gVar);
            }
            gVar.t = true;
            gVar.u = false;
            if (gVar.Q == null) {
                gVar.Z = false;
            }
            if (gVar.M && gVar.N) {
                this.r = true;
            }
            if (z2) {
                b(gVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + gVar);
    }

    public void a(k kVar, i iVar, g gVar) {
        if (this.m == null) {
            this.m = kVar;
            this.n = iVar;
            this.o = gVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(f fVar, boolean z2) {
        if (!z2) {
            y();
        }
        synchronized (this) {
            if (!this.t) {
                if (this.m != null) {
                    if (this.b == null) {
                        this.b = new ArrayList<>();
                    }
                    this.b.add(fVar);
                    z();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<g> sparseArray = this.f;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                g valueAt = this.f.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<g> arrayList = this.h;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.h.get(i4).toString());
            }
        }
        ArrayList<b> arrayList2 = this.g;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                b bVar = this.g.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(bVar.toString());
                bVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.i.get(i6));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<f> arrayList3 = this.b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(this.b.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
    }

    public void a(boolean z2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.f(z2);
            }
        }
    }

    public boolean a(Menu menu) {
        boolean z2 = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.c(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        ArrayList<g> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(gVar);
                z2 = true;
            }
        }
        if (this.h != null) {
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                g gVar2 = this.h.get(i3);
                if (arrayList == null || !arrayList.contains(gVar2)) {
                    gVar2.t();
                }
            }
        }
        this.h = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<b> arrayList3 = this.g;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.g.size() - 1;
                while (i4 >= 0) {
                    b bVar = this.g.get(i4);
                    if ((str != null && str.equals(bVar.f())) || (i2 >= 0 && i2 == bVar.n)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        b bVar2 = this.g.get(i4);
                        if ((str == null || !str.equals(bVar2.f())) && (i2 < 0 || i2 != bVar2.n)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.g.size() - 1) {
                return false;
            }
            for (int size2 = this.g.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.g.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public g b(String str) {
        g a2;
        SparseArray<g> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            g valueAt = this.f.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(b bVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) {
        a(gVar, this.l, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, Context context, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).b(gVar, context, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b((l) this, gVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, Bundle bundle, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).b(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b((l) this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).b(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).a(this, gVar);
            }
        }
    }

    public void b(Menu menu) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.d(menu);
            }
        }
    }

    public void b(boolean z2) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.g(z2);
            }
        }
    }

    public boolean b() {
        y();
        return a((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        return this.l >= i2;
    }

    public boolean b(MenuItem menuItem) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null && gVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public List<g> c() {
        List<g> list;
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    public void c(int i2) {
        synchronized (this) {
            this.i.set(i2, (Object) null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.j.add(Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar) {
        if (gVar.v && !gVar.y) {
            gVar.Q = gVar.b(gVar.h(gVar.l), (ViewGroup) null, gVar.l);
            if (gVar.Q != null) {
                gVar.R = gVar.Q;
                gVar.Q.setSaveFromParentEnabled(false);
                if (gVar.I) {
                    gVar.Q.setVisibility(8);
                }
                gVar.a(gVar.Q, gVar.l);
                a(gVar, gVar.Q, gVar.l, false);
                return;
            }
            gVar.R = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar, Bundle bundle, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).c(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).c(this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).c(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).b(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(final g gVar) {
        if (gVar.Q != null) {
            c a2 = a(gVar, gVar.P(), !gVar.I, gVar.Q());
            if (a2 == null || a2.b == null) {
                if (a2 != null) {
                    b(gVar.Q, a2);
                    gVar.Q.startAnimation(a2.a);
                    a2.a.start();
                }
                gVar.Q.setVisibility((!gVar.I || gVar.X()) ? 0 : 8);
                if (gVar.X()) {
                    gVar.h(false);
                }
            } else {
                a2.b.setTarget(gVar.Q);
                if (!gVar.I) {
                    gVar.Q.setVisibility(0);
                } else if (gVar.X()) {
                    gVar.h(false);
                } else {
                    final ViewGroup viewGroup = gVar.P;
                    final View view = gVar.Q;
                    viewGroup.startViewTransition(view);
                    a2.b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (gVar.Q != null) {
                                gVar.Q.setVisibility(8);
                            }
                        }
                    });
                }
                b(gVar.Q, a2);
                a2.b.start();
            }
        }
        if (gVar.t && gVar.M && gVar.N) {
            this.r = true;
        }
        gVar.Z = false;
        gVar.c(gVar.I);
    }

    /* access modifiers changed from: package-private */
    public void d(g gVar, Bundle bundle, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).d(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).d(this, gVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).d(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).c(this, gVar);
            }
        }
    }

    public boolean d() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null) {
                    a(valueAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r0.Q;
        r1 = r11.P;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.support.v4.app.g r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r10.l
            boolean r1 = r11.u
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            boolean r1 = r11.g()
            if (r1 == 0) goto L_0x0016
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x001a
        L_0x0016:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x001a:
            r6 = r0
            int r7 = r11.P()
            int r8 = r11.Q()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.a((android.support.v4.app.g) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
            android.view.View r0 = r11.Q
            if (r0 == 0) goto L_0x0090
            android.support.v4.app.g r0 = r10.p(r11)
            if (r0 == 0) goto L_0x004b
            android.view.View r0 = r0.Q
            android.view.ViewGroup r1 = r11.P
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.Q
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x004b
            r1.removeViewAt(r4)
            android.view.View r4 = r11.Q
            r1.addView(r4, r0)
        L_0x004b:
            boolean r0 = r11.Y
            if (r0 == 0) goto L_0x0090
            android.view.ViewGroup r0 = r11.P
            if (r0 == 0) goto L_0x0090
            float r0 = r11.aa
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            android.view.View r0 = r11.Q
            float r4 = r11.aa
            r0.setAlpha(r4)
        L_0x0061:
            r11.aa = r1
            r11.Y = r3
            int r0 = r11.P()
            int r1 = r11.Q()
            android.support.v4.app.m$c r0 = r10.a((android.support.v4.app.g) r11, (int) r0, (boolean) r2, (int) r1)
            if (r0 == 0) goto L_0x0090
            android.view.View r1 = r11.Q
            b((android.view.View) r1, (android.support.v4.app.m.c) r0)
            android.view.animation.Animation r1 = r0.a
            if (r1 == 0) goto L_0x0084
            android.view.View r1 = r11.Q
            android.view.animation.Animation r0 = r0.a
            r1.startAnimation(r0)
            goto L_0x0090
        L_0x0084:
            android.animation.Animator r1 = r0.b
            android.view.View r2 = r11.Q
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.b
            r0.start()
        L_0x0090:
            boolean r0 = r11.Z
            if (r0 == 0) goto L_0x0097
            r10.d((android.support.v4.app.g) r11)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.e(android.support.v4.app.g):void");
    }

    /* access modifiers changed from: package-private */
    public void e(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).e(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).d(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar) {
        if (gVar.n < 0) {
            int i2 = this.d;
            this.d = i2 + 1;
            gVar.a(i2, this.o);
            if (this.f == null) {
                this.f = new SparseArray<>();
            }
            this.f.put(gVar.n, gVar);
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).f(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).e(this, gVar);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean f() {
        c(true);
        boolean z2 = false;
        while (c(this.w, this.x)) {
            this.c = true;
            try {
                b(this.w, this.x);
                A();
                z2 = true;
            } catch (Throwable th) {
                A();
                throw th;
            }
        }
        g();
        D();
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.v) {
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                g valueAt = this.f.valueAt(i2);
                if (!(valueAt == null || valueAt.U == null)) {
                    z2 |= valueAt.U.a();
                }
            }
            if (!z2) {
                this.v = false;
                e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(g gVar) {
        if (gVar.n >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + gVar);
            }
            this.f.put(gVar.n, (Object) null);
            this.m.a(gVar.o);
            gVar.s();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).g(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).f(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).a();
            }
        }
    }

    public void h(g gVar) {
        if (a) {
            Log.v("FragmentManager", "remove: " + gVar + " nesting=" + gVar.z);
        }
        boolean z2 = !gVar.g();
        if (!gVar.J || z2) {
            synchronized (this.e) {
                this.e.remove(gVar);
            }
            if (gVar.M && gVar.N) {
                this.r = true;
            }
            gVar.t = false;
            gVar.u = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(g gVar, boolean z2) {
        g gVar2 = this.o;
        if (gVar2 != null) {
            l l2 = gVar2.l();
            if (l2 instanceof m) {
                ((m) l2).h(gVar, true);
            }
        }
        Iterator<android.support.v4.b.g<l.a, Boolean>> it = this.I.iterator();
        while (it.hasNext()) {
            android.support.v4.b.g next = it.next();
            if (!z2 || ((Boolean) next.b).booleanValue()) {
                ((l.a) next.a).g(this, gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public n i() {
        a(this.C);
        return this.C;
    }

    public void i(g gVar) {
        if (a) {
            Log.v("FragmentManager", "hide: " + gVar);
        }
        if (!gVar.I) {
            gVar.I = true;
            gVar.Z = true ^ gVar.Z;
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        ArrayList arrayList;
        ArrayList arrayList2;
        n nVar;
        if (this.f != null) {
            arrayList2 = null;
            arrayList = null;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                g valueAt = this.f.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.K) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(valueAt);
                        valueAt.r = valueAt.q != null ? valueAt.q.n : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    if (valueAt.C != null) {
                        valueAt.C.j();
                        nVar = valueAt.C.C;
                    } else {
                        nVar = valueAt.D;
                    }
                    if (arrayList == null && nVar != null) {
                        arrayList = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList.add((Object) null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(nVar);
                    }
                }
            }
        } else {
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList2 == null && arrayList == null) {
            this.C = null;
        } else {
            this.C = new n(arrayList2, arrayList);
        }
    }

    public void j(g gVar) {
        if (a) {
            Log.v("FragmentManager", "show: " + gVar);
        }
        if (gVar.I) {
            gVar.I = false;
            gVar.Z = !gVar.Z;
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable k() {
        int[] iArr;
        int size;
        B();
        C();
        f();
        this.s = true;
        BackStackState[] backStackStateArr = null;
        this.C = null;
        SparseArray<g> sparseArray = this.f;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        boolean z2 = false;
        for (int i2 = 0; i2 < size2; i2++) {
            g valueAt = this.f.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.n < 0) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.n));
                }
                FragmentState fragmentState = new FragmentState(valueAt);
                fragmentStateArr[i2] = fragmentState;
                if (valueAt.k <= 0 || fragmentState.k != null) {
                    fragmentState.k = valueAt.l;
                } else {
                    fragmentState.k = n(valueAt);
                    if (valueAt.q != null) {
                        if (valueAt.q.n < 0) {
                            a((RuntimeException) new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.q));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        a(fragmentState.k, "android:target_state", valueAt.q);
                        if (valueAt.s != 0) {
                            fragmentState.k.putInt("android:target_req_state", valueAt.s);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + valueAt + ": " + fragmentState.k);
                }
                z2 = true;
            }
        }
        if (!z2) {
            if (a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.e.get(i3).n;
                if (iArr[i3] < 0) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + this.e.get(i3) + " has cleared index: " + iArr[i3]));
                }
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.e.get(i3));
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<b> arrayList = this.g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i4 = 0; i4 < size; i4++) {
                backStackStateArr[i4] = new BackStackState(this.g.get(i4));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.g.get(i4));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        g gVar = this.p;
        if (gVar != null) {
            fragmentManagerState.d = gVar.n;
        }
        fragmentManagerState.e = this.d;
        j();
        return fragmentManagerState;
    }

    public void k(g gVar) {
        if (a) {
            Log.v("FragmentManager", "detach: " + gVar);
        }
        if (!gVar.J) {
            gVar.J = true;
            if (gVar.t) {
                if (a) {
                    Log.v("FragmentManager", "remove from detach: " + gVar);
                }
                synchronized (this.e) {
                    this.e.remove(gVar);
                }
                if (gVar.M && gVar.N) {
                    this.r = true;
                }
                gVar.t = false;
            }
        }
    }

    public void l() {
        this.C = null;
        this.s = false;
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.G();
            }
        }
    }

    public void l(g gVar) {
        if (a) {
            Log.v("FragmentManager", "attach: " + gVar);
        }
        if (gVar.J) {
            gVar.J = false;
            if (gVar.t) {
                return;
            }
            if (!this.e.contains(gVar)) {
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + gVar);
                }
                synchronized (this.e) {
                    this.e.add(gVar);
                }
                gVar.t = true;
                if (gVar.M && gVar.N) {
                    this.r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + gVar);
        }
    }

    public void m() {
        this.s = false;
        e(1);
    }

    /* access modifiers changed from: package-private */
    public void m(g gVar) {
        if (gVar.R != null) {
            SparseArray<Parcelable> sparseArray = this.A;
            if (sparseArray == null) {
                this.A = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            gVar.R.saveHierarchyState(this.A);
            if (this.A.size() > 0) {
                gVar.m = this.A;
                this.A = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle n(g gVar) {
        Bundle bundle;
        if (this.z == null) {
            this.z = new Bundle();
        }
        gVar.n(this.z);
        d(gVar, this.z, false);
        if (!this.z.isEmpty()) {
            bundle = this.z;
            this.z = null;
        } else {
            bundle = null;
        }
        if (gVar.Q != null) {
            m(gVar);
        }
        if (gVar.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", gVar.m);
        }
        if (!gVar.T) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", gVar.T);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        e(2);
    }

    public void o() {
        this.s = false;
        e(4);
    }

    public void o(g gVar) {
        if (gVar == null || (this.f.get(gVar.n) == gVar && (gVar.B == null || gVar.l() == this))) {
            this.p = gVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + gVar + " is not an active fragment of FragmentManager " + this);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        g gVar;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, e.a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!g.a(this.m.g(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        g a2 = resourceId != -1 ? a(resourceId) : null;
        if (a2 == null && string != null) {
            a2 = a(string);
        }
        if (a2 == null && i2 != -1) {
            a2 = a(i2);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + a2);
        }
        if (a2 == null) {
            g a3 = this.n.a(context2, str3, (Bundle) null);
            a3.v = true;
            a3.F = resourceId != 0 ? resourceId : i2;
            a3.G = i2;
            a3.H = string;
            a3.w = true;
            a3.A = this;
            k kVar = this.m;
            a3.B = kVar;
            a3.a(kVar.g(), attributeSet2, a3.l);
            a(a3, true);
            gVar = a3;
        } else if (!a2.w) {
            a2.w = true;
            a2.B = this.m;
            if (!a2.L) {
                a2.a(this.m.g(), attributeSet2, a2.l);
            }
            gVar = a2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        if (this.l >= 1 || !gVar.v) {
            b(gVar);
        } else {
            a(gVar, 1, 0, 0, false);
        }
        if (gVar.Q != null) {
            if (resourceId != 0) {
                gVar.Q.setId(resourceId);
            }
            if (gVar.Q.getTag() == null) {
                gVar.Q.setTag(string);
            }
            return gVar.Q;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void p() {
        this.s = false;
        e(5);
    }

    public void q() {
        e(4);
    }

    public void r() {
        this.s = true;
        e(3);
    }

    public void s() {
        e(2);
    }

    public void t() {
        e(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.o;
        if (obj == null) {
            obj = this.m;
        }
        android.support.v4.b.d.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        this.t = true;
        f();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void v() {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar != null) {
                gVar.H();
            }
        }
    }

    public g w() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 x() {
        return this;
    }
}
