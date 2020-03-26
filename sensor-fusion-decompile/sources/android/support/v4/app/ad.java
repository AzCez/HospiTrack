package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

class ad implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private ad(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static ad a(View view, Runnable runnable) {
        ad adVar = new ad(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(adVar);
        view.addOnAttachStateChangeListener(adVar);
        return adVar;
    }

    public void a() {
        (this.b.isAlive() ? this.b : this.a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
