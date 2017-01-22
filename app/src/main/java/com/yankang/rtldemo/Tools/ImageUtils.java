package com.yankang.rtldemo.Tools;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yankang on 2017/1/22.
 */

public class ImageUtils {

    /**
     * 绑定自定义属性 方法
     * @param imageView
     * @param url
     */
    @BindingAdapter({"image"})
    public static void imageLoader(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

}
