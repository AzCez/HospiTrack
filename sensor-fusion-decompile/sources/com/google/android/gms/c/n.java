package com.google.android.gms.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.d.c.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class n {
    n() {
    }

    private static o a(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(i.a(str, "|P|"), (String) null);
        String string2 = sharedPreferences.getString(i.a(str, "|K|"), (String) null);
        if (string == null || string2 == null) {
            return null;
        }
        return new o(a(string, string2), b(sharedPreferences, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.c.o a(java.io.File r5) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r5)
            r5 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ Throwable -> 0x0043 }
            r1.<init>()     // Catch:{ Throwable -> 0x0043 }
            r1.load(r0)     // Catch:{ Throwable -> 0x0043 }
            java.lang.String r2 = "pub"
            java.lang.String r2 = r1.getProperty(r2)     // Catch:{ Throwable -> 0x0043 }
            java.lang.String r3 = "pri"
            java.lang.String r3 = r1.getProperty(r3)     // Catch:{ Throwable -> 0x0043 }
            if (r2 == 0) goto L_0x003d
            if (r3 != 0) goto L_0x001f
            goto L_0x003d
        L_0x001f:
            java.security.KeyPair r2 = a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0043 }
            java.lang.String r3 = "cre"
            java.lang.String r1 = r1.getProperty(r3)     // Catch:{ NumberFormatException -> 0x0036 }
            long r3 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x0036 }
            com.google.android.gms.c.o r1 = new com.google.android.gms.c.o     // Catch:{ Throwable -> 0x0043 }
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x0043 }
            a((java.lang.Throwable) r5, (java.io.FileInputStream) r0)
            return r1
        L_0x0036:
            r1 = move-exception
            com.google.android.gms.c.p r2 = new com.google.android.gms.c.p     // Catch:{ Throwable -> 0x0043 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0043 }
            throw r2     // Catch:{ Throwable -> 0x0043 }
        L_0x003d:
            a((java.lang.Throwable) r5, (java.io.FileInputStream) r0)
            return r5
        L_0x0041:
            r1 = move-exception
            goto L_0x0045
        L_0x0043:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0045:
            a((java.lang.Throwable) r5, (java.io.FileInputStream) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.n.a(java.io.File):com.google.android.gms.c.o");
    }

    private static KeyPair a(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("InstanceID", sb.toString());
                throw new p(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new p(e2);
        }
    }

    static void a(Context context) {
        for (File file : b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static void a(Context context, String str, o oVar) {
        FileOutputStream fileOutputStream;
        try {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Writing key to properties file");
            }
            File f = f(context, str);
            f.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", oVar.b());
            properties.setProperty("pri", oVar.c());
            properties.setProperty("cre", String.valueOf(oVar.b));
            fileOutputStream = new FileOutputStream(f);
            properties.store(fileOutputStream, (String) null);
            a((Throwable) null, fileOutputStream);
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Failed to write key: ");
            sb.append(valueOf);
            Log.w("InstanceID", sb.toString());
        } catch (Throwable th) {
            a(r3, fileOutputStream);
            throw th;
        }
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                a.a(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }

    private static /* synthetic */ void a(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                a.a(th, th2);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(i.a(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static File b(Context context) {
        File a = android.support.v4.a.a.a(context);
        if (a != null && a.isDirectory()) {
            return a;
        }
        Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final void b(Context context, String str, o oVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (oVar.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (p unused) {
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(i.a(str, "|P|"), oVar.b());
        edit.putString(i.a(str, "|K|"), oVar.c());
        edit.putString(i.a(str, "cre"), String.valueOf(oVar.b));
        edit.commit();
    }

    static void c(Context context, String str) {
        File f = f(context, str);
        if (f.exists()) {
            f.delete();
        }
    }

    private final o d(Context context, String str) {
        try {
            o e = e(context, str);
            if (e != null) {
                b(context, str, e);
                return e;
            }
            e = null;
            try {
                o a = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (a != null) {
                    a(context, str, a);
                    return a;
                }
            } catch (p e2) {
                e = e2;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (p e3) {
            e = e3;
        }
    }

    private final o e(Context context, String str) {
        File f = f(context, str);
        if (!f.exists()) {
            return null;
        }
        try {
            return a(f);
        } catch (IOException e) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("InstanceID", sb.toString());
            }
            try {
                return a(f);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("InstanceID", sb2.toString());
                throw new p(e2);
            }
        }
    }

    private static File f(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(b(context), str2);
    }

    /* access modifiers changed from: package-private */
    public final o a(Context context, String str) {
        o d = d(context, str);
        return d != null ? d : b(context, str);
    }

    /* access modifiers changed from: package-private */
    public final o b(Context context, String str) {
        o oVar = new o(j.a(), System.currentTimeMillis());
        try {
            o d = d(context, str);
            if (d != null) {
                if (Log.isLoggable("InstanceID", 3)) {
                    Log.d("InstanceID", "Loaded key after generating new one, using loaded one");
                }
                return d;
            }
        } catch (p unused) {
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Generated new key");
        }
        a(context, str, oVar);
        b(context, str, oVar);
        return oVar;
    }
}
