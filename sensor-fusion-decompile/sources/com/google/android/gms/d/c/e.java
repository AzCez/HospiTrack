package com.google.android.gms.d.c;

final class e extends b {
    private final c a = new c();

    e() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.a.a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
