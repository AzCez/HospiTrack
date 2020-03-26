package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private final int a;
    private final float b;

    RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public int describeContents() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.a);
        sb.append(" rating=");
        float f = this.b;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
