package com.yankang.rtldemo;

import android.app.Application;

import com.yankang.rtldemo.Strings.StringVaule;
import com.yankang.rtldemo.data.PreferManager;

/**
 * Created by yankang on 2017/1/21.
 */

public class App extends Application
{

    private PreferManager preferManager;
    public static StringVaule stringVaule = new StringVaule();;

    @Override
    public void onCreate()
    {
        super.onCreate();
        preferManager = PreferManager.getInstance(this);
        preferManager = PreferManager.getInstance(this);
        stringVaule.setLangType(preferManager.getLangType() == Constant.LANG_EN);
    }

}
