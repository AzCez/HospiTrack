// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class AccData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public AccData(final long time, final float[] values) {
        super(AccData.sensorInfo_, time, values);
    }
    
    public AccData(final long time, final float x, final float y, final float z) {
        super(AccData.sensorInfo_, time, new float[] { x, y, z });
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
        sensorInfo_ = new SensorInfo("ACC", "Accelerometer data", "m/s^2", (byte)3, (byte)1);
    }
}
