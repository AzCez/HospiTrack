package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.app.l;
import com.google.android.gms.common.internal.n;

public class i extends f {
    private Dialog ae = null;
    private DialogInterface.OnCancelListener af = null;

    public static i a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        i iVar = new i();
        Dialog dialog2 = (Dialog) n.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        iVar.ae = dialog2;
        if (onCancelListener != null) {
            iVar.af = onCancelListener;
        }
        return iVar;
    }

    public void a(l lVar, String str) {
        super.a(lVar, str);
    }

    public Dialog c(Bundle bundle) {
        if (this.ae == null) {
            b(false);
        }
        return this.ae;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.af;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
