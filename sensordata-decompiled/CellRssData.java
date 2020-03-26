// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

public class CellRssData extends SensorData
{
    private static final SensorInfo sensorInfo_;
    private String networkFamily_;
    private String operator_;
    private int networkType_;
    private int ci_;
    private int pci_;
    private int rss_;
    
    public CellRssData(final long time, final int networkType, final String networkFamily, final String operator, final int ci, final int pci, final int rss) {
        super(CellRssData.sensorInfo_, time, new float[0]);
        this.operator_ = operator;
        this.networkFamily_ = networkFamily;
        this.networkType_ = networkType;
        this.ci_ = ci;
        this.pci_ = pci;
        this.rss_ = rss;
    }
    
    public int getNetworkType() {
        return this.networkType_;
    }
    
    public String getNetworkFamily() {
        return this.networkFamily_;
    }
    
    public String getOperator() {
        return this.operator_;
    }
    
    public int getCI() {
        return this.ci_;
    }
    
    public int getPCI() {
        return this.pci_;
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
        str = str + "\t" + this.networkFamily_ + "\t" + String.valueOf(this.networkType_) + "\t" + this.operator_ + "\t" + String.valueOf(this.ci_) + "\t" + String.valueOf(this.pci_) + "\t" + String.valueOf(this.rss_);
        return str.getBytes();
    }
    
    public static CellRssData deserialize(final String[] strs) {
        assert strs.length == 8;
        final long time = Long.valueOf(strs[0]);
        final String networkFamily = strs[2];
        final int networkType = Integer.valueOf(strs[3]);
        final String operator = strs[4];
        final int ci = Integer.valueOf(strs[5]);
        final int pci = Integer.valueOf(strs[6]);
        final int rss = Integer.valueOf(strs[7]);
        return new CellRssData(time, networkType, networkFamily, operator, ci, pci, rss);
    }
    
    static {
        sensorInfo_ = new SensorInfo("RSSCELL", "Radio signal strength", "networkFamily, networkType, operator, CI, PCI, RSS", (byte)0, (byte)(-1));
    }
}
