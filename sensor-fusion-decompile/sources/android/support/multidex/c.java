package android.support.multidex;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class c {

    static class a {
        long a;
        long b;

        a() {
        }
    }

    static long a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) {
        CRC32 crc32 = new CRC32();
        long j = aVar.b;
        randomAccessFile.seek(aVar.a);
        int min = (int) Math.min(16384, j);
        byte[] bArr = new byte[16384];
        while (true) {
            int read = randomAccessFile.read(bArr, 0, min);
            if (read == -1) {
                break;
            }
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            min = (int) Math.min(16384, j);
        }
        return crc32.getValue();
    }

    static a a(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - 65536;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    a aVar = new a();
                    aVar.b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    aVar.a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return aVar;
                }
                length--;
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }
}
