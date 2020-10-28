package com.bin.david.smarttable.bean;

import androidx.fragment.app.Fragment;

/**
 * Created by huang on 2017/10/13.
 */

public class MainItem {

    public Class clazz;
    public Fragment fragment;
    public String chartName;

    public MainItem(Class clazz, String chartName) {
        this.clazz = clazz;
        this.chartName = chartName;
    }

    public MainItem(Fragment fragment, String chartName) {
        this.fragment = fragment;
        this.chartName = chartName;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }
}
