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
import java.util.Iterator;

class y {

    public static class a implements t, u {
        private Notification.Builder a;
        private int b;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            PendingIntent pendingIntent3;
            Notification notification3 = notification;
            RemoteViews remoteViews5 = remoteViews2;
            RemoteViews remoteViews6 = remoteViews3;
            RemoteViews remoteViews7 = remoteViews4;
            Context context2 = context;
            RemoteViews remoteViews8 = remoteViews;
            boolean z6 = true;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification3.when).setShowWhen(z2).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, remoteViews).setSound(notification3.sound, notification3.audioStreamType).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((notification3.flags & 2) != 0).setOnlyAlertOnce((notification3.flags & 8) != 0).setAutoCancel((notification3.flags & 16) != 0).setDefaults(notification3.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification3.deleteIntent);
            if ((notification3.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            this.a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            if (remoteViews5 != null) {
                this.a.setCustomContentView(remoteViews5);
            }
            if (remoteViews6 != null) {
                this.a.setCustomBigContentView(remoteViews6);
            }
            if (remoteViews7 != null) {
                this.a.setCustomHeadsUpContentView(remoteViews7);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.a.addPerson(it.next());
            }
            this.b = i7;
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
            y.a(this.a, aVar);
        }

        public Notification b() {
            Notification build = this.a.build();
            if (this.b != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.b != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.b == 1) {
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
        builder2.setAllowGeneratedReplies(aVar.e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
