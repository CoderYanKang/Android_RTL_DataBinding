package com.yankang.rtldemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yankang.rtldemo.Adapters.CommonPagerAdapter;
import com.yankang.rtldemo.Widgets.RTLViewPager;
import com.yankang.rtldemo.data.PreferManager;
import com.yankang.rtldemo.databinding.ActivityMainBinding;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.yankang.rtldemo.App.stringVaule;

public class MainActivity extends AppCompatActivity
{

    @Bind(R.id.act_tab)
    TabLayout actTab;
    @Bind(R.id.act_viewpager)
    RTLViewPager actViewpager;

    private CommonPagerAdapter adapter;

    private boolean isRtl = false;
    private ActivityMainBinding binding;
    private PreferManager preferManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    private void initView()
    {

        preferManager = PreferManager.getInstance(this);
        binding.setString(App.stringVaule);

        if (stringVaule == null)
        {
            Toast.makeText(this , "为空" ,  Toast.LENGTH_SHORT).show();
        }
        else
        {
            isRtl = App.stringVaule.isLangType();
        }

        adapter = new CommonPagerAdapter(getSupportFragmentManager() , isRtl);

        for (int i = 0 ; i < 3 ; i ++)
        {
            Fragment fragment = new TestFragment();
            adapter.addFragment(fragment , "标签" + i);
        }

        actTab.setupWithViewPager(actViewpager);
        actViewpager.setAdapter(adapter);
        actViewpager.setRtlOriented(isRtl);
    }

    @OnClick(R.id.change_lang)
    public void change()
    {
        if (preferManager.getLangType() == Constant.LANG_EN)
        {
            preferManager.setLangType(Constant.LANG_ZH);
            stringVaule.setLangType(false);

        }else
        {
            preferManager.setLangType(Constant.LANG_EN);
            stringVaule.setLangType(true);
        }

        startActivity(new Intent(this , MainActivity.class));
        finish();
    }
}
