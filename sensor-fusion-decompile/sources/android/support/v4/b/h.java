package android.support.v4.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class h<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public h() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public h(int i) {
        if (i == 0) {
            this.f = c.a;
            this.g = c.c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
        }
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (d != null) {
                    Object[] objArr = d;
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (b != null) {
                    Object[] objArr2 = b;
                    this.g = objArr2;
                    b = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[(i << 1)];
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a = a(this.f, i, 0);
        if (a < 0 || this.g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f[i3] == 0) {
            if (this.g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a = a(this.f, i2, i);
        if (a < 0 || obj.equals(this.g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f[i4] == i) {
            if (obj.equals(this.g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.g;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public void a(int i) {
        int i2 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public K b(int i) {
        return this.g[i << 1];
    }

    public V c(int i) {
        return this.g[(i << 1) + 1];
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        int i2;
        V[] vArr = this.g;
        int i3 = i << 1;
        V v = vArr[i3 + 1];
        int i4 = this.h;
        if (i4 <= 1) {
            a(this.f, (Object[]) vArr, i4);
            this.f = c.a;
            this.g = c.c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f;
            int i5 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i2) {
                    int[] iArr2 = this.f;
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, iArr2, i, i7);
                    Object[] objArr = this.g;
                    System.arraycopy(objArr, i6 << 1, objArr, i3, i7 << 1);
                }
                Object[] objArr2 = this.g;
                int i8 = i2 << 1;
                objArr2[i8] = null;
                objArr2[i8 + 1] = null;
            } else {
                if (i4 > 8) {
                    i5 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.f;
                Object[] objArr3 = this.g;
                e(i5);
                if (i4 == this.h) {
                    if (i > 0) {
                        System.arraycopy(iArr3, 0, this.f, 0, i);
                        System.arraycopy(objArr3, 0, this.g, 0, i3);
                    }
                    if (i < i2) {
                        int i9 = i + 1;
                        int i10 = i2 - i;
                        System.arraycopy(iArr3, i9, this.f, i, i10);
                        System.arraycopy(objArr3, i9 << 1, this.g, i3, i10 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i4 == this.h) {
            this.h = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (size() != hVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.h) {
                try {
                    Object b2 = b(i);
                    Object c2 = c(i);
                    Object obj2 = hVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !hVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.h) {
                try {
                    Object b3 = b(i2);
                    Object c3 = c(i2);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return this.g[(a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.h;
        if (k == null) {
            i2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.g;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        if (i3 >= this.f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i6);
            if (i3 == this.h) {
                int[] iArr2 = this.f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.g, 0, objArr.length);
                }
                a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.h - i5) << 1);
        }
        int i8 = this.h;
        if (i3 == i8) {
            int[] iArr4 = this.f;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.g;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.h = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return d(a);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b2 = b(i);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
