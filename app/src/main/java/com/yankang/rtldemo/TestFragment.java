package com.yankang.rtldemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yankang.rtldemo.Adapters.CommonAdapter;
import com.yankang.rtldemo.Model.Student;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yankang on 2017/1/20.
 */

public class TestFragment extends Fragment{

    @Bind(R.id.list)
    RecyclerView list;

    private CommonAdapter mAdapter;
    private ArrayList<Student> mData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this, rootView);
        initView();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView()
    {
        mData.clear();
        mData.add(new Student("张三"  , "男" , "http://photocdn.sohu.com/20160226/mp60716281_1456484937227_6.jpeg"));
        mData.add(new Student("李四"  , "男" , "http://imgsrc.baidu.com/forum/w%3D580/sign=370a5a67c88065387beaa41ba7dda115/a7efce1b9d16fdfa0b4819c7b68f8c5494ee7bf7.jpg"));
        mData.add(new Student("王二"  , "男" , "http://ws2.cdn.caijing.com.cn/2014-05-28/114219406.jpg"));
        mData.add(new Student("麻子"  , "男" , "http://pic.92to.com/anv/201602/12/biyhs155w4q.png"));
        mData.add(new Student("小明"  , "男" , "http://b.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d36e64f76d63f6241c083107b274c7ce/42a98226cffc1e17abf363ff4c90f603728de9b4.jpg"));
        mData.add(new Student("小红"  , "女" , "http://imgsrc.baidu.com/forum/w=580/sign=a6c9848c00087bf47dec57e1c2d2575e/fc399a025aafa40ff0a7751aa964034f7af019d9.jpg"));
        mData.add(new Student("小花"  , "女" , "http://f1.homevv.com/2016/0407/20160407040934406.jpg"));

        mAdapter = new CommonAdapter(mData);
        list.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false));
        list.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
