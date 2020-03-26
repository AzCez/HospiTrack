package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.d.b.b;
import com.google.android.gms.d.b.c;

public interface i extends IInterface {

    public static abstract class a extends b implements i {

        /* renamed from: com.google.android.gms.common.internal.i$a$a  reason: collision with other inner class name */
        public static class C0026a extends com.google.android.gms.d.b.a implements i {
            C0026a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account a() {
                Parcel a = a(2, b());
                Account account = (Account) c.a(a, Account.CREATOR);
                a.recycle();
                return account;
            }
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof i ? (i) queryLocalInterface : new C0026a(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 2) {
                return false;
            }
            Account a = a();
            parcel2.writeNoException();
            c.b(parcel2, a);
            return true;
        }
    }

    Account a();
}
