package com.yankang.rtldemo.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.yankang.rtldemo.BR;
/**
 * Created by yankang on 2017/1/22.
 */

public class Student extends BaseObservable
{


    private String name;
    private String gender;
    private String imageUrl;


    public Student(String name, String gender, String imageUrl) {
        this.name = name;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

}
