// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class WifiRssData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    private String bssid_;
    private String ssid_;
    private int freq_;
    private int rss_;
    
    public WifiRssData(final long time, final String bssid, final String ssid, final int freq, final int rss) {
        super(WifiRssData.sensorInfo_, time, new float[0]);
        this.bssid_ = bssid;
        this.ssid_ = ssid;
        this.freq_ = freq;
        this.rss_ = rss;
    }
    
    public String getBssid() {
        return this.bssid_;
    }
    
    public String getSsid() {
        return this.ssid_;
    }
    
    public int getFreq() {
        return this.freq_;
    }
    
    public int getRss() {
        return this.rss_;
    }
    
    @Override
    public byte[] serialize() {
        final String separator = "\t";
        String str = "";
        str += Long.toString(this.time);
        str += "\t";
        str += this.sensorInfo.tag;
        str = str + "\t" + this.bssid_ + "\t" + this.ssid_ + "\t" + this.freq_ + "\t" + this.rss_;
        return str.getBytes();
    }
    
    public static WifiRssData deserialize(final String[] strs) {
        assert strs.length == 6;
        final long time = Long.valueOf(strs[0]);
        final String bssid = strs[2];
        final String ssid = strs[3];
        final int freq = Integer.valueOf(strs[4]);
        final int rss = Integer.valueOf(strs[5]);
        return new WifiRssData(time, bssid, ssid, freq, rss);
    }
    
    static {
        sensorInfo_ = new SensorInfo("RSSWIFI", "WiFi Radio signal strength", "BSSID, SSID, frequency, RSS", (byte)0, (byte)(-1));
    }
}
