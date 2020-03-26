package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.c.c;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class p {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    static class a {
        public g a;
        public boolean b;
        public b c;
        public g d;
        public boolean e;
        public b f;

        a() {
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    private static android.support.v4.b.a<String, String> a(int i, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        android.support.v4.b.a<String, String> aVar = new android.support.v4.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            b bVar = arrayList.get(i4);
            if (bVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (bVar.s != null) {
                    int size = bVar.s.size();
                    if (booleanValue) {
                        arrayList3 = bVar.s;
                        arrayList4 = bVar.t;
                    } else {
                        ArrayList<String> arrayList5 = bVar.s;
                        arrayList3 = bVar.t;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static Object a(g gVar, g gVar2, boolean z) {
        if (gVar == null || gVar2 == null) {
            return null;
        }
        return q.b(q.a(z ? gVar2.z() : gVar.y()));
    }

    private static Object a(g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return q.a(z ? gVar.x() : gVar.u());
    }

    private static Object a(ViewGroup viewGroup, View view, android.support.v4.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final Rect rect;
        final View view2;
        g gVar = aVar2.a;
        g gVar2 = aVar2.d;
        if (gVar != null) {
            gVar.o().setVisibility(0);
        }
        if (gVar == null || gVar2 == null) {
            return null;
        }
        boolean z = aVar2.b;
        Object a2 = aVar.isEmpty() ? null : a(gVar, gVar2, z);
        android.support.v4.b.a<String, View> b = b(aVar, a2, aVar2);
        android.support.v4.b.a<String, View> c = c(aVar, a2, aVar2);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (c != null) {
                c.clear();
            }
            a2 = null;
        } else {
            a(arrayList, b, (Collection<String>) aVar.keySet());
            a(arrayList2, c, aVar.values());
        }
        if (obj == null && obj2 == null && a2 == null) {
            return null;
        }
        b(gVar, gVar2, z, b, true);
        if (a2 != null) {
            arrayList2.add(view);
            q.a(a2, view, arrayList);
            a(a2, obj2, b, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View b2 = b(c, aVar2, obj, z);
            if (b2 != null) {
                q.a(obj, rect2);
            }
            rect = rect2;
            view2 = b2;
        } else {
            view2 = null;
            rect = null;
        }
        final g gVar3 = gVar;
        final g gVar4 = gVar2;
        final boolean z2 = z;
        final android.support.v4.b.a<String, View> aVar3 = c;
        ad.a(viewGroup, new Runnable() {
            public void run() {
                p.b(gVar3, gVar4, z2, (android.support.v4.b.a<String, View>) aVar3, false);
                View view = view2;
                if (view != null) {
                    q.a(view, rect);
                }
            }
        });
        return a2;
    }

    private static Object a(Object obj, Object obj2, Object obj3, g gVar, boolean z) {
        return (obj == null || obj2 == null || gVar == null) ? true : z ? gVar.B() : gVar.A() ? q.a(obj2, obj, obj3) : q.b(obj2, obj, obj3);
    }

    private static String a(android.support.v4.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r10.t != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        r13 = r1;
        r1 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0088, code lost:
        if (r10.I == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x008a, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.support.v4.app.b r16, android.support.v4.app.b.a r17, android.util.SparseArray<android.support.v4.app.p.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            android.support.v4.app.g r10 = r1.b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.G
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = a
            int r1 = r1.a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x007d
            switch(r1) {
                case 3: goto L_0x0053;
                case 4: goto L_0x003b;
                case 5: goto L_0x0029;
                case 6: goto L_0x0053;
                case 7: goto L_0x007d;
                default: goto L_0x0024;
            }
        L_0x0024:
            r1 = 0
        L_0x0025:
            r12 = 0
            r13 = 0
            goto L_0x0090
        L_0x0029:
            if (r20 == 0) goto L_0x0038
            boolean r1 = r10.Z
            if (r1 == 0) goto L_0x008c
            boolean r1 = r10.I
            if (r1 != 0) goto L_0x008c
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x008c
            goto L_0x008a
        L_0x0038:
            boolean r1 = r10.I
            goto L_0x008d
        L_0x003b:
            if (r20 == 0) goto L_0x004a
            boolean r1 = r10.Z
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.I
            if (r1 == 0) goto L_0x006e
        L_0x0049:
            goto L_0x006c
        L_0x004a:
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.I
            if (r1 != 0) goto L_0x006e
            goto L_0x0049
        L_0x0053:
            if (r20 == 0) goto L_0x0070
            boolean r1 = r10.t
            if (r1 != 0) goto L_0x006e
            android.view.View r1 = r10.Q
            if (r1 == 0) goto L_0x006e
            android.view.View r1 = r10.Q
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x006e
            float r1 = r10.aa
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x006e
        L_0x006c:
            r1 = 1
            goto L_0x0079
        L_0x006e:
            r1 = 0
            goto L_0x0079
        L_0x0070:
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x006e
            boolean r1 = r10.I
            if (r1 != 0) goto L_0x006e
            goto L_0x006c
        L_0x0079:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x0090
        L_0x007d:
            if (r20 == 0) goto L_0x0082
            boolean r1 = r10.Y
            goto L_0x008d
        L_0x0082:
            boolean r1 = r10.t
            if (r1 != 0) goto L_0x008c
            boolean r1 = r10.I
            if (r1 != 0) goto L_0x008c
        L_0x008a:
            r1 = 1
            goto L_0x008d
        L_0x008c:
            r1 = 0
        L_0x008d:
            r4 = r1
            r1 = 1
            goto L_0x0025
        L_0x0090:
            java.lang.Object r6 = r2.get(r11)
            android.support.v4.app.p$a r6 = (android.support.v4.app.p.a) r6
            if (r4 == 0) goto L_0x00a2
            android.support.v4.app.p$a r6 = a((android.support.v4.app.p.a) r6, (android.util.SparseArray<android.support.v4.app.p.a>) r2, (int) r11)
            r6.a = r10
            r6.b = r3
            r6.c = r0
        L_0x00a2:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            if (r14 == 0) goto L_0x00b0
            android.support.v4.app.g r1 = r14.d
            if (r1 != r10) goto L_0x00b0
            r14.d = r15
        L_0x00b0:
            android.support.v4.app.m r4 = r0.b
            int r1 = r10.k
            if (r1 >= r5) goto L_0x00c9
            int r1 = r4.l
            if (r1 < r5) goto L_0x00c9
            boolean r1 = r0.u
            if (r1 != 0) goto L_0x00c9
            r4.f(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a((android.support.v4.app.g) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00c9:
            if (r13 == 0) goto L_0x00db
            if (r14 == 0) goto L_0x00d1
            android.support.v4.app.g r1 = r14.d
            if (r1 != 0) goto L_0x00db
        L_0x00d1:
            android.support.v4.app.p$a r14 = a((android.support.v4.app.p.a) r14, (android.util.SparseArray<android.support.v4.app.p.a>) r2, (int) r11)
            r14.d = r10
            r14.e = r3
            r14.f = r0
        L_0x00db:
            if (r20 != 0) goto L_0x00e7
            if (r12 == 0) goto L_0x00e7
            if (r14 == 0) goto L_0x00e7
            android.support.v4.app.g r0 = r14.a
            if (r0 != r10) goto L_0x00e7
            r14.a = r15
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.p.a(android.support.v4.app.b, android.support.v4.app.b$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void a(b bVar, SparseArray<a> sparseArray, boolean z) {
        int size = bVar.c.size();
        for (int i = 0; i < size; i++) {
            a(bVar, bVar.c.get(i), sparseArray, false, z);
        }
    }

    private static void a(m mVar, int i, a aVar, View view, android.support.v4.b.a<String, String> aVar2) {
        Object obj;
        m mVar2 = mVar;
        a aVar3 = aVar;
        View view2 = view;
        ViewGroup viewGroup = mVar2.n.a() ? (ViewGroup) mVar2.n.a(i) : null;
        if (viewGroup != null) {
            g gVar = aVar3.a;
            g gVar2 = aVar3.d;
            boolean z = aVar3.b;
            boolean z2 = aVar3.e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a2 = a(gVar, z);
            Object b = b(gVar2, z2);
            Object obj2 = b;
            Object a3 = a(viewGroup, view, aVar2, aVar, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList, a2, b);
            if (a2 == null && a3 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> b2 = b(obj, gVar2, (ArrayList<View>) arrayList2, view2);
            ArrayList<View> b3 = b(a2, gVar, (ArrayList<View>) arrayList, view2);
            b(b3, 4);
            Object a4 = a(a2, obj, a3, gVar, z);
            if (a4 != null) {
                a(obj, gVar2, b2);
                ArrayList<String> a5 = q.a((ArrayList<View>) arrayList);
                q.a(a4, a2, b3, obj, b2, a3, arrayList);
                q.a(viewGroup, a4);
                q.a(viewGroup, arrayList2, arrayList, a5, aVar2);
                b(b3, 0);
                q.a(a3, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList);
            }
        }
    }

    static void a(m mVar, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (mVar.l >= 1 && Build.VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                b bVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(bVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(bVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(mVar.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    android.support.v4.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(mVar, keyAt, aVar, view, a2);
                    } else {
                        b(mVar, keyAt, aVar, view, a2);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.b.a<String, String> aVar, android.support.v4.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    private static void a(ViewGroup viewGroup, g gVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final g gVar2 = gVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        ad.a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    q.c(obj, view2);
                    arrayList5.addAll(p.b(obj3, gVar2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        q.b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(Object obj, g gVar, final ArrayList<View> arrayList) {
        if (gVar != null && obj != null && gVar.t && gVar.I && gVar.Z) {
            gVar.h(true);
            q.b(obj, gVar.o(), arrayList);
            ad.a(gVar.P, new Runnable() {
                public void run() {
                    p.b((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void a(Object obj, Object obj2, android.support.v4.b.a<String, View> aVar, boolean z, b bVar) {
        if (bVar.s != null && !bVar.s.isEmpty()) {
            View view = aVar.get((z ? bVar.t : bVar.s).get(0));
            q.a(obj, view);
            if (obj2 != null) {
                q.a(obj2, view);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c = aVar.c(size);
            if (collection.contains(c.a(c))) {
                arrayList.add(c);
            }
        }
    }

    private static android.support.v4.b.a<String, View> b(android.support.v4.b.a<String, String> aVar, Object obj, a aVar2) {
        ArrayList<String> arrayList;
        ai aiVar;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        g gVar = aVar2.d;
        android.support.v4.b.a<String, View> aVar3 = new android.support.v4.b.a<>();
        q.a((Map<String, View>) aVar3, gVar.o());
        b bVar = aVar2.f;
        if (aVar2.e) {
            aiVar = gVar.R();
            arrayList = bVar.t;
        } else {
            aiVar = gVar.S();
            arrayList = bVar.s;
        }
        aVar3.a(arrayList);
        if (aiVar != null) {
            aiVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(c.a(view))) {
                    aVar.put(c.a(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar3.keySet());
        }
        return aVar3;
    }

    /* access modifiers changed from: private */
    public static View b(android.support.v4.b.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        b bVar = aVar2.c;
        if (obj == null || aVar == null || bVar.s == null || bVar.s.isEmpty()) {
            return null;
        }
        return aVar.get((z ? bVar.s : bVar.t).get(0));
    }

    private static Object b(g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return q.a(z ? gVar.v() : gVar.w());
    }

    private static Object b(ViewGroup viewGroup, View view, android.support.v4.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        android.support.v4.b.a<String, String> aVar3;
        Object obj4;
        a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Object obj6 = obj2;
        final g gVar = aVar4.a;
        final g gVar2 = aVar4.d;
        Rect rect = null;
        if (gVar == null || gVar2 == null) {
            return null;
        }
        final boolean z = aVar4.b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            obj3 = null;
        } else {
            obj3 = a(gVar, gVar2, z);
            aVar3 = aVar;
        }
        android.support.v4.b.a<String, View> b = b(aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj6 == null && obj4 == null) {
            return null;
        }
        b(gVar, gVar2, z, b, true);
        if (obj4 != null) {
            rect = new Rect();
            q.a(obj4, view, arrayList3);
            a(obj4, obj6, b, aVar4.e, aVar4.f);
            if (obj5 != null) {
                q.a(obj5, rect);
            }
        } else {
            View view2 = view;
        }
        Rect rect2 = rect;
        final android.support.v4.b.a<String, String> aVar5 = aVar;
        final Object obj7 = obj4;
        final a aVar6 = aVar2;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view3 = view;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj8 = obj;
        final Rect rect3 = rect2;
        ViewGroup viewGroup2 = viewGroup;
        ad.a(viewGroup, new Runnable() {
            public void run() {
                android.support.v4.b.a a2 = p.c(aVar5, obj7, aVar6);
                if (a2 != null) {
                    arrayList4.addAll(a2.values());
                    arrayList4.add(view3);
                }
                p.b(gVar, gVar2, z, (android.support.v4.b.a<String, View>) a2, false);
                Object obj = obj7;
                if (obj != null) {
                    q.a(obj, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a3 = p.b((android.support.v4.b.a<String, View>) a2, aVar6, obj8, z);
                    if (a3 != null) {
                        q.a(a3, rect3);
                    }
                }
            }
        });
        return obj4;
    }

    /* access modifiers changed from: private */
    public static ArrayList<View> b(Object obj, g gVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View o = gVar.o();
        if (o != null) {
            q.a(arrayList2, o);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        q.a(obj, arrayList2);
        return arrayList2;
    }

    public static void b(b bVar, SparseArray<a> sparseArray, boolean z) {
        if (bVar.b.n.a()) {
            for (int size = bVar.c.size() - 1; size >= 0; size--) {
                a(bVar, bVar.c.get(size), sparseArray, true, z);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(g gVar, g gVar2, boolean z, android.support.v4.b.a<String, View> aVar, boolean z2) {
        ai R = z ? gVar2.R() : gVar.R();
        if (R != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                R.a(arrayList2, arrayList, (List<View>) null);
            } else {
                R.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static void b(m mVar, int i, a aVar, View view, android.support.v4.b.a<String, String> aVar2) {
        Object obj;
        m mVar2 = mVar;
        a aVar3 = aVar;
        View view2 = view;
        android.support.v4.b.a<String, String> aVar4 = aVar2;
        ViewGroup viewGroup = mVar2.n.a() ? (ViewGroup) mVar2.n.a(i) : null;
        if (viewGroup != null) {
            g gVar = aVar3.a;
            g gVar2 = aVar3.d;
            boolean z = aVar3.b;
            boolean z2 = aVar3.e;
            Object a2 = a(gVar, z);
            Object b = b(gVar2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList;
            Object obj2 = b;
            Object b2 = b(viewGroup, view, aVar2, aVar, arrayList, arrayList2, a2, b);
            if (a2 == null && b2 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> b3 = b(obj, gVar2, (ArrayList<View>) arrayList4, view2);
            Object obj3 = (b3 == null || b3.isEmpty()) ? null : obj;
            q.b(a2, view2);
            Object a3 = a(a2, obj3, b2, gVar, aVar3.b);
            if (a3 != null) {
                ArrayList arrayList5 = new ArrayList();
                q.a(a3, a2, arrayList5, obj3, b3, b2, arrayList3);
                a(viewGroup, gVar, view, (ArrayList<View>) arrayList3, a2, (ArrayList<View>) arrayList5, obj3, b3);
                ArrayList arrayList6 = arrayList3;
                q.a((View) viewGroup, (ArrayList<View>) arrayList6, (Map<String, String>) aVar4);
                q.a(viewGroup, a3);
                q.a(viewGroup, (ArrayList<View>) arrayList6, (Map<String, String>) aVar4);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public static android.support.v4.b.a<String, View> c(android.support.v4.b.a<String, String> aVar, Object obj, a aVar2) {
        ai aiVar;
        ArrayList<String> arrayList;
        String a2;
        g gVar = aVar2.a;
        View o = gVar.o();
        if (aVar.isEmpty() || obj == null || o == null) {
            aVar.clear();
            return null;
        }
        android.support.v4.b.a<String, View> aVar3 = new android.support.v4.b.a<>();
        q.a((Map<String, View>) aVar3, o);
        b bVar = aVar2.c;
        if (aVar2.b) {
            aiVar = gVar.S();
            arrayList = bVar.s;
        } else {
            aiVar = gVar.R();
            arrayList = bVar.t;
        }
        if (arrayList != null) {
            aVar3.a(arrayList);
        }
        if (aiVar != null) {
            aiVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(c.a(view)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, c.a(view));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }
}
