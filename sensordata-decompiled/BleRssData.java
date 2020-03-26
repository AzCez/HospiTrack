// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class BleRssData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    private String name_;
    private String mac_;
    private int rss_;
    
    public BleRssData(final long time, final String name, final String mac, final int rss) {
        super(BleRssData.sensorInfo_, time, new float[0]);
        this.name_ = name;
        this.mac_ = mac;
        this.rss_ = rss;
    }
    
    public String getName() {
        return this.name_;
    }
    
    public String getMac() {
        return this.mac_;
    }
    
    public int getRSS() {
        return this.rss_;
    }
    
    @Override
    public byte[] serialize() {
        final String separator = "\t";
        String str = "";
        str += Long.toString(this.time);
        str += "\t";
        str += this.sensorInfo.tag;
        str = str + "\t" + this.name_ + "\t" + this.mac_ + "\t" + String.valueOf(this.rss_);
        return str.getBytes();
    }
    
    public static BleRssData deserialize(final String[] strs) {
        assert strs.length == 5;
        final long time = Long.valueOf(strs[0]);
        final String name = strs[2];
        final String mac = strs[3];
        final int rss = Integer.valueOf(strs[4]);
        return new BleRssData(time, name, mac, rss);
    }
    
    static {
        sensorInfo_ = new SensorInfo("RSSBLE", "BLE Radio signal strength", "MAC, Name, RSS", (byte)0, (byte)(-1));
    }
}
