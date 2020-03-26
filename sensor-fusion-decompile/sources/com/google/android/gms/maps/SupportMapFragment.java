package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.support.v4.app.g;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.maps.a.c;
import com.google.android.gms.maps.a.e;
import com.google.android.gms.maps.a.k;
import com.google.android.gms.maps.a.l;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends g {
    private final b a = new b(this);

    static class a implements e {
        private final g a;
        private final c b;

        public a(g gVar, c cVar) {
            this.b = (c) n.a(cVar);
            this.a = (g) n.a(gVar);
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                k.a(bundle, bundle2);
                com.google.android.gms.b.b a2 = this.b.a(d.a(layoutInflater), d.a(viewGroup), bundle2);
                k.a(bundle2, bundle);
                return (View) d.a(a2);
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void a() {
            try {
                this.b.f();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                k.a(bundle2, bundle3);
                this.b.a(d.a(activity), googleMapOptions, bundle3);
                k.a(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                k.a(bundle, bundle2);
                Bundle h = this.a.h();
                if (h != null && h.containsKey("MapOptions")) {
                    k.a(bundle2, "MapOptions", h.getParcelable("MapOptions"));
                }
                this.b.a(bundle2);
                k.a(bundle2, bundle);
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void a(e eVar) {
            try {
                this.b.a((com.google.android.gms.maps.a.g) new i(this, eVar));
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void b() {
            try {
                this.b.a();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                k.a(bundle, bundle2);
                this.b.b(bundle2);
                k.a(bundle2, bundle);
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void c() {
            try {
                this.b.b();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void d() {
            try {
                this.b.g();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void e() {
            try {
                this.b.c();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void f() {
            try {
                this.b.d();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }

        public final void g() {
            try {
                this.b.e();
            } catch (RemoteException e) {
                throw new com.google.android.gms.maps.model.b(e);
            }
        }
    }

    static class b extends com.google.android.gms.b.a<a> {
        private final g a;
        private com.google.android.gms.b.e<a> b;
        private Activity c;
        private final List<e> d = new ArrayList();

        b(g gVar) {
            this.a = gVar;
        }

        /* access modifiers changed from: private */
        public final void a(Activity activity) {
            this.c = activity;
            i();
        }

        private final void i() {
            if (this.c != null && this.b != null && a() == null) {
                try {
                    d.a(this.c);
                    c a2 = l.a((Context) this.c).a(d.a(this.c));
                    if (a2 != null) {
                        this.b.a(new a(this.a, a2));
                        for (e a3 : this.d) {
                            ((a) a()).a(a3);
                        }
                        this.d.clear();
                    }
                } catch (RemoteException e) {
                    throw new com.google.android.gms.maps.model.b(e);
                } catch (com.google.android.gms.common.d unused) {
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(com.google.android.gms.b.e<a> eVar) {
            this.b = eVar;
            i();
        }

        public final void a(e eVar) {
            if (a() != null) {
                ((a) a()).a(eVar);
            } else {
                this.d.add(eVar);
            }
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a2 = this.a.a(layoutInflater, viewGroup, bundle);
        a2.setClickable(true);
        return a2;
    }

    public void a(Activity activity) {
        super.a(activity);
        this.a.a(activity);
    }

    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.a(activity, attributeSet, bundle);
            this.a.a(activity);
            GoogleMapOptions a2 = GoogleMapOptions.a(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", a2);
            this.a.a(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.a.a(bundle);
    }

    public void a(e eVar) {
        n.b("getMapAsync must be called on the main thread.");
        this.a.a(eVar);
    }

    public void d() {
        super.d();
        this.a.b();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.d(bundle);
    }

    public void e() {
        this.a.e();
        super.e();
    }

    public void e(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.e(bundle);
        this.a.b(bundle);
    }

    public void f() {
        this.a.f();
        super.f();
    }

    public void g(Bundle bundle) {
        super.g(bundle);
    }

    public void onLowMemory() {
        this.a.h();
        super.onLowMemory();
    }

    public void p() {
        super.p();
        this.a.c();
    }

    public void q() {
        this.a.d();
        super.q();
    }

    public void r() {
        this.a.g();
        super.r();
    }
}
