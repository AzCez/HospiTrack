package android.support.v4.b;

public class g<F, S> {
    public final F a;
    public final S b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a(gVar.a, this.a) && a(gVar.b, this.b);
    }

    public int hashCode() {
        F f = this.a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}
