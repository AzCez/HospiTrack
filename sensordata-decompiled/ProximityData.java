// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class ProximityData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public ProximityData(final long time, final float[] values) {
        super(ProximityData.sensorInfo_, time, values);
    }
    
    public ProximityData(final long time, final float dist) {
        super(ProximityData.sensorInfo_, time, new float[] { dist });
    }
    
    static {
        sensorInfo_ = new SensorInfo("PRX", "Proximity distance", "cm", (byte)1, (byte)15);
    }
}
