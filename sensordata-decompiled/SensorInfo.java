// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class SensorInfo
{
    public final String tag;
    public final String description;
    public final String unit;
    public final byte nDim;
    public final byte offset;
    
    public SensorInfo(final String tag, final String description, final String unit, final byte nDim, final byte offset) {
        assert offset + nDim < 33;
        this.tag = tag;
        this.description = description;
        this.unit = unit;
        this.nDim = nDim;
        this.offset = offset;
    }
}
