package android.support.v4.b;

public class i<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public i() {
        this(10);
    }

    public i(int i) {
        Object[] objArr;
        this.b = false;
        if (i == 0) {
            this.c = c.a;
            objArr = c.c;
        } else {
            int a2 = c.a(i);
            this.c = new int[a2];
            objArr = new Object[a2];
        }
        this.d = objArr;
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    /* renamed from: a */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            try {
                iVar.c = (int[]) this.c.clone();
                iVar.d = (Object[]) this.d.clone();
                return iVar;
            } catch (CloneNotSupportedException unused) {
                return iVar;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, (Object) null);
    }

    public E a(int i, E e2) {
        int a2 = c.a(this.c, this.e, i);
        if (a2 >= 0) {
            E[] eArr = this.d;
            if (eArr[a2] != a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.c
            int r1 = r3.e
            int r4 = android.support.v4.b.c.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.d
            r1 = r0[r4]
            java.lang.Object r2 = a
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.b = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.i.b(int):void");
    }

    public void b(int i, E e2) {
        int a2 = c.a(this.c, this.e, i);
        if (a2 >= 0) {
            this.d[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        if (i2 < this.e) {
            Object[] objArr = this.d;
            if (objArr[i2] == a) {
                this.c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.b && this.e >= this.c.length) {
            d();
            i2 = c.a(this.c, this.e, i) ^ -1;
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int a3 = c.a(i3 + 1);
            int[] iArr = new int[a3];
            Object[] objArr2 = new Object[a3];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = e2;
        this.e++;
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int i) {
        b(i);
    }

    public int d(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E e(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public int f(int i) {
        if (this.b) {
            d();
        }
        return c.a(this.c, this.e, i);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(d(i));
            sb.append('=');
            Object e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
