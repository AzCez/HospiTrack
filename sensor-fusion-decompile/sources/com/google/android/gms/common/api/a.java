package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.n;
import java.util.Set;

public final class a<O extends d> {
    private final C0020a<?, O> a;
    private final i<?, O> b = null;
    private final g<?> c;
    private final j<?> d;
    private final String e;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0020a<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, com.google.android.gms.common.internal.c cVar, O o, f.a aVar, f.b bVar);
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0021a extends c, C0022d {
            Account a();
        }

        public interface b extends c {
            GoogleSignInAccount a();
        }

        public interface c extends d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d  reason: collision with other inner class name */
        public interface C0022d extends d {
        }

        public interface e extends c, C0022d {
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a();

        void a(b.c cVar);

        void a(b.e eVar);

        void a(com.google.android.gms.common.internal.i iVar, Set<Scope> set);

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        String f();

        int g();

        Feature[] h();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public interface h<T extends IInterface> extends b {
        T a(IBinder iBinder);

        String a();

        void a(int i, T t);

        String b();
    }

    public static abstract class i<T extends h, O> extends e<T, O> {
    }

    public static final class j<C extends h> extends c<C> {
    }

    public <C extends f> a(String str, C0020a<C, O> aVar, g<C> gVar) {
        n.a(aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        n.a(gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.a = aVar;
        this.c = gVar;
        this.d = null;
    }

    public final C0020a<?, O> a() {
        n.a(this.a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public final String b() {
        return this.e;
    }
}
