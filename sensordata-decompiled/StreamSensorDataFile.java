// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class StreamSensorDataFile
{
    private static final int TIMEOUT_MS = 10000;
    private static final String defaultIP = "127.0.0.1";
    private static final int defaultPort = 3400;
    
    public static void broadcastFile(final File fname, final String ip, final int port) throws UnknownHostException, IOException {
        if (!fname.canRead()) {
            System.err.println("File not found.");
        }
        final FileReader file = new FileReader(fname);
        final BufferedReader bReader = new BufferedReader(file);
        final Socket socket = new Socket(ip, port);
        socket.setReuseAddress(true);
        socket.setSoTimeout(10000);
        final OutputStream ostream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), 512));
        long sTime = -1L;
        long cTime = -1L;
        while (bReader.ready()) {
            final String line = bReader.readLine();
            final SensorData sD = SensorData.deserialize(line.getBytes());
            if (sD == null) {
                continue;
            }
            if (sTime < 0L) {
                sTime = sD.getTime();
                cTime = System.currentTimeMillis();
            }
            final long dTime = sD.getTime() - sTime;
            while (dTime > System.currentTimeMillis() - cTime) {
                try {
                    Thread.sleep(dTime - (System.currentTimeMillis() - cTime));
                }
                catch (InterruptedException ex) {}
            }
            ostream.write(sD.serialize());
            ostream.write(new byte[] { 10 });
        }
        bReader.close();
        ostream.close();
        socket.close();
    }
    
    private static void printMainSyntax() {
        System.err.println("Syntax:  StreamSensorDataFile [--ip <127.0.0.1>] [--port <3400>] [--] logfile]");
    }
    
    public static void main(final String[] args) {
        if (args.length == 0) {
            printMainSyntax();
            return;
        }
        File fname = null;
        String ip = "127.0.0.1";
        int port = 3400;
        int i = 0;
        for (boolean moreArgs = true; i < args.length || moreArgs; ++i) {
            if (args[i].equals("--ip")) {
                if (++i >= args.length) {
                    printMainSyntax();
                    return;
                }
                ip = args[i];
            }
            else if (args[i].equals("--port")) {
                if (++i >= args.length) {
                    printMainSyntax();
                    return;
                }
                port = Integer.parseInt(args[i]);
            }
            else if (args[i].equals("--")) {
                moreArgs = false;
            }
            else {
                fname = new File(args[i]);
                if (!fname.canRead()) {
                    System.err.printf("File cannot be read: ", fname.toPath());
                    return;
                }
                moreArgs = false;
            }
        }
        if (fname == null && i < args.length) {
            fname = new File(args[i]);
            if (!fname.canRead()) {
                System.err.printf("File cannot be read: ", fname.toPath());
                return;
            }
        }
        try {
            broadcastFile(fname, ip, port);
        }
        catch (UnknownHostException e) {
            System.err.println("Host could not be found, checkthe target IP.");
        }
        catch (IOException e2) {
            System.err.printf("Connection to the server could not be established.  Make sure the\nserver is started and you have set the correct target IP and port.\n", new Object[0]);
        }
    }
}
