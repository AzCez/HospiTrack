package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: a */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    g l;

    public FragmentState(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        boolean z = true;
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() == 0 ? false : z;
        this.k = parcel.readBundle();
    }

    public FragmentState(g gVar) {
        this.a = gVar.getClass().getName();
        this.b = gVar.n;
        this.c = gVar.v;
        this.d = gVar.F;
        this.e = gVar.G;
        this.f = gVar.H;
        this.g = gVar.K;
        this.h = gVar.J;
        this.i = gVar.p;
        this.j = gVar.I;
    }

    public g a(k kVar, i iVar, g gVar, n nVar) {
        if (this.l == null) {
            Context g2 = kVar.g();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(g2.getClassLoader());
            }
            this.l = iVar != null ? iVar.a(g2, this.a, this.i) : g.a(g2, this.a, this.i);
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(g2.getClassLoader());
                this.l.l = this.k;
            }
            this.l.a(this.b, gVar);
            g gVar2 = this.l;
            gVar2.v = this.c;
            gVar2.x = true;
            gVar2.F = this.d;
            gVar2.G = this.e;
            gVar2.H = this.f;
            gVar2.K = this.g;
            gVar2.J = this.h;
            gVar2.I = this.j;
            gVar2.A = kVar.d;
            if (m.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        g gVar3 = this.l;
        gVar3.D = nVar;
        return gVar3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }
}
