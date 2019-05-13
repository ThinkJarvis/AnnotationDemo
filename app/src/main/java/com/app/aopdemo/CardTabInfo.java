package com.app.aopdemo;

import android.view.ViewGroup;

public class CardTabInfo {

    private int iconId;

    private int stringId;

    private ViewGroup tabView;


    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getStringId() {
        return stringId;
    }

    public void setStringId(int stringId) {
        this.stringId = stringId;
    }

    public ViewGroup getTabView() {
        return tabView;
    }

    public void setTabView(ViewGroup tabView) {
        this.tabView = tabView;
    }
}
