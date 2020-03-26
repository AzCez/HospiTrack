// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class OrientData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public OrientData(final long time, final float[] values) {
        super(OrientData.sensorInfo_, time, null);
        if (values.length == 3) {
            final float w = (float)Math.sqrt(1.0f - (values[0] * values[0] + values[1] * values[1] + values[2] * values[2]));
            this.values = new float[] { w, values[0], values[1], values[2] };
        }
        else {
            this.values = new float[] { values[0], values[1], values[2], values[3] };
        }
    }
    
    public OrientData(final long time, final float w, final float x, final float y, final float z) {
        super(OrientData.sensorInfo_, time, new float[] { w, x, y, z });
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
    
    public float getW() {
        return this.values[3];
    }
    
    static {
        sensorInfo_ = new SensorInfo("ORI", "Orientation data", "", (byte)4, (byte)17);
    }
}
