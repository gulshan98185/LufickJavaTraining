package com.lufick.training.call_back;

import android.util.Log;

public abstract class MyAbstractCallBack {
    abstract void doItNow();
    void doNotDoIt(){
        Log.d("Shubham","Empty body printing");
    }
}
