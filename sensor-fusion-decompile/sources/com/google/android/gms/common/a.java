package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.n;

public class a extends DialogFragment {
    private Dialog a = null;
    private DialogInterface.OnCancelListener b = null;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) n.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        aVar.a = dialog2;
        if (onCancelListener != null) {
            aVar.b = onCancelListener;
        }
        return aVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
