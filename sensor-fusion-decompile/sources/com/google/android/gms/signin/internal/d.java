package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface d extends IInterface {
    void a(ConnectionResult connectionResult, zaa zaa);

    void a(Status status);

    void a(Status status, GoogleSignInAccount googleSignInAccount);

    void a(zaj zaj);

    void b(Status status);
}
