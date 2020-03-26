// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class PressureData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public PressureData(final long time, final float[] values) {
        super(PressureData.sensorInfo_, time, values);
    }
    
    public PressureData(final long time, final float pressure) {
        super(PressureData.sensorInfo_, time, new float[] { pressure });
    }
    
    static {
        sensorInfo_ = new SensorInfo("PRS", "Atmospheric pressure", "hPa", (byte)1, (byte)13);
    }
}
