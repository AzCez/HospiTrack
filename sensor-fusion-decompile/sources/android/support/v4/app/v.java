package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.ab;
import android.support.v4.app.ac;
import android.support.v4.app.w;
import android.support.v4.app.x;
import android.support.v4.app.y;
import android.support.v4.app.z;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class v {
    static final l a = (Build.VERSION.SDK_INT >= 26 ? new j() : Build.VERSION.SDK_INT >= 24 ? new i() : Build.VERSION.SDK_INT >= 21 ? new h() : Build.VERSION.SDK_INT >= 20 ? new g() : Build.VERSION.SDK_INT >= 19 ? new f() : Build.VERSION.SDK_INT >= 16 ? new e() : new k());

    public static class a extends aa.a {
        public static final aa.a.C0005a e = new aa.a.C0005a() {
        };
        final Bundle a;
        public int b;
        public CharSequence c;
        public PendingIntent d;
        private final ae[] f;
        private final ae[] g;
        private boolean h;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), (ae[]) null, (ae[]) null, true);
        }

        a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ae[] aeVarArr, ae[] aeVarArr2, boolean z) {
            this.b = i;
            this.c = c.d(charSequence);
            this.d = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.f = aeVarArr;
            this.g = aeVarArr2;
            this.h = z;
        }

        public int a() {
            return this.b;
        }

        public CharSequence b() {
            return this.c;
        }

        public PendingIntent c() {
            return this.d;
        }

        public Bundle d() {
            return this.a;
        }

        public boolean e() {
            return this.h;
        }

        /* renamed from: f */
        public ae[] i() {
            return this.f;
        }

        /* renamed from: g */
        public ae[] h() {
            return this.g;
        }
    }

    public static class b extends m {
        private CharSequence e;

        public b a(CharSequence charSequence) {
            this.e = c.d(charSequence);
            return this;
        }

        public void a(u uVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                ab.a(uVar, this.b, this.d, this.c, this.e);
            }
        }
    }

    public static class c {
        Bundle A;
        int B;
        int C;
        Notification D;
        RemoteViews E;
        RemoteViews F;
        RemoteViews G;
        String H;
        int I;
        String J;
        long K;
        public Notification L;
        public ArrayList<String> M;
        /* access modifiers changed from: private */
        public int N;
        public Context a;
        public CharSequence b;
        public CharSequence c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        boolean k;
        public boolean l;
        public m m;
        public CharSequence n;
        public CharSequence[] o;
        int p;
        int q;
        boolean r;
        String s;
        boolean t;
        String u;
        public ArrayList<a> v;
        boolean w;
        boolean x;
        boolean y;
        String z;

        @Deprecated
        public c(Context context) {
            this(context, (String) null);
        }

        public c(Context context, String str) {
            this.k = true;
            this.v = new ArrayList<>();
            this.w = false;
            this.B = 0;
            this.C = 0;
            this.I = 0;
            this.N = 0;
            this.L = new Notification();
            this.a = context;
            this.H = str;
            this.L.when = System.currentTimeMillis();
            this.L.audioStreamType = -1;
            this.j = 0;
            this.M = new ArrayList<>();
        }

        private void a(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.L;
                i3 = i2 | notification.flags;
            } else {
                notification = this.L;
                i3 = (i2 ^ -1) & notification.flags;
            }
            notification.flags = i3;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Notification a() {
            return v.a.a(this, b());
        }

        public c a(int i2) {
            this.L.icon = i2;
            return this;
        }

        public c a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.v.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public c a(long j2) {
            this.L.when = j2;
            return this;
        }

        public c a(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public c a(m mVar) {
            if (this.m != mVar) {
                this.m = mVar;
                m mVar2 = this.m;
                if (mVar2 != null) {
                    mVar2.a(this);
                }
            }
            return this;
        }

        public c a(CharSequence charSequence) {
            this.b = d(charSequence);
            return this;
        }

        public c a(String str) {
            this.H = str;
            return this;
        }

        public c a(boolean z2) {
            a(2, z2);
            return this;
        }

        public c b(int i2) {
            this.j = i2;
            return this;
        }

        public c b(CharSequence charSequence) {
            this.c = d(charSequence);
            return this;
        }

        public c b(boolean z2) {
            a(16, z2);
            return this;
        }

        /* access modifiers changed from: protected */
        public d b() {
            return new d();
        }

        public c c(CharSequence charSequence) {
            this.L.tickerText = d(charSequence);
            return this;
        }

        public c c(boolean z2) {
            this.w = z2;
            return this;
        }
    }

    protected static class d {
        protected d() {
        }

        public Notification a(c cVar, u uVar) {
            RemoteViews d;
            RemoteViews c;
            RemoteViews b = cVar.m != null ? cVar.m.b(uVar) : null;
            Notification b2 = uVar.b();
            if (b == null) {
                if (cVar.E != null) {
                    b = cVar.E;
                }
                if (!(Build.VERSION.SDK_INT < 16 || cVar.m == null || (c = cVar.m.c(uVar)) == null)) {
                    b2.bigContentView = c;
                }
                if (!(Build.VERSION.SDK_INT < 21 || cVar.m == null || (d = cVar.m.d(uVar)) == null)) {
                    b2.headsUpContentView = d;
                }
                return b2;
            }
            b2.contentView = b;
            b2.bigContentView = c;
            b2.headsUpContentView = d;
            return b2;
        }
    }

    static class e extends k {
        e() {
        }

        public Notification a(c cVar, d dVar) {
            Bundle a;
            c cVar2 = cVar;
            ab.a aVar = r1;
            ab.a aVar2 = new ab.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.A, cVar2.s, cVar2.t, cVar2.u, cVar2.E, cVar2.F);
            ab.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            Notification a2 = dVar.a(cVar2, aVar3);
            if (!(cVar2.m == null || (a = v.a(a2)) == null)) {
                cVar2.m.a(a);
            }
            return a2;
        }
    }

    static class f extends e {
        f() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            ac.a aVar = r1;
            ac.a aVar2 = new ac.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.k, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.M, cVar2.A, cVar2.s, cVar2.t, cVar2.u, cVar2.E, cVar2.F);
            ac.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            return dVar.a(cVar2, aVar3);
        }
    }

    static class g extends f {
        g() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            w.a aVar = r1;
            w.a aVar2 = new w.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.k, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.M, cVar2.A, cVar2.s, cVar2.t, cVar2.u, cVar2.E, cVar2.F, cVar.N);
            w.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            Notification a = dVar.a(cVar2, aVar3);
            if (cVar2.m != null) {
                cVar2.m.a(v.a(a));
            }
            return a;
        }
    }

    static class h extends g {
        h() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            x.a aVar = r1;
            x.a aVar2 = new x.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.k, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.z, cVar2.M, cVar2.A, cVar2.B, cVar2.C, cVar2.D, cVar2.s, cVar2.t, cVar2.u, cVar2.E, cVar2.F, cVar2.G, cVar.N);
            x.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            Notification a = dVar.a(cVar2, aVar3);
            if (cVar2.m != null) {
                cVar2.m.a(v.a(a));
            }
            return a;
        }
    }

    static class i extends h {
        i() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            y.a aVar = r1;
            y.a aVar2 = new y.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.k, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.z, cVar2.M, cVar2.A, cVar2.B, cVar2.C, cVar2.D, cVar2.s, cVar2.t, cVar2.u, cVar2.o, cVar2.E, cVar2.F, cVar2.G, cVar.N);
            y.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            Notification a = dVar.a(cVar2, aVar3);
            if (cVar2.m != null) {
                cVar2.m.a(v.a(a));
            }
            return a;
        }
    }

    static class j extends i {
        j() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            z.a aVar = r1;
            z.a aVar2 = new z.a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r, cVar2.k, cVar2.l, cVar2.j, cVar2.n, cVar2.w, cVar2.z, cVar2.M, cVar2.A, cVar2.B, cVar2.C, cVar2.D, cVar2.s, cVar2.t, cVar2.u, cVar2.o, cVar2.E, cVar2.F, cVar2.G, cVar2.H, cVar2.I, cVar2.J, cVar2.K, cVar2.x, cVar2.y, cVar.N);
            z.a aVar3 = aVar;
            v.a(aVar3, cVar2.v);
            if (cVar2.m != null) {
                cVar2.m.a((u) aVar3);
            }
            Notification a = dVar.a(cVar2, aVar3);
            if (cVar2.m != null) {
                cVar2.m.a(v.a(a));
            }
            return a;
        }
    }

    static class k implements l {

        public static class a implements u {
            private Notification.Builder a;

            a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
                Notification notification2 = notification;
                Context context2 = context;
                RemoteViews remoteViews2 = remoteViews;
                boolean z2 = true;
                CharSequence charSequence4 = charSequence;
                CharSequence charSequence5 = charSequence2;
                CharSequence charSequence6 = charSequence3;
                PendingIntent pendingIntent3 = pendingIntent;
                Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
                if ((notification2.flags & 128) != 0) {
                    PendingIntent pendingIntent4 = pendingIntent2;
                } else {
                    PendingIntent pendingIntent5 = pendingIntent2;
                    z2 = false;
                }
                Notification.Builder fullScreenIntent = deleteIntent.setFullScreenIntent(pendingIntent2, z2);
                Bitmap bitmap2 = bitmap;
                int i4 = i;
                this.a = fullScreenIntent.setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
            }

            public Notification.Builder a() {
                return this.a;
            }

            public Notification b() {
                return this.a.getNotification();
            }
        }

        k() {
        }

        public Notification a(c cVar, d dVar) {
            c cVar2 = cVar;
            return dVar.a(cVar2, new a(cVar2.a, cVar2.L, cVar2.b, cVar2.c, cVar2.h, cVar2.f, cVar2.i, cVar2.d, cVar2.e, cVar2.g, cVar2.p, cVar2.q, cVar2.r));
        }
    }

    interface l {
        Notification a(c cVar, d dVar);
    }

    public static abstract class m {
        protected c a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        public void a(Bundle bundle) {
        }

        public void a(u uVar) {
        }

        public void a(c cVar) {
            if (this.a != cVar) {
                this.a = cVar;
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
            }
        }

        public RemoteViews b(u uVar) {
            return null;
        }

        public RemoteViews c(u uVar) {
            return null;
        }

        public RemoteViews d(u uVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return ab.a(notification);
        }
        return null;
    }

    static void a(t tVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            tVar.a(it.next());
        }
    }
}
