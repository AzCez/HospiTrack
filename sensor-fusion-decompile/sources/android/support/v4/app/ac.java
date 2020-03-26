package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class ac {

    public static class a implements t, u {
        private Notification.Builder a;
        private Bundle b;
        private List<Bundle> c = new ArrayList();
        private RemoteViews d;
        private RemoteViews e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            String str3;
            Bundle bundle2;
            Notification notification2 = notification;
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle3 = bundle;
            String str4 = str;
            String str5 = str2;
            Context context2 = context;
            boolean z6 = false;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setShowWhen(z2).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.b = new Bundle();
            if (bundle3 != null) {
                this.b.putAll(bundle3);
            }
            if (arrayList2 != null && !arrayList.isEmpty()) {
                this.b.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.b.putBoolean("android.support.localOnly", true);
            }
            if (str4 != null) {
                this.b.putString("android.support.groupKey", str4);
                if (z5) {
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
            SparseArray<Bundle> a2 = ab.a(this.c);
            if (a2 != null) {
                this.b.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.a.setExtras(this.b);
            Notification build = this.a.build();
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
}
