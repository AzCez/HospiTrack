package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();
    private static c a = e.b();
    private final int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Uri g;
    private String h;
    private long i;
    private String j;
    private List<Scope> k;
    private String l;
    private String m;
    private Set<Scope> n = new HashSet();

    GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j2;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), jSONObject.optString("givenName", (String) null), jSONObject.optString("familyName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a2.h = jSONObject.optString("serverAuthCode", (String) null);
        return a2;
    }

    private static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, (l2 == null ? Long.valueOf(a.a() / 1000) : l2).longValue(), n.a(str7), new ArrayList((Collection) n.a(set)), str5, str6);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public Account d() {
        String str = this.e;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.j.equals(this.j) && googleSignInAccount.j().equals(j());
    }

    public String f() {
        return this.l;
    }

    public String g() {
        return this.m;
    }

    public Uri h() {
        return this.g;
    }

    public int hashCode() {
        return ((this.j.hashCode() + 527) * 31) + j().hashCode();
    }

    public String i() {
        return this.h;
    }

    public Set<Scope> j() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.b);
        b.a(parcel, 2, a(), false);
        b.a(parcel, 3, b(), false);
        b.a(parcel, 4, c(), false);
        b.a(parcel, 5, e(), false);
        b.a(parcel, 6, (Parcelable) h(), i2, false);
        b.a(parcel, 7, i(), false);
        b.a(parcel, 8, this.i);
        b.a(parcel, 9, this.j, false);
        b.a(parcel, 10, this.k, false);
        b.a(parcel, 11, f(), false);
        b.a(parcel, 12, g(), false);
        b.a(parcel, a2);
    }
}
