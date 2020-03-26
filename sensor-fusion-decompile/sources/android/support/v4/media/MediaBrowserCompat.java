package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final a f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            a aVar = this.f;
            if (aVar != null) {
                switch (i) {
                    case -1:
                        aVar.c(this.d, this.e, bundle);
                        return;
                    case f.a.MapAttrs_ambientEnabled /*0*/:
                        aVar.b(this.d, this.e, bundle);
                        return;
                    case f.a.MapAttrs_cameraBearing /*1*/:
                        aVar.a(this.d, this.e, bundle);
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.e + ", resultData=" + bundle + ")");
                        return;
                }
            }
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final String d;
        private final b e;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.e.a(this.d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.e.a((MediaItem) parcelable);
            } else {
                this.e.a(this.d);
            }
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        private final int a;
        private final MediaDescriptionCompat b;

        MediaItem(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.a + ", mDescription=" + this.b + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, i);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final c f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f.a(this.d, this.e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f.a(this.d, this.e, arrayList);
        }
    }

    public static abstract class a {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class b {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }
}
