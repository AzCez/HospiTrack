package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    public static final class a {
        private String a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = (Bitmap) parcel.readParcelable((ClassLoader) null);
        this.f = (Uri) parcel.readParcelable((ClassLoader) null);
        this.g = parcel.readBundle();
        this.h = (Uri) parcel.readParcelable((ClassLoader) null);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0081
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0081
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.a.a((java.lang.Object) r6)
            r1.a((java.lang.String) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.b(r6)
            r1.a((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.c(r6)
            r1.b((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.d(r6)
            r1.c(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.a.e(r6)
            r1.a((android.graphics.Bitmap) r2)
            android.net.Uri r2 = android.support.v4.media.a.f(r6)
            r1.a((android.net.Uri) r2)
            android.os.Bundle r2 = android.support.v4.media.a.g(r6)
            if (r2 != 0) goto L_0x0040
            r3 = r0
            goto L_0x0048
        L_0x0040:
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r3 = r2.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
        L_0x0048:
            if (r3 == 0) goto L_0x0064
            java.lang.String r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r4 = r2.containsKey(r4)
            if (r4 == 0) goto L_0x005a
            int r4 = r2.size()
            r5 = 2
            if (r4 != r5) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            r2.remove(r0)
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r2.remove(r0)
        L_0x0064:
            r0 = r2
        L_0x0065:
            r1.a((android.os.Bundle) r0)
            if (r3 == 0) goto L_0x006e
            r1.b((android.net.Uri) r3)
            goto L_0x007b
        L_0x006e:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x007b
            android.net.Uri r0 = android.support.v4.media.b.h(r6)
            r1.b((android.net.Uri) r0)
        L_0x007b:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.i = r6
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object a() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a2 = a.C0009a.a();
        a.C0009a.a(a2, this.a);
        a.C0009a.a(a2, this.b);
        a.C0009a.b(a2, this.c);
        a.C0009a.c(a2, this.d);
        a.C0009a.a(a2, this.e);
        a.C0009a.a(a2, this.f);
        Bundle bundle = this.g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.C0009a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.b(a2, this.h);
        }
        this.i = a.C0009a.a(a2);
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.b + ", " + this.c + ", " + this.d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i2);
            TextUtils.writeToParcel(this.c, parcel, i2);
            TextUtils.writeToParcel(this.d, parcel, i2);
            parcel.writeParcelable(this.e, i2);
            parcel.writeParcelable(this.f, i2);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i2);
            return;
        }
        a.a(a(), parcel, i2);
    }
}
