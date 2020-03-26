package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import com.google.android.gms.maps.f;
import java.util.List;

class c {

    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4, int i5);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);
    }

    static class b<T extends a> extends MediaController.Callback {
        protected final T a;

        public b(T t) {
            this.a = t;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.a.a(playbackInfo.getPlaybackType(), C0014c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            this.a.a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.a.b(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.a.a((Object) playbackState);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.a.a((List<?>) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.a.a(charSequence);
        }

        public void onSessionDestroyed() {
            this.a.a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.a.a(str, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    public static class C0014c {
        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                case f.a.MapAttrs_latLngBoundsSouthWestLongitude /*11*/:
                case f.a.MapAttrs_liteMode /*12*/:
                case f.a.MapAttrs_uiCompass /*14*/:
                    return 3;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    return 0;
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    return 8;
                case f.a.MapAttrs_cameraTargetLat /*4*/:
                    return 4;
                case f.a.MapAttrs_cameraTargetLng /*5*/:
                case f.a.MapAttrs_cameraZoom /*7*/:
                case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
                case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                case f.a.MapAttrs_latLngBoundsSouthWestLatitude /*10*/:
                    return 5;
                case f.a.MapAttrs_cameraTilt /*6*/:
                    return 2;
                case f.a.MapAttrs_mapType /*13*/:
                    return 1;
                default:
                    return 3;
            }
        }

        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
