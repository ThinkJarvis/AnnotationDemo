package com.app.aopdemo;


import android.content.Context;

@InjectCardTab(stringId = R.string.setting_tab_b, iconId = R.drawable.ic_launcher_background)
public class SettingsTabB extends BaseSetting{
    public SettingsTabB(Context context) {
        super(context);
    }
}
