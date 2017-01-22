package com.yankang.rtldemo.Adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yankang.rtldemo.App;
import com.yankang.rtldemo.BR;
import com.yankang.rtldemo.Model.Student;
import com.yankang.rtldemo.R;

import java.util.ArrayList;


/**
 * Created by yankang on 2017/1/22.
 * MVVM 在recycleview 中的应用
 */

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHoler>
{

    private final ArrayList<Student> mData = new ArrayList<>();

    public CommonAdapter(ArrayList<Student> data)
    {
        mData.addAll(data);
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.list_item, parent, false);
        ViewHoler holder = new ViewHoler(binding.getRoot());
        holder.setViewDataBinding(binding);
        return holder;
    }

    //设置数据
    @Override
    public void onBindViewHolder(ViewHoler holder, int position)
    {
        //修改绑定数据
        holder.getViewDataBinding().setVariable(BR.stu, mData.get(position));
        holder.getViewDataBinding().setVariable(BR.string , App.stringVaule);

        //刷新
        holder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder{

        private ViewDataBinding viewDataBinding;

        public ViewHoler(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }
    }
}
