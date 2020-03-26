package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.b.h;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class j {
    private final k<?> a;

    private j(k<?> kVar) {
        this.a = kVar;
    }

    public static final j a(k<?> kVar) {
        return new j(kVar);
    }

    public g a(String str) {
        return this.a.d.b(str);
    }

    public l a() {
        return this.a.i();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.d.onCreateView(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void a(Parcelable parcelable, n nVar) {
        this.a.d.a(parcelable, nVar);
    }

    public void a(g gVar) {
        m mVar = this.a.d;
        k<?> kVar = this.a;
        mVar.a((k) kVar, (i) kVar, gVar);
    }

    public void a(h<String, r> hVar) {
        this.a.a(hVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.a.b(str, fileDescriptor, printWriter, strArr);
    }

    public void a(boolean z) {
        this.a.d.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public void b() {
        this.a.d.l();
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public void b(boolean z) {
        this.a.d.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public Parcelable c() {
        return this.a.d.k();
    }

    public void c(boolean z) {
        this.a.a(z);
    }

    public n d() {
        return this.a.d.i();
    }

    public void e() {
        this.a.d.m();
    }

    public void f() {
        this.a.d.n();
    }

    public void g() {
        this.a.d.o();
    }

    public void h() {
        this.a.d.p();
    }

    public void i() {
        this.a.d.q();
    }

    public void j() {
        this.a.d.r();
    }

    public void k() {
        this.a.d.s();
    }

    public void l() {
        this.a.d.u();
    }

    public void m() {
        this.a.d.v();
    }

    public boolean n() {
        return this.a.d.f();
    }

    public void o() {
        this.a.k();
    }

    public void p() {
        this.a.l();
    }

    public void q() {
        this.a.m();
    }

    public h<String, r> r() {
        return this.a.n();
    }
}
