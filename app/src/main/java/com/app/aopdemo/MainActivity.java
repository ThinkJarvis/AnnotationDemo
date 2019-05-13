package com.app.aopdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testSettingsTabLoad();
//        testSync();


    }

    private void testSync() {
        final TestSync testSync = new TestSync();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.syncMethod();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.syncClassObject();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.syncObjected();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.unSyncMethod();
            }
        }).start();

    }

    public void testSettingsTabLoad() {
        Observable.fromIterable(AnnotationTools.getClassName(null, MainActivity.this, InjectCardTab.class))
                .map(new Function<Class, CardTabInfo>() {

                    @Override
                    public CardTabInfo apply(Class aClass) throws Exception {
                        CardTabInfo cardTabInfo = new CardTabInfo();
                        InjectCardTab injectCardTab = (InjectCardTab) aClass.getAnnotation(InjectCardTab.class);
                        cardTabInfo.setIconId(injectCardTab.iconId());
                        cardTabInfo.setStringId(injectCardTab.stringId());
                        Constructor constructor = aClass.getConstructor(Context.class);
                        ViewGroup setting = (ViewGroup) constructor.newInstance(MainActivity.this);
                        cardTabInfo.setTabView(setting);
                        return cardTabInfo;
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CardTabInfo>>() {
                    @Override
                    public void accept(List<CardTabInfo> tabList) throws Exception {
                        for (int i = 0; i < tabList.size(); i++) {
                            Log.e("wjq", getResources().getString(tabList.get(i).getStringId()) + " | " + tabList.get(i).getIconId() + " | " + tabList.get(i).getTabView());
                        }
                    }
                });
    }


}
