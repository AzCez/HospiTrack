package android.arch.lifecycle;

import android.arch.lifecycle.b;
import com.google.android.gms.maps.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver implements a {
    static final Map<Class, a> a = new HashMap();
    private final Object b;
    private final a c = a(this.b.getClass());

    static class a {
        final Map<b.a, List<b>> a = new HashMap();
        final Map<b, b.a> b;

        a(Map<b, b.a> map) {
            this.b = map;
            for (Map.Entry next : map.entrySet()) {
                b.a aVar = (b.a) next.getValue();
                List list = this.a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }
    }

    static class b {
        final int a;
        final Method b;

        b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.b = obj;
    }

    private static a a(Class cls) {
        a aVar = a.get(cls);
        return aVar != null ? aVar : b(cls);
    }

    private void a(a aVar, c cVar, b.a aVar2) {
        a(aVar.a.get(aVar2), cVar, aVar2);
        a(aVar.a.get(b.a.ON_ANY), cVar, aVar2);
    }

    private void a(b bVar, c cVar, b.a aVar) {
        try {
            switch (bVar.a) {
                case f.a.MapAttrs_ambientEnabled /*0*/:
                    bVar.b.invoke(this.b, new Object[0]);
                    return;
                case f.a.MapAttrs_cameraBearing /*1*/:
                    bVar.b.invoke(this.b, new Object[]{cVar});
                    return;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    bVar.b.invoke(this.b, new Object[]{cVar, aVar});
                    return;
                default:
                    return;
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Failed to call observer method", e.getCause());
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void a(List<b> list, c cVar, b.a aVar) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                a(list.get(size), cVar, aVar);
            }
        }
    }

    private static void a(Map<b, b.a> map, b bVar, b.a aVar, Class cls) {
        b.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private static a b(Class cls) {
        int i;
        a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a2 = a(superclass)) == null)) {
            hashMap.putAll(a2.b);
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class a3 : cls.getInterfaces()) {
            for (Map.Entry next : a(a3).b.entrySet()) {
                a(hashMap, (b) next.getKey(), (b.a) next.getValue(), cls);
            }
        }
        for (Method method : declaredMethods) {
            f fVar = (f) method.getAnnotation(f.class);
            if (fVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(c.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                b.a a4 = fVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(b.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a4 == b.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), a4, cls);
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        a.put(cls, aVar);
        return aVar;
    }

    public void a(c cVar, b.a aVar) {
        a(this.c, cVar, aVar);
    }
}
