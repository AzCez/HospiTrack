package android.support.v4.c;

import android.os.Build;
import android.view.View;
import java.util.WeakHashMap;

public class c {
    static final j a = (Build.VERSION.SDK_INT >= 26 ? new i() : Build.VERSION.SDK_INT >= 24 ? new h() : Build.VERSION.SDK_INT >= 23 ? new g() : Build.VERSION.SDK_INT >= 21 ? new f() : Build.VERSION.SDK_INT >= 19 ? new e() : Build.VERSION.SDK_INT >= 18 ? new d() : Build.VERSION.SDK_INT >= 17 ? new C0008c() : Build.VERSION.SDK_INT >= 16 ? new b() : Build.VERSION.SDK_INT >= 15 ? new a() : new j());

    static class a extends j {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public boolean a(View view) {
            return view.hasOverlappingRendering();
        }
    }

    /* renamed from: android.support.v4.c.c$c  reason: collision with other inner class name */
    static class C0008c extends b {
        C0008c() {
        }
    }

    static class d extends C0008c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public boolean b(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        f() {
        }

        public String c(View view) {
            return view.getTransitionName();
        }
    }

    static class g extends f {
        g() {
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }
    }

    static class j {
        static boolean b = false;
        private static WeakHashMap<View, String> c;
        WeakHashMap<View, Object> a = null;

        j() {
        }

        public boolean a(View view) {
            return true;
        }

        public boolean b(View view) {
            return view.getWindowToken() != null;
        }

        public String c(View view) {
            WeakHashMap<View, String> weakHashMap = c;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }
    }

    public static String a(View view) {
        return a.c(view);
    }

    public static boolean b(View view) {
        return a.a(view);
    }

    public static boolean c(View view) {
        return a.b(view);
    }
}
