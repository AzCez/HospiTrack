package com.hiq.sensor;

import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.about);
    }
}
