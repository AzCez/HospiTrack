package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;

public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: a */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    final boolean a = false;
    final Handler b = null;
    a c;

    class a extends a.C0015a {
        a() {
        }

        public void a(int i, Bundle bundle) {
            if (ResultReceiver.this.b != null) {
                ResultReceiver.this.b.post(new b(i, bundle));
            } else {
                ResultReceiver.this.a(i, bundle);
            }
        }
    }

    class b implements Runnable {
        final int a;
        final Bundle b;

        b(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.a, this.b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.c = a.C0015a.a(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
