package android.support.v4.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    static Object[] a;
    static int b;
    static Object[] c;
    static int d;
    private static final int[] j = new int[0];
    private static final Object[] k = new Object[0];
    final boolean e;
    int[] f;
    Object[] g;
    int h;
    f<E, E> i;

    public b() {
        this(0, false);
    }

    public b(int i2, boolean z) {
        this.e = z;
        if (i2 == 0) {
            this.f = j;
            this.g = k;
        } else {
            d(i2);
        }
        this.h = 0;
    }

    public b(Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }

    private int a() {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f, i2, 0);
        if (a2 < 0 || this.g[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f[i3] == 0) {
            if (this.g[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f[i4] == 0) {
            if (this.g[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int a(Object obj, int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f, i3, i2);
        if (a2 < 0 || obj.equals(this.g[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f[i4] == i2) {
            if (obj.equals(this.g[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f[i5] == i2) {
            if (obj.equals(this.g[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    c = objArr;
                    d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (b < 10) {
                    objArr[0] = a;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    a = objArr;
                    b++;
                }
            }
        }
    }

    private f<E, E> b() {
        if (this.i == null) {
            this.i = new f<E, E>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return b.this.h;
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Object a(int i, int i2) {
                    return b.this.g[i];
                }

                /* access modifiers changed from: protected */
                public E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void a(int i) {
                    b.this.c(i);
                }

                /* access modifiers changed from: protected */
                public void a(E e, E e2) {
                    b.this.add(e);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void c() {
                    b.this.clear();
                }
            };
        }
        return this.i;
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (c != null) {
                    Object[] objArr = c;
                    this.g = objArr;
                    c = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    d--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (a != null) {
                    Object[] objArr2 = a;
                    this.g = objArr2;
                    a = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    b--;
                    return;
                }
            }
        }
        this.f = new int[i2];
        this.g = new Object[i2];
    }

    public int a(Object obj) {
        if (obj == null) {
            return a();
        }
        return a(obj, this.e ? System.identityHashCode(obj) : obj.hashCode());
    }

    public void a(int i2) {
        int[] iArr = this.f;
        if (iArr.length < i2) {
            Object[] objArr = this.g;
            d(i2);
            int i3 = this.h;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i3);
                System.arraycopy(objArr, 0, this.g, 0, this.h);
            }
            a(iArr, objArr, this.h);
        }
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int identityHashCode = this.e ? System.identityHashCode(e2) : e2.hashCode();
            i2 = identityHashCode;
            i3 = a(e2, identityHashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ -1;
        int i5 = this.h;
        if (i5 >= this.f.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            d(i6);
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            a(iArr, objArr, this.h);
        }
        int i7 = this.h;
        if (i4 < i7) {
            int[] iArr3 = this.f;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, i4, objArr2, i8, this.h - i4);
        }
        this.f[i4] = i2;
        this.g[i4] = e2;
        this.h++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.h + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public E b(int i2) {
        return this.g[i2];
    }

    public E c(int i2) {
        E[] eArr = this.g;
        E e2 = eArr[i2];
        int i3 = this.h;
        if (i3 <= 1) {
            a(this.f, eArr, i3);
            this.f = j;
            this.g = k;
            this.h = 0;
        } else {
            int[] iArr = this.f;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                this.h--;
                int i5 = this.h;
                if (i2 < i5) {
                    int[] iArr2 = this.f;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr = this.g;
                    System.arraycopy(objArr, i6, objArr, i2, this.h - i2);
                }
                this.g[this.h] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f;
                Object[] objArr2 = this.g;
                d(i4);
                this.h--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f, 0, i2);
                    System.arraycopy(objArr2, 0, this.g, 0, i2);
                }
                int i7 = this.h;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f, i2, i7 - i2);
                    System.arraycopy(objArr2, i8, this.g, i2, this.h - i2);
                }
            }
        }
        return e2;
    }

    public void clear() {
        int i2 = this.h;
        if (i2 != 0) {
            a(this.f, this.g, i2);
            this.f = j;
            this.g = k;
            this.h = 0;
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.h) {
                try {
                    if (!set.contains(b(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f;
        int i2 = this.h;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean remove(Object obj) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        c(a2);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.h - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.g[i2])) {
                c(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.h;
    }

    public Object[] toArray() {
        int i2 = this.h;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.g, 0, objArr, 0, i2);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.h) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.h);
        }
        System.arraycopy(this.g, 0, tArr, 0, this.h);
        int length = tArr.length;
        int i2 = this.h;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
