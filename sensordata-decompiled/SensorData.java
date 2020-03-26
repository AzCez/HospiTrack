// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class SensorData
{
    public long time;
    float[] values;
    public final SensorInfo sensorInfo;
    public static final byte DATA_FIELDS_USED = 33;
    
    public SensorData(final SensorInfo sensorInfo, final long time, final float[] values) {
        if (values != null && values.length == 3 && (sensorInfo.tag.equals("RAWGYR") || sensorInfo.tag.equals("RAWMAG"))) {
            System.arraycopy(values, 0, this.values, 0, values.length);
        }
        else {
            assert values.length == sensorInfo.nDim;
            this.values = values;
        }
        this.time = time;
        this.sensorInfo = sensorInfo;
    }
    
    public long getTime() {
        return this.time;
    }
    
    public float[] getValues() {
        return this.values;
    }
    
    public byte[] serialize() {
        final String separator = "\t";
        String str = new String();
        str += Long.toString(this.time);
        str += "\t";
        str += this.sensorInfo.tag;
        for (int i = 0; i < this.sensorInfo.nDim; ++i) {
            str += "\t";
            str += Float.toString(this.values[i]);
        }
        return str.getBytes();
    }
    
    public static SensorData deserialize(final byte[] data) {
        final String[] strs = new String(data).split("\t");
        if (strs.length < 2) {
            return null;
        }
        final Long t = Long.valueOf(strs[0]);
        final String tag = strs[1];
        if (tag.contentEquals("RSSCELL")) {
            return CellRssData.deserialize(strs);
        }
        if (tag.contentEquals("RSSWIFI")) {
            return WifiRssData.deserialize(strs);
        }
        if (tag.contains("RSSBLE")) {
            return BleRssData.deserialize(strs);
        }
        final float[] vals = new float[strs.length - 2];
        for (int i = 0; i < strs.length - 2; ++i) {
            vals[i] = Float.valueOf(strs[i + 2]);
        }
        if (tag.contentEquals("ACC")) {
            return new AccData(t, vals);
        }
        if (tag.contentEquals("GYR")) {
            return new GyrData(t, vals);
        }
        if (tag.contentEquals("MAG")) {
            return new MagData(t, vals);
        }
        if (tag.contentEquals("TMP")) {
            return new TempData(t, vals);
        }
        if (tag.contentEquals("LGT")) {
            return new LightData(t, vals);
        }
        if (tag.contentEquals("PRS")) {
            return new PressureData(t, vals);
        }
        if (tag.contentEquals("PRX")) {
            return new ProximityData(t, vals);
        }
        if (tag.contentEquals("BAT")) {
            return new BatteryData(t, vals);
        }
        if (tag.contentEquals("ORI")) {
            return new OrientData(t, vals);
        }
        if (tag.contentEquals("GPS")) {
            return new GPSData(t, vals);
        }
        if (tag.contentEquals("RAWGYR")) {
            return new RawGyrData(t, vals);
        }
        if (tag.contentEquals("RAWMAG")) {
            return new RawMagData(t, vals);
        }
        return null;
    }
}
