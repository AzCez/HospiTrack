package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.b.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.d;
import java.util.LinkedList;

public abstract class a<T extends c> {
    /* access modifiers changed from: private */
    public T a;
    /* access modifiers changed from: private */
    public Bundle b;
    /* access modifiers changed from: private */
    public LinkedList<C0018a> c;
    private final e<T> d = new f(this);

    /* renamed from: com.google.android.gms.b.a$a  reason: collision with other inner class name */
    private interface C0018a {
        int a();

        void a(c cVar);
    }

    private final void a(int i) {
        while (!this.c.isEmpty() && this.c.getLast().a() >= i) {
            this.c.removeLast();
        }
    }

    private final void a(Bundle bundle, C0018a aVar) {
        T t = this.a;
        if (t != null) {
            aVar.a(t);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(aVar);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.d);
    }

    public static void b(FrameLayout frameLayout) {
        b a2 = b.a();
        Context context = frameLayout.getContext();
        int a3 = a2.a(context);
        String c2 = d.c(context, a3);
        String e = d.e(context, a3);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(c2);
        linearLayout.addView(textView);
        Intent a4 = a2.a(context, a3, (String) null);
        if (a4 != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new j(context, a4));
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, (C0018a) new i(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public T a() {
        return this.a;
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, (C0018a) new g(this, activity, bundle, bundle2));
    }

    public void a(Bundle bundle) {
        a(bundle, (C0018a) new h(this, bundle));
    }

    /* access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
        b(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void a(e<T> eVar);

    public void b() {
        a((Bundle) null, (C0018a) new k(this));
    }

    public void b(Bundle bundle) {
        T t = this.a;
        if (t != null) {
            t.b(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void c() {
        a((Bundle) null, (C0018a) new l(this));
    }

    public void d() {
        T t = this.a;
        if (t != null) {
            t.c();
        } else {
            a(5);
        }
    }

    public void e() {
        T t = this.a;
        if (t != null) {
            t.d();
        } else {
            a(4);
        }
    }

    public void f() {
        T t = this.a;
        if (t != null) {
            t.e();
        } else {
            a(2);
        }
    }

    public void g() {
        T t = this.a;
        if (t != null) {
            t.f();
        } else {
            a(1);
        }
    }

    public void h() {
        T t = this.a;
        if (t != null) {
            t.g();
        }
    }
}
