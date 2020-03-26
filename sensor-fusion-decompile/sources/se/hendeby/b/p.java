package se.hendeby.b;

public class p extends m {
    static final /* synthetic */ boolean a = (!p.class.desiredAssertionStatus());
    private static final n f = new n("RSSWIFI", "WiFi Radio signal strength", "BSSID, SSID, frequency, RSS", (byte) 0, (byte) -1);
    private String g;
    private String h;
    private int i;
    private int j;

    public p(long j2, String str, String str2, int i2, int i3) {
        super(f, j2, new float[0]);
        this.g = str;
        this.h = str2;
        this.i = i2;
        this.j = i3;
    }

    public byte[] a() {
        return (((("" + Long.toString(this.b)) + "\t") + this.d.a) + "\t" + this.g + "\t" + this.h + "\t" + this.i + "\t" + this.j).getBytes();
    }
}
