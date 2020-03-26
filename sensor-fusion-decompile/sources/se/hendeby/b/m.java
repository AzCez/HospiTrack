package se.hendeby.b;

public class m {
    static final /* synthetic */ boolean e = (!m.class.desiredAssertionStatus());
    public long b;
    float[] c;
    public final n d;

    public m(n nVar, long j, float[] fArr) {
        if (fArr != null && fArr.length == 3 && (nVar.a.equals("RAWGYR") || nVar.a.equals("RAWMAG"))) {
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
        } else if (e || fArr.length == nVar.d) {
            this.c = fArr;
        } else {
            throw new AssertionError();
        }
        this.b = j;
        this.d = nVar;
    }

    public byte[] a() {
        String str = ((new String() + Long.toString(this.b)) + "\t") + this.d.a;
        for (int i = 0; i < this.d.d; i++) {
            str = (str + "\t") + Float.toString(this.c[i]);
        }
        return str.getBytes();
    }

    public float[] b() {
        return this.c;
    }
}
