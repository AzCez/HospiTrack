package android.support.v4.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.gms.maps.f;

public class f extends g implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public void a(Dialog dialog, int i2) {
        switch (i2) {
            case f.a.MapAttrs_cameraBearing /*1*/:
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                break;
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.G == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public void a(l lVar, String str) {
        this.h = false;
        this.i = true;
        o a2 = lVar.a();
        a2.a(this, str);
        a2.b();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            Dialog dialog = this.f;
            if (dialog != null) {
                dialog.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                l().a(this.e, 1);
                this.e = -1;
                return;
            }
            o a2 = l().a();
            a2.a(this);
            if (z) {
                a2.c();
            } else {
                a2.b();
            }
        }
    }

    public int b() {
        return this.b;
    }

    public LayoutInflater b(Bundle bundle) {
        Context g2;
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        Dialog dialog = this.f;
        if (dialog != null) {
            a(dialog, this.a);
            g2 = this.f.getContext();
        } else {
            g2 = this.B.g();
        }
        return (LayoutInflater) g2.getSystemService("layout_inflater");
    }

    public void b(boolean z) {
        this.d = z;
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(j(), b());
    }

    public void c() {
        super.c();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    public void d() {
        super.d();
        Dialog dialog = this.f;
        if (dialog != null) {
            this.g = false;
            dialog.show();
        }
    }

    public void d(Bundle bundle) {
        Bundle bundle2;
        super.d(bundle);
        if (this.d) {
            View o = o();
            if (o != null) {
                if (o.getParent() == null) {
                    this.f.setContentView(o);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            h j = j();
            if (j != null) {
                this.f.setOwnerActivity(j);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void e() {
        super.e();
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        Dialog dialog = this.f;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.a;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.b;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.c;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.d;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.e;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    public void f() {
        super.f();
        Dialog dialog = this.f;
        if (dialog != null) {
            this.g = true;
            dialog.dismiss();
            this.f = null;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }
}
