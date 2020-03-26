package se.hendeby.b;

public class b extends m {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    private static final n f = new n("RSSBLE", "BLE Radio signal strength", "MAC, Name, RSS", (byte) 0, (byte) -1);
    private String g;
    private String h;
    private int i;

    public b(long j, String str, String str2, int i2) {
        super(f, j, new float[0]);
        this.g = str;
        this.h = str2;
        this.i = i2;
    }

    public byte[] a() {
        return (((("" + Long.toString(this.b)) + "\t") + this.d.a) + "\t" + this.g + "\t" + this.h + "\t" + String.valueOf(this.i)).getBytes();
    }
}
