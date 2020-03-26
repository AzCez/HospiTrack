package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.v4.media.a;

class b extends a {

    static class a extends a.C0009a {
        public static void b(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
