// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.net.SocketException;
import java.util.Iterator;
import java.util.Enumeration;
import java.net.Inet4Address;
import java.util.Collections;
import java.net.NetworkInterface;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.net.InetAddress;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.net.Socket;
import java.net.ServerSocket;

public class StreamSensorDataReader extends SensorDataReader
{
    private static final int defaultPort = 3400;
    private static final int TIMEOUT_MS = 30000;
    private static final int RETRIES = 10;
    private int port_;
    private ServerSocket server_;
    private Socket socket_;
    private PriorityQueue<SensorData> data_;
    private DataCollector dataCollector_;
    private int retriesLeft_;
    private static SensorDataComparator sensorDataComp;
    
    public StreamSensorDataReader() {
        this(3400);
    }
    
    public StreamSensorDataReader(final int port) {
        this.server_ = null;
        this.socket_ = null;
        this.retriesLeft_ = 10;
        this.data_ = new PriorityQueue<SensorData>(100, StreamSensorDataReader.sensorDataComp);
        this.port_ = port;
    }
    
    @Override
    public void start() throws IOException {
        final Vector<InetAddress> bindAddr = getInterfaces(false);
        if (bindAddr.size() == 0) {
            System.err.println("ERROR:  No network interface found.");
            throw new IOException("ERROR:  No network interface found.");
        }
        this.start(bindAddr.get(0));
    }
    
    public void start(final int n) throws IOException {
        final Vector<InetAddress> bindAddr = getInterfaces(false);
        if (n < 0 || bindAddr.size() <= n) {
            System.err.println("ERROR:  The network interface found.");
            throw new IOException("ERROR:  The network interface found.");
        }
        this.start(bindAddr.get(n));
    }
    
    public void start(final InetAddress bindAddr) throws IOException {
        try {
            this.server_ = new ServerSocket(this.port_, 0, bindAddr);
            System.out.println("********************");
            System.out.printf("* SensorDataReader started on %s:%d\n", this.server_.getInetAddress().getHostAddress(), this.server_.getLocalPort());
            System.out.println("********************");
            this.server_.setSoTimeout(30000);
            this.server_.setReuseAddress(true);
            this.socket_ = this.server_.accept();
            System.out.printf("Connection accepted from %s:%d\n", this.socket_.getInetAddress().getHostAddress(), this.socket_.getPort());
            final BufferedReader bReader = new BufferedReader(new InputStreamReader(this.socket_.getInputStream()));
            (this.dataCollector_ = new DataCollector(bReader)).start();
        }
        catch (IOException e) {
            System.err.println("ERROR:  Failed to open port or no connection attempted.");
            throw e;
        }
        this.retriesLeft_ = 10;
    }
    
    @Override
    public void stop() {
        final int JOIN_TIMEOUT = 1000;
        if (this.dataCollector_ != null && this.dataCollector_.isAlive()) {
            this.dataCollector_.setStop();
            try {
                this.dataCollector_.join(1000L);
            }
            catch (InterruptedException ex) {}
            this.dataCollector_ = null;
        }
        try {
            if (this.socket_ != null) {
                this.socket_.close();
            }
        }
        catch (IOException ex2) {
            this.socket_ = null;
            try {
                if (this.server_ != null) {
                    this.server_.close();
                }
            }
            catch (IOException ex3) {}
            finally {
                this.server_ = null;
            }
        }
        finally {
            this.socket_ = null;
            try {
                if (this.server_ != null) {
                    this.server_.close();
                }
            }
            catch (IOException ex4) {
                this.server_ = null;
            }
            finally {
                this.server_ = null;
            }
        }
        this.data_.clear();
    }
    
    @Override
    protected double[] get(final long maxDiff) {
        final int WAIT_TIMEOUT = 50;
        long firstT = -1L;
        final double[] ret = new double[33];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = Double.NaN;
        }
        int count = 0;
        synchronized (this.data_) {
            while (true) {
                for (int c = 0; this.data_.isEmpty() && c < 10; ++c) {
                    try {
                        this.data_.wait(50L);
                    }
                    catch (InterruptedException ex) {}
                }
                final SensorData sD = this.data_.peek();
                if (sD == null) {
                    --this.retriesLeft_;
                    if (this.retriesLeft_ == 0) {
                        this.stop();
                    }
                    if (count > 0) {
                        final double[] array = ret;
                        final int n = 0;
                        array[n] /= count;
                    }
                    return ret;
                }
                this.retriesLeft_ = 10;
                if (firstT < 0L) {
                    firstT = sD.getTime();
                    ret[0] = 0.0;
                }
                if (firstT + maxDiff < sD.getTime()) {
                    break;
                }
                this.data_.poll();
                final int offset = sD.sensorInfo.offset;
                if (offset < 0) {
                    continue;
                }
                final float[] d = sD.getValues();
                for (int j = 0; j < d.length; ++j) {
                    ret[offset + j] = d[j];
                }
                final double[] array2 = ret;
                final int n2 = 0;
                array2[n2] += sD.getTime();
                ++count;
            }
        }
        final double[] array3 = ret;
        final int n3 = 0;
        array3[n3] /= count;
        return ret;
    }
    
    @Override
    public SensorData getSensorData() {
        final int WAIT_TIMEOUT = 50;
        synchronized (this.data_) {
            for (int c = 0; this.data_.isEmpty() && c < 10; ++c) {
                try {
                    this.data_.wait(50L);
                }
                catch (InterruptedException ex) {}
            }
            final SensorData sD = this.data_.peek();
            if (sD == null) {
                --this.retriesLeft_;
                if (this.retriesLeft_ == 0) {
                    this.stop();
                }
                return sD;
            }
            this.retriesLeft_ = 10;
            this.data_.poll();
            return sD;
        }
    }
    
    @Override
    public void reset() {
        synchronized (this.data_) {
            this.data_.clear();
        }
    }
    
    @Override
    public boolean status() {
        final boolean dcStatus = this.dataCollector_ != null && this.dataCollector_.status();
        final boolean socketStatus = this.server_ != null && this.server_.isBound() && this.socket_ != null && this.socket_.isConnected();
        return dcStatus && socketStatus;
    }
    
    private static Vector<InetAddress> getInterfaces(final boolean print) throws SocketException {
        final Vector<InetAddress> interfaces = new Vector<InetAddress>();
        final Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        if (print) {
            System.out.println("Available network interfaces");
        }
        int interfaces_nr = 0;
        for (final NetworkInterface netint : Collections.list(nets)) {
            if (!netint.isLoopback() && netint.isUp()) {
                if (netint.isVirtual()) {
                    continue;
                }
                final Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for (final InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (inetAddress instanceof Inet4Address) {
                        interfaces.add(inetAddress);
                        ++interfaces_nr;
                        if (!print) {
                            continue;
                        }
                        System.out.printf("  % 3d.\t%s (%s)\n", interfaces_nr, inetAddress.getHostAddress(), netint.getDisplayName());
                    }
                }
            }
        }
        return interfaces;
    }
    
    public static void showIPs() throws SocketException {
        getInterfaces(true);
    }
    
    static {
        StreamSensorDataReader.sensorDataComp = new SensorDataComparator();
    }
    
    private class DataCollector extends Thread
    {
        private BufferedReader bReader_;
        private boolean stop_;
        
        public DataCollector(final BufferedReader bReader) {
            this.stop_ = false;
            this.bReader_ = bReader;
        }
        
        public void setStop() {
            this.stop_ = true;
        }
        
        public boolean status() {
            return !this.stop_ && StreamSensorDataReader.this.socket_.isConnected();
        }
        
        @Override
        public void run() {
            try {
                while (!this.stop_) {
                    final String line = this.bReader_.readLine();
                    if (line == null) {
                        try {
                            Thread.sleep(1L);
                        }
                        catch (InterruptedException ex) {}
                    }
                    else {
                        final SensorData sD = SensorData.deserialize(line.getBytes());
                        if (sD == null) {
                            continue;
                        }
                        synchronized (StreamSensorDataReader.this.data_) {
                            StreamSensorDataReader.this.data_.add(sD);
                            StreamSensorDataReader.this.data_.notify();
                        }
                    }
                }
            }
            catch (IOException e) {
                this.stop_ = true;
            }
        }
    }
}
