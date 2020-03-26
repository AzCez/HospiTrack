package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.c;
import android.arch.lifecycle.d;
import android.arch.lifecycle.g;
import android.os.Bundle;
import android.support.v4.b.h;

public class ak extends Activity implements c {
    private h<Class<? extends Object>, Object> a = new h<>();
    private d b = new d(this);

    public b a() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.b.a(b.C0001b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
