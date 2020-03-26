package android.support.v4.app;

import android.app.RemoteInput;
import android.support.v4.app.ag;

class af {
    static RemoteInput[] a(ag.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            ag.a aVar = aVarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(aVar.a()).setLabel(aVar.b()).setChoices(aVar.c()).setAllowFreeFormInput(aVar.e()).addExtras(aVar.f()).build();
        }
        return remoteInputArr;
    }
}
