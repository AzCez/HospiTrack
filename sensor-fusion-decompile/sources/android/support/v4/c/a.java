package android.support.v4.c;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class a {
    static final b a = (Build.VERSION.SDK_INT >= 21 ? new C0007a() : new b());
    private static Field b;
    private static boolean c;

    /* renamed from: android.support.v4.c.a$a  reason: collision with other inner class name */
    static class C0007a extends b {
        C0007a() {
        }

        public void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static class b {
        b() {
        }

        public void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                a.a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                a.a(layoutInflater, factory2);
            }
        }
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!c) {
            try {
                b = LayoutInflater.class.getDeclaredField("mFactory2");
                b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            c = true;
        }
        Field field = b;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        a.a(layoutInflater, factory2);
    }
}
