package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ag;
import java.util.Set;

public final class ae extends ag.a {
    public static final ag.a.C0006a a = new ag.a.C0006a() {
    };
    private static final a h = (Build.VERSION.SDK_INT >= 20 ? new b() : Build.VERSION.SDK_INT >= 16 ? new d() : new c());
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;
    private final Set<String> g;

    interface a {
    }

    static class b implements a {
        b() {
        }
    }

    static class c implements a {
        c() {
        }
    }

    static class d implements a {
        d() {
        }
    }

    public String a() {
        return this.b;
    }

    public CharSequence b() {
        return this.c;
    }

    public CharSequence[] c() {
        return this.d;
    }

    public Set<String> d() {
        return this.g;
    }

    public boolean e() {
        return this.e;
    }

    public Bundle f() {
        return this.f;
    }
}
