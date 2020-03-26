package se.hendeby.b;

public class h extends m {
    private static final n a = new n("ORI", "Orientation data", "", (byte) 4, (byte) 17);

    public h(long j, float[] fArr) {
        super(a, j, (float[]) null);
        if (fArr.length == 3) {
            this.c = new float[]{(float) Math.sqrt((double) (1.0f - (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2])))), fArr[0], fArr[1], fArr[2]};
            return;
        }
        this.c = new float[]{fArr[0], fArr[1], fArr[2], fArr[3]};
    }
}
