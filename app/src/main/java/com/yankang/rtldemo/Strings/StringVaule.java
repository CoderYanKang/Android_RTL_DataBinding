package com.yankang.rtldemo.Strings;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.yankang.rtldemo.BR;

/**
 * Created by yankang on 2017/1/19.
 * app 字符串常量类
 */

public class StringVaule extends BaseObservable
{
     private boolean langType = false;
     @Bindable
     public boolean isLangType() {
          return langType;
     }

     public void setLangType(boolean langType)
     {
          this.langType = langType;
          notifyPropertyChanged(BR.langType);
     }

     // 文字
     public final String btn = "改变";
     public final String _btn = "change";
}
