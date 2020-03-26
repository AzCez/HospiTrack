// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class RawGyrData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public RawGyrData(final long time, final float[] values) {
        super(RawGyrData.sensorInfo_, time, values);
    }
    
    public RawGyrData(final long time, final float x, final float y, final float z, final float bx, final float by, final float bz) {
        super(RawGyrData.sensorInfo_, time, new float[] { x, y, z, bx, by, bz });
    }
    
    public float getX() {
        return this.values[0];
    }
    
    public float getY() {
        return this.values[1];
    }
    
    public float getZ() {
        return this.values[2];
    }
    
    public float getBX() {
        return this.values[3];
    }
    
    public float getBY() {
        return this.values[4];
    }
    
    public float getBZ() {
        return this.values[5];
    }
    
    static {
        sensorInfo_ = new SensorInfo("RAWGYR", "Raw gyroscope data", "rad/s", (byte)6, (byte)21);
    }
}
