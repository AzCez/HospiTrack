package se.hendeby.b;

public class d extends m {
    private static final n a = new n("GPS", "Geolocation", "deg N, deg E, m alt", (byte) 3, (byte) 10);

    public d(long j, float f, float f2, float f3) {
        super(a, j, new float[]{f, f2, f3});
    }
}
