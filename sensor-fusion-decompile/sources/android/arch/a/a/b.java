package android.arch.a.a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public c<K, V> a;
    private c<K, V> b;
    private WeakHashMap<Object<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* renamed from: android.arch.a.a.b$b  reason: collision with other inner class name */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {
        final K a;
        final V b;
        c<K, V> c;
        c<K, V> d;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    private class d implements Iterator<Map.Entry<K, V>> {
        private c<K, V> b;
        private boolean c;

        private d() {
            this.c = true;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.c) {
                this.c = false;
                cVar = b.this.a;
            } else {
                c<K, V> cVar2 = this.b;
                cVar = cVar2 != null ? cVar2.c : null;
            }
            this.b = cVar;
            return this.b;
        }

        public boolean hasNext() {
            if (this.c) {
                return b.this.a != null;
            }
            c<K, V> cVar = this.b;
            return (cVar == null || cVar.c == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>> {
        c<K, V> a;
        c<K, V> b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        private c<K, V> b() {
            c<K, V> cVar = this.b;
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.b;
            this.b = b();
            return cVar;
        }

        public boolean hasNext() {
            return this.b != null;
        }
    }

    public int a() {
        return this.d;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0000b bVar = new C0000b(this.b, this.a);
        this.c.put(bVar, false);
        return bVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.a;
    }

    public Map.Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.a, this.b);
        this.c.put(aVar, false);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
