// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class TempData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public TempData(final long time, final float[] values) {
        super(TempData.sensorInfo_, time, values);
    }
    
    public TempData(final long time, final float temp) {
        super(TempData.sensorInfo_, time, new float[] { temp });
    }
    
    static {
        sensorInfo_ = new SensorInfo("TMP", "Ambient temperature", "degrees Celsius", (byte)1, (byte)16);
    }
}
