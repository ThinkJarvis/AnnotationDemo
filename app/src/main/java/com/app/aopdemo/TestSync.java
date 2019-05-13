package com.app.aopdemo;

import android.util.Log;

public class TestSync {

    private Object mSyncObject = new Object();

    public synchronized void syncMethod() {
        Log.e("wjq", "syncMethod");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void syncClassObject() {
        synchronized (this) {
            Log.e("wjq", "syncClassObject");
        }
    }


    public void unSyncMethod() {
        Log.e("wjq", "unSyncMethod");
    }


    public void syncObjected() {
        synchronized (mSyncObject) {
            Log.e("wjq", "syncObjected");
        }
    }
}
