package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class x {

    public static class a implements t, u {
        private Notification.Builder a;
        private Bundle b;
        private RemoteViews c;
        private RemoteViews d;
        private RemoteViews e;
        private int f;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            PendingIntent pendingIntent3;
            Notification notification3 = notification;
            Bundle bundle2 = bundle;
            Context context2 = context;
            RemoteViews remoteViews5 = remoteViews;
            boolean z6 = true;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            PendingIntent pendingIntent4 = pendingIntent;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification3.when).setShowWhen(z2).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, remoteViews).setSound(notification3.sound, notification3.audioStreamType).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((notification3.flags & 2) != 0).setOnlyAlertOnce((notification3.flags & 8) != 0).setAutoCancel((notification3.flags & 16) != 0).setDefaults(notification3.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification3.deleteIntent);
            if ((notification3.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            Notification.Builder largeIcon = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap);
            int i8 = i;
            this.a = largeIcon.setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.b = new Bundle();
            if (bundle2 != null) {
                this.b.putAll(bundle2);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.a.addPerson(it.next());
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
            this.e = remoteViews4;
            this.f = i7;
        }

        private void a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }

        public Notification.Builder a() {
            return this.a;
        }

        public void a(aa.a aVar) {
            w.a(this.a, aVar);
        }

        public Notification b() {
            this.a.setExtras(this.b);
            Notification build = this.a.build();
            RemoteViews remoteViews = this.c;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.e;
            if (remoteViews3 != null) {
                build.headsUpContentView = remoteViews3;
            }
            if (this.f != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f == 1) {
                    a(build);
                }
            }
            return build;
        }
    }
}
