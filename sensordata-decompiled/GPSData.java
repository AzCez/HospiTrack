// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class GPSData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    
    public GPSData(final long time, final float[] values) {
        super(GPSData.sensorInfo_, time, values);
    }
    
    public GPSData(final long time, final float lat, final float lon, final float z) {
        super(GPSData.sensorInfo_, time, new float[] { lat, lon, z });
    }
    
    public float getLat() {
        return this.values[0];
    }
    
    public float getLon() {
        return this.values[1];
    }
    
    public float getZ() {
        return this.values[2];
    }
    
    static {
        sensorInfo_ = new SensorInfo("GPS", "Geolocation", "deg N, deg E, m alt", (byte)3, (byte)10);
    }
}
