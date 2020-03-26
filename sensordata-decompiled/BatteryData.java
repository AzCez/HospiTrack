// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class BatteryData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public BatteryData(final long time, final float[] values) {
        super(BatteryData.sensorInfo_, time, values);
    }
    
    public BatteryData(final long time, final float battery, final float voltage, final float temp) {
        super(BatteryData.sensorInfo_, time, new float[] { battery, voltage, temp });
    }
    
    static {
        sensorInfo_ = new SensorInfo("BAT", "Battery level", "%, V, deg C", (byte)3, (byte)0);
    }
}
