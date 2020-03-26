package se.hendeby.b;

public class c extends m {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());
    private static final n f = new n("RSSCELL", "Radio signal strength", "networkFamily, networkType, operator, CI, PCI, RSS", (byte) 0, (byte) -1);
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;

    public c(long j2, int i2, String str, String str2, int i3, int i4, int i5) {
        super(f, j2, new float[0]);
        this.h = str2;
        this.g = str;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
    }

    public byte[] a() {
        return (((("" + Long.toString(this.b)) + "\t") + this.d.a) + "\t" + this.g + "\t" + String.valueOf(this.i) + "\t" + this.h + "\t" + String.valueOf(this.j) + "\t" + String.valueOf(this.k) + "\t" + String.valueOf(this.l)).getBytes();
    }
}
