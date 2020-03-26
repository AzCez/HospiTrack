package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.b;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public BackStackState(b bVar) {
        int size = bVar.c.size();
        this.a = new int[(size * 6)];
        if (bVar.j) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                b.a aVar = bVar.c.get(i2);
                int i4 = i3 + 1;
                this.a[i3] = aVar.a;
                int i5 = i4 + 1;
                this.a[i4] = aVar.b != null ? aVar.b.n : -1;
                int i6 = i5 + 1;
                this.a[i5] = aVar.c;
                int i7 = i6 + 1;
                this.a[i6] = aVar.d;
                int i8 = i7 + 1;
                this.a[i7] = aVar.e;
                this.a[i8] = aVar.f;
                i2++;
                i3 = i8 + 1;
            }
            this.b = bVar.h;
            this.c = bVar.i;
            this.d = bVar.l;
            this.e = bVar.n;
            this.f = bVar.o;
            this.g = bVar.p;
            this.h = bVar.q;
            this.i = bVar.r;
            this.j = bVar.s;
            this.k = bVar.t;
            this.l = bVar.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public b a(m mVar) {
        b bVar = new b(mVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.a.length) {
            b.a aVar = new b.a();
            int i4 = i2 + 1;
            aVar.a = this.a[i2];
            if (m.a) {
                Log.v("FragmentManager", "Instantiate " + bVar + " op #" + i3 + " base fragment #" + this.a[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.a[i4];
            aVar.b = i6 >= 0 ? mVar.f.get(i6) : null;
            int[] iArr = this.a;
            int i7 = i5 + 1;
            aVar.c = iArr[i5];
            int i8 = i7 + 1;
            aVar.d = iArr[i7];
            int i9 = i8 + 1;
            aVar.e = iArr[i8];
            aVar.f = iArr[i9];
            bVar.d = aVar.c;
            bVar.e = aVar.d;
            bVar.f = aVar.e;
            bVar.g = aVar.f;
            bVar.a(aVar);
            i3++;
            i2 = i9 + 1;
        }
        bVar.h = this.b;
        bVar.i = this.c;
        bVar.l = this.d;
        bVar.n = this.e;
        bVar.j = true;
        bVar.o = this.f;
        bVar.p = this.g;
        bVar.q = this.h;
        bVar.r = this.i;
        bVar.s = this.j;
        bVar.t = this.k;
        bVar.u = this.l;
        bVar.a(1);
        return bVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}
