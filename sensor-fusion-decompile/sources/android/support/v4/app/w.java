package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.widget.RemoteViews;
import java.util.ArrayList;

class w {

    public static class a implements t, u {
        private Notification.Builder a;
        private Bundle b;
        private RemoteViews c;
        private RemoteViews d;
        private int e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3, int i5) {
            PendingIntent pendingIntent3;
            Notification notification2 = notification;
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle2 = bundle;
            Context context2 = context;
            RemoteViews remoteViews4 = remoteViews;
            boolean z6 = true;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setShowWhen(z2).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            Notification.Builder largeIcon = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap);
            int i6 = i;
            this.a = largeIcon.setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.b = new Bundle();
            if (bundle2 != null) {
                this.b.putAll(bundle2);
            }
            if (arrayList2 != null && !arrayList.isEmpty()) {
                this.b.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList.size()]));
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
            this.e = i5;
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
            if (this.e != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.e != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.e == 1) {
                    a(build);
                }
            }
            return build;
        }
    }

    public static void a(Notification.Builder builder, aa.a aVar) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
        if (aVar.i() != null) {
            for (RemoteInput addRemoteInput : af.a(aVar.i())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
