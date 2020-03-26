package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.i;

public class a extends i.a {
    public static Account a(i iVar) {
        if (iVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return iVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public final Account a() {
        throw new NoSuchMethodError();
    }

    public boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }
}
