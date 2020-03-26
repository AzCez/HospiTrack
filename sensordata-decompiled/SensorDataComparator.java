// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.util.Comparator;

public class SensorDataComparator implements Comparator<SensorData>
{
    @Override
    public int compare(final SensorData lhs, final SensorData rhs) {
        if (lhs.getTime() < rhs.getTime()) {
            return -1;
        }
        if (lhs.getTime() > rhs.getTime()) {
            return 1;
        }
        return 0;
    }
}
