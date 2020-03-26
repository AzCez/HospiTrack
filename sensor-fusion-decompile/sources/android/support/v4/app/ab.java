package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ab {
    private static final Object a = new Object();
    private static Field b;
    private static boolean c;
    private static final Object d = new Object();

    public static class a implements t, u {
        private Notification.Builder a;
        private final Bundle b;
        private List<Bundle> c = new ArrayList();
        private RemoteViews d;
        private RemoteViews e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            String str3;
            Bundle bundle2;
            Notification notification2 = notification;
            Bundle bundle3 = bundle;
            String str4 = str;
            String str5 = str2;
            Context context2 = context;
            RemoteViews remoteViews4 = remoteViews;
            boolean z5 = false;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.a = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.b = new Bundle();
            if (bundle3 != null) {
                this.b.putAll(bundle3);
            }
            if (z3) {
                this.b.putBoolean("android.support.localOnly", true);
            }
            if (str4 != null) {
                this.b.putString("android.support.groupKey", str4);
                if (z4) {
                    bundle2 = this.b;
                    str3 = "android.support.isGroupSummary";
                } else {
                    bundle2 = this.b;
                    str3 = "android.support.useSideChannel";
                }
                bundle2.putBoolean(str3, true);
            }
            if (str5 != null) {
                this.b.putString("android.support.sortKey", str5);
            }
            this.d = remoteViews2;
            this.e = remoteViews3;
        }

        public Notification.Builder a() {
            return this.a;
        }

        public void a(aa.a aVar) {
            this.c.add(ab.a(this.a, aVar));
        }

        public Notification b() {
            Notification build = this.a.build();
            Bundle a2 = ab.a(build);
            Bundle bundle = new Bundle(this.b);
            for (String str : this.b.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = ab.a(this.c);
            if (a3 != null) {
                ab.a(build).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews = this.d;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            return build;
        }
    }

    public static Bundle a(Notification.Builder builder, aa.a aVar) {
        builder.addAction(aVar.a(), aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.i() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ah.a(aVar.i()));
        }
        if (aVar.h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", ah.a(aVar.h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    public static Bundle a(Notification notification) {
        String str;
        String str2;
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                e = e;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                c = true;
                return null;
            }
        }
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static void a(u uVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(uVar.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }
}
