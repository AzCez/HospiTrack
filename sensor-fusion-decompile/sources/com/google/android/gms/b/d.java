package com.google.android.gms.b;

import android.os.IBinder;
import com.google.android.gms.b.b;
import java.lang.reflect.Field;

public final class d<T> extends b.a {
    private final T a;

    private d(T t) {
        this.a = t;
    }

    public static <T> b a(T t) {
        return new d(t);
    }

    public static <T> T a(b bVar) {
        if (bVar instanceof d) {
            return ((d) bVar).a;
        }
        IBinder asBinder = bVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        } else {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
    }
}
