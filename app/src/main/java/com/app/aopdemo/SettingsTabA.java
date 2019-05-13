package com.app.aopdemo;


import android.content.Context;

@InjectCardTab(stringId = R.string.setting_tab_a, iconId = R.drawable.ic_launcher_background)
public class SettingsTabA extends BaseSetting {
    public SettingsTabA(Context context) {
        super(context);
    }
}
