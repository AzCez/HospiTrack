package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b {

    private static class a extends File {
        public long a = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static List<a> a(Context context, File file, File file2, String str) {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = file.getName() + ".classes";
        SharedPreferences a2 = a(context);
        int i = a2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            a aVar = new a(file2, str3 + i2 + ".zip");
            if (aVar.isFile()) {
                aVar.a = b(aVar);
                long j = a2.getLong(str2 + "dex.crc." + i2, -1);
                long j2 = a2.getLong(str2 + "dex.time." + i2, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = a2;
                    if (j == aVar.a) {
                        arrayList.add(aVar);
                        i2++;
                        a2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.a);
            }
            throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0117 A[SYNTHETIC, Splitter:B:41:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<? extends java.io.File> a(android.content.Context r14, java.io.File r15, java.io.File r16, java.lang.String r17, boolean r18) {
        /*
            r2 = r17
            r0 = r18
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "MultiDexExtractor.load("
            r3.append(r4)
            java.lang.String r4 = r15.getPath()
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = ", "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r1, r3)
            long r5 = b(r15)
            java.io.File r8 = new java.io.File
            java.lang.String r1 = "MultiDex.lock"
            r3 = r16
            r8.<init>(r3, r1)
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r9.<init>(r8, r1)
            r10 = 0
            java.nio.channels.FileChannel r11 = r9.getChannel()     // Catch:{ all -> 0x0112 }
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r4.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r7 = "Blocking on lock "
            r4.append(r7)     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r8.getPath()     // Catch:{ all -> 0x010f }
            r4.append(r7)     // Catch:{ all -> 0x010f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x010f }
            android.util.Log.i(r1, r4)     // Catch:{ all -> 0x010f }
            java.nio.channels.FileLock r12 = r11.lock()     // Catch:{ all -> 0x010f }
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010d }
            r4.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r7 = r8.getPath()     // Catch:{ all -> 0x010d }
            r4.append(r7)     // Catch:{ all -> 0x010d }
            java.lang.String r7 = " locked"
            r4.append(r7)     // Catch:{ all -> 0x010d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x010d }
            android.util.Log.i(r1, r4)     // Catch:{ all -> 0x010d }
            if (r0 != 0) goto L_0x00ad
            r1 = r14
            r4 = r15
            boolean r0 = a((android.content.Context) r14, (java.io.File) r15, (long) r5, (java.lang.String) r2)     // Catch:{ all -> 0x010d }
            if (r0 != 0) goto L_0x00af
            java.util.List r0 = a((android.content.Context) r14, (java.io.File) r15, (java.io.File) r16, (java.lang.String) r17)     // Catch:{ IOException -> 0x0094 }
        L_0x0092:
            r1 = r0
            goto L_0x00bf
        L_0x0094:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "MultiDex"
            java.lang.String r13 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
            android.util.Log.w(r0, r13, r7)     // Catch:{ all -> 0x010d }
            java.util.List r0 = a((java.io.File) r15, (java.io.File) r16)     // Catch:{ all -> 0x010d }
            long r3 = a((java.io.File) r15)     // Catch:{ all -> 0x010d }
        L_0x00a5:
            r1 = r14
            r2 = r17
            r7 = r0
            a((android.content.Context) r1, (java.lang.String) r2, (long) r3, (long) r5, (java.util.List<android.support.multidex.b.a>) r7)     // Catch:{ all -> 0x010d }
            goto L_0x0092
        L_0x00ad:
            r1 = r14
            r4 = r15
        L_0x00af:
            java.lang.String r0 = "MultiDex"
            java.lang.String r7 = "Detected that extraction must be performed."
            android.util.Log.i(r0, r7)     // Catch:{ all -> 0x010d }
            java.util.List r0 = a((java.io.File) r15, (java.io.File) r16)     // Catch:{ all -> 0x010d }
            long r3 = a((java.io.File) r15)     // Catch:{ all -> 0x010d }
            goto L_0x00a5
        L_0x00bf:
            if (r12 == 0) goto L_0x00e1
            r12.release()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00e1
        L_0x00c5:
            r0 = move-exception
            java.lang.String r2 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to release lock on "
            r3.append(r4)
            java.lang.String r4 = r8.getPath()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            goto L_0x00e2
        L_0x00e1:
            r0 = r10
        L_0x00e2:
            if (r11 == 0) goto L_0x00e7
            a((java.io.Closeable) r11)
        L_0x00e7:
            a((java.io.Closeable) r9)
            if (r0 != 0) goto L_0x010c
            java.lang.String r0 = "MultiDex"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "load found "
            r2.append(r3)
            int r3 = r1.size()
            r2.append(r3)
            java.lang.String r3 = " secondary dex files"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
            return r1
        L_0x010c:
            throw r0
        L_0x010d:
            r0 = move-exception
            goto L_0x0115
        L_0x010f:
            r0 = move-exception
            r12 = r10
            goto L_0x0115
        L_0x0112:
            r0 = move-exception
            r11 = r10
            r12 = r11
        L_0x0115:
            if (r12 == 0) goto L_0x0135
            r12.release()     // Catch:{ IOException -> 0x011b }
            goto L_0x0135
        L_0x011b:
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to release lock on "
            r2.append(r3)
            java.lang.String r3 = r8.getPath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
        L_0x0135:
            if (r11 == 0) goto L_0x013a
            a((java.io.Closeable) r11)
        L_0x013a:
            a((java.io.Closeable) r9)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.b.a(android.content.Context, java.io.File, java.io.File, java.lang.String, boolean):java.util.List");
    }

    private static List<a> a(File file, File file2) {
        a aVar;
        boolean z;
        String str = file.getName() + ".classes";
        a(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        int i = 2;
        try {
            String str2 = "classes" + 2 + ".dex";
            while (true) {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry != null) {
                    aVar = new a(file2, str + i + ".zip");
                    arrayList.add(aVar);
                    Log.i("MultiDex", "Extraction is needed for file " + aVar);
                    int i2 = 0;
                    z = false;
                    while (i2 < 3 && !z) {
                        i2++;
                        a(zipFile, entry, (File) aVar, str);
                        aVar.a = b(aVar);
                        z = true;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Extraction ");
                        sb.append(z ? "succeeded" : "failed");
                        sb.append(" - length ");
                        sb.append(aVar.getAbsolutePath());
                        sb.append(": ");
                        sb.append(aVar.length());
                        sb.append(" - crc: ");
                        sb.append(aVar.a);
                        Log.i("MultiDex", sb.toString());
                        if (!z) {
                            aVar.delete();
                            if (aVar.exists()) {
                                Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                            }
                        }
                    }
                    if (z) {
                        i++;
                        str2 = "classes" + i + ".dex";
                    } else {
                        throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                    }
                } else {
                    try {
                        zipFile.close();
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to close resource", e);
                    }
                    return arrayList;
                }
            }
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to read crc from " + aVar.getAbsolutePath(), e2);
            z = false;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th;
        }
    }

    private static void a(Context context, String str, long j, long j2, List<a> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (a next : list) {
            edit.putLong(str + "dex.crc." + i, next.a);
            edit.putLong(str + "dex.time." + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void a(File file, final String str) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                String name = file.getName();
                return !name.startsWith(str) && !name.equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file2.getPath());
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static boolean a(Context context, File file, long j, String str) {
        SharedPreferences a2 = a(context);
        if (a2.getLong(str + "timestamp", -1) == a(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return a2.getLong(sb.toString(), -1) != j;
        }
    }

    private static long b(File file) {
        long a2 = c.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }
}
