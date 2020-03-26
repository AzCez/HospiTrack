// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;

public class FileSensorDataReader extends SensorDataReader
{
    File file_;
    BufferedReader bReader_;
    SensorData sData_;
    private Map<String, Integer> phoneId_;
    private Map<String, Integer> bssidId_;
    private Map<String, Integer> ssidId_;
    
    public FileSensorDataReader(final String fname) throws IOException {
        this.file_ = null;
        this.sData_ = null;
        this.phoneId_ = new HashMap<String, Integer>();
        this.bssidId_ = new HashMap<String, Integer>();
        this.ssidId_ = new HashMap<String, Integer>();
        this.file_ = new File(fname);
    }
    
    @Override
    public void start() throws IOException {
        if (this.bReader_ != null) {
            return;
        }
        final FileReader f = new FileReader(this.file_);
        this.bReader_ = new BufferedReader(f);
        final String line = this.bReader_.readLine();
        if (line != null) {
            this.sData_ = SensorData.deserialize(line.getBytes());
        }
    }
    
    @Override
    public void stop() throws IOException {
        if (this.bReader_ == null) {
            return;
        }
        this.bReader_.close();
        this.bReader_ = null;
        this.sData_ = null;
    }
    
    @Override
    protected double[] get(final long maxDiff) {
        final double[] ret = new double[33];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = Double.NaN;
        }
        if (this.sData_ == null) {
            return ret;
        }
        long firstT = this.sData_.getTime();
        ret[0] = 0.0;
        int count = 0;
        try {
            while (this.sData_ != null && firstT + maxDiff >= this.sData_.getTime()) {
                final int offset = this.sData_.sensorInfo.offset;
                if (offset >= 0) {
                    final float[] d = this.sData_.getValues();
                    for (int j = 0; j < d.length; ++j) {
                        ret[offset + j] = d[j];
                    }
                    ++count;
                    final double[] array = ret;
                    final int n = 0;
                    array[n] += this.sData_.getTime();
                }
                final String line = this.bReader_.readLine();
                if (line != null) {
                    this.sData_ = SensorData.deserialize(line.getBytes());
                    if (count != 0) {
                        continue;
                    }
                    firstT = this.sData_.getTime();
                }
                else {
                    this.sData_ = null;
                }
            }
        }
        catch (IOException e) {
            this.sData_ = null;
        }
        final double[] array2 = ret;
        final int n2 = 0;
        array2[n2] /= count;
        return ret;
    }
    
    @Override
    public SensorData getSensorData() {
        try {
            final String line = this.bReader_.readLine();
            if (line != null) {
                this.sData_ = SensorData.deserialize(line.getBytes());
            }
        }
        catch (IOException e) {
            this.sData_ = null;
        }
        return this.sData_;
    }
    
    @Override
    public void reset() {
        try {
            this.stop();
            this.start();
        }
        catch (IOException ex) {}
    }
    
    @Override
    public boolean status() {
        return this.bReader_ != null && this.sData_ != null;
    }
    
    public String getCellId(final int id) {
        for (final Map.Entry<String, Integer> entry : this.phoneId_.entrySet()) {
            if (id == entry.getValue()) {
                return entry.getKey();
            }
        }
        return "";
    }
    
    public double[][] getAllCellRss() {
        this.reset();
        final List<CellRssData> data = new ArrayList<CellRssData>();
        try {
            while (this.bReader_.ready()) {
                final String line = this.bReader_.readLine();
                if (line.isEmpty()) {
                    break;
                }
                final SensorData tmp = SensorData.deserialize(line.getBytes());
                if (tmp == null || !(tmp instanceof CellRssData)) {
                    continue;
                }
                final CellRssData pd = (CellRssData)tmp;
                data.add(pd);
                if (this.phoneId_.containsKey(pd.getOperator())) {
                    continue;
                }
                this.phoneId_.put(pd.getOperator(), this.phoneId_.size());
            }
        }
        catch (IOException ex) {}
        final double[][] mat = new double[data.size()][7];
        int i = 0;
        for (final CellRssData d : data) {
            mat[i][0] = (double)d.time;
            if (d.getNetworkFamily().contentEquals("GSM")) {
                mat[i][1] = 0.0;
            }
            else if (d.getNetworkFamily().contentEquals("CDMA")) {
                mat[i][1] = 1.0;
            }
            else if (d.getNetworkFamily().contentEquals("WCDMA")) {
                mat[i][1] = 2.0;
            }
            else if (d.getNetworkFamily().contentEquals("LTE")) {
                mat[i][1] = 3.0;
            }
            mat[i][2] = d.getNetworkType();
            mat[i][3] = this.phoneId_.get(d.getOperator());
            mat[i][4] = d.getCI();
            mat[i][5] = d.getPCI();
            mat[i][6] = d.getRSS();
            ++i;
        }
        return mat;
    }
    
    public String getBssidId(final int id) {
        for (final Map.Entry<String, Integer> entry : this.bssidId_.entrySet()) {
            if (id == entry.getValue()) {
                return entry.getKey();
            }
        }
        return "";
    }
    
    public String getSsidId(final int id) {
        for (final Map.Entry<String, Integer> entry : this.ssidId_.entrySet()) {
            if (id == entry.getValue()) {
                return entry.getKey();
            }
        }
        return "";
    }
    
    public double[][] getAllWifiRss() {
        this.reset();
        final List<WifiRssData> data = new ArrayList<WifiRssData>();
        try {
            while (this.bReader_.ready()) {
                final String line = this.bReader_.readLine();
                final SensorData tmp = SensorData.deserialize(line.getBytes());
                if (tmp != null && tmp instanceof WifiRssData) {
                    final WifiRssData wd = (WifiRssData)tmp;
                    data.add(wd);
                    if (!this.bssidId_.containsKey(wd.getBssid())) {
                        this.bssidId_.put(wd.getBssid(), this.bssidId_.size());
                    }
                    if (this.ssidId_.containsKey(wd.getSsid())) {
                        continue;
                    }
                    this.ssidId_.put(wd.getSsid(), this.ssidId_.size());
                }
            }
        }
        catch (IOException ex) {}
        final double[][] mat = new double[data.size()][5];
        int i = 0;
        for (final WifiRssData d : data) {
            mat[i][0] = (double)d.time;
            mat[i][1] = this.bssidId_.get(d.getBssid());
            mat[i][2] = this.ssidId_.get(d.getSsid());
            mat[i][3] = d.getFreq();
            mat[i][4] = d.getRss();
            ++i;
        }
        return mat;
    }
}
