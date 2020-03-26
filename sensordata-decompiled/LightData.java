// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class LightData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public LightData(final long time, final float[] values) {
        super(LightData.sensorInfo_, time, values);
    }
    
    public LightData(final long time, final float light) {
        super(LightData.sensorInfo_, time, new float[] { light });
    }
    
    static {
        sensorInfo_ = new SensorInfo("LGT", "Ambient light", "lx", (byte)1, (byte)14);
    }
}
