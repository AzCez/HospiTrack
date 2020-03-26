// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.io.IOException;
import java.util.ArrayList;

public abstract class SensorDataReader
{
    protected abstract double[] get(final long p0);
    
    public double[][] getAll(final long maxDiff) {
        final ArrayList<double[]> list = new ArrayList<double[]>();
        double[] next;
        for (next = this.get(maxDiff); !Double.isNaN(next[0]); next = this.get(maxDiff)) {
            list.add(next);
        }
        final double[][] ret = new double[list.size()][next.length];
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < next.length; ++j) {
                ret[i][j] = list.get(i)[j];
            }
        }
        return ret;
    }
    
    public double[][] getNext(final long maxDiff) {
        final double[] next = this.get(maxDiff);
        final double[][] ret = new double[1][next.length];
        for (int i = 0; i < next.length; ++i) {
            ret[0][i] = next[i];
        }
        return ret;
    }
    
    public abstract SensorData getSensorData();
    
    public abstract void reset();
    
    public abstract void start() throws IOException;
    
    public abstract boolean status();
    
    public abstract void stop() throws IOException;
    
    @Override
    protected void finalize() throws Throwable {
        this.stop();
    }
}
