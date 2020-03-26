package android.arch.lifecycle;

import android.arch.lifecycle.b;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class d extends b {
    private android.arch.a.a.a<Object, a> a = new android.arch.a.a.a<>();
    private b.C0001b b;
    private final c c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<b.C0001b> g = new ArrayList<>();

    /* renamed from: android.arch.lifecycle.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[b.a.values().length];
        static final /* synthetic */ int[] b = new int[b.C0001b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        static {
            /*
                android.arch.lifecycle.b$b[] r0 = android.arch.lifecycle.b.C0001b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r0 = 1
                int[] r1 = b     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.arch.lifecycle.b$b r2 = android.arch.lifecycle.b.C0001b.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001f }
                android.arch.lifecycle.b$b r3 = android.arch.lifecycle.b.C0001b.CREATED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x002a }
                android.arch.lifecycle.b$b r4 = android.arch.lifecycle.b.C0001b.STARTED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.arch.lifecycle.b$b r5 = android.arch.lifecycle.b.C0001b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.arch.lifecycle.b$b r6 = android.arch.lifecycle.b.C0001b.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                android.arch.lifecycle.b$a[] r5 = android.arch.lifecycle.b.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                a = r5
                int[] r5 = a     // Catch:{ NoSuchFieldError -> 0x0053 }
                android.arch.lifecycle.b$a r6 = android.arch.lifecycle.b.a.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x005d }
                android.arch.lifecycle.b$a r5 = android.arch.lifecycle.b.a.ON_STOP     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0067 }
                android.arch.lifecycle.b$a r1 = android.arch.lifecycle.b.a.ON_START     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0071 }
                android.arch.lifecycle.b$a r1 = android.arch.lifecycle.b.a.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x007b }
                android.arch.lifecycle.b$a r1 = android.arch.lifecycle.b.a.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0086 }
                android.arch.lifecycle.b$a r1 = android.arch.lifecycle.b.a.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0091 }
                android.arch.lifecycle.b$a r1 = android.arch.lifecycle.b.a.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.d.AnonymousClass1.<clinit>():void");
        }
    }

    static class a {
        b.C0001b a;
        a b;

        /* access modifiers changed from: package-private */
        public void a(c cVar, b.a aVar) {
            b.C0001b b2 = d.b(aVar);
            this.a = d.a(this.a, b2);
            this.b.a(cVar, aVar);
            this.a = b2;
        }
    }

    public d(c cVar) {
        this.c = cVar;
        this.b = b.C0001b.INITIALIZED;
    }

    static b.C0001b a(b.C0001b bVar, b.C0001b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private boolean a() {
        if (this.a.a() == 0) {
            return true;
        }
        b.C0001b bVar = this.a.d().getValue().a;
        b.C0001b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    static b.C0001b b(b.a aVar) {
        switch (AnonymousClass1.a[aVar.ordinal()]) {
            case f.a.MapAttrs_cameraBearing /*1*/:
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return b.C0001b.CREATED;
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
            case f.a.MapAttrs_cameraTargetLat /*4*/:
                return b.C0001b.STARTED;
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                return b.C0001b.RESUMED;
            case f.a.MapAttrs_cameraTilt /*6*/:
                return b.C0001b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b() {
        ArrayList<b.C0001b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void b(b.C0001b bVar) {
        this.g.add(bVar);
    }

    private static b.a c(b.C0001b bVar) {
        switch (AnonymousClass1.b[bVar.ordinal()]) {
            case f.a.MapAttrs_cameraBearing /*1*/:
                throw new IllegalArgumentException();
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return b.a.ON_DESTROY;
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return b.a.ON_STOP;
            case f.a.MapAttrs_cameraTargetLat /*4*/:
                return b.a.ON_PAUSE;
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void c() {
        android.arch.a.a.b<K, V>.d c2 = this.a.c();
        while (c2.hasNext() && !this.f) {
            Map.Entry entry = (Map.Entry) c2.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.a(entry.getKey())) {
                b(aVar.a);
                aVar.a(this.c, d(aVar.a));
                b();
            }
        }
    }

    private static b.a d(b.C0001b bVar) {
        switch (AnonymousClass1.b[bVar.ordinal()]) {
            case f.a.MapAttrs_cameraBearing /*1*/:
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                return b.a.ON_CREATE;
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return b.a.ON_START;
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return b.a.ON_RESUME;
            case f.a.MapAttrs_cameraTargetLat /*4*/:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void d() {
        Iterator<Map.Entry<Object, a>> b2 = this.a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry next = b2.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.b) > 0 && !this.f && this.a.a(next.getKey())) {
                b.a c2 = c(aVar.a);
                b(b(c2));
                aVar.a(this.c, c2);
                b();
            }
        }
    }

    private void e() {
        while (!a()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
                d();
            }
            Map.Entry<Object, a> e2 = this.a.e();
            if (!this.f && e2 != null && this.b.compareTo(e2.getValue().a) > 0) {
                c();
            }
        }
        this.f = false;
    }

    public void a(b.a aVar) {
        this.b = b(aVar);
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        e();
        this.e = false;
    }

    public void a(b.C0001b bVar) {
        this.b = bVar;
    }
}
