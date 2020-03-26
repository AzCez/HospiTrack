// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class GyrData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public GyrData(final long time, final float[] values) {
        super(GyrData.sensorInfo_, time, values);
    }
    
    public GyrData(final long time, final float x, final float y, final float z) {
        super(GyrData.sensorInfo_, time, new float[] { x, y, z });
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
    
    static {
        sensorInfo_ = new SensorInfo("GYR", "Gyroscope data", "rad/s", (byte)3, (byte)4);
    }
}
