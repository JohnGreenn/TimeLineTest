package com.hpkj.timelinetest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public abstract class BaseRvActivity extends AppCompatActivity {


    public RecyclerView rvCommon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        parseIntent();
        initView();
        initData();
    }

    /**
     * 获取布局 id
     */
    protected int setLayoutId() {
        return R.layout.layout_common;
    }

    /**
     * view 绑定
     */
    protected void initView() {

        rvCommon = findViewById(R.id.rv_common);

        if (setLayoutManager() !=null){
            rvCommon.setLayoutManager(setLayoutManager());
        }

        if (setDivider() !=null){
            rvCommon.addItemDecoration(setDivider());
        }

        setAdapter();
    }



    /**
     * 设置分割线
     * @return
     */
    protected RecyclerView.ItemDecoration setDivider(){
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        return itemDecoration;

    }

    /**
     * 设置 LayoutManager
     * @return
     */
    protected RecyclerView.LayoutManager setLayoutManager(){

        return new LinearLayoutManager(this);

    }


    /**
     * intent 参数处理
     */
    protected void parseIntent() {

    }

    /**
     * 设置 adapter
     *
     * @return
     */
    protected abstract void setAdapter();


    /**
     * 设置页面标题
     *
     * @return
     */
    public abstract String setTitle();

    /**
     * 初始化数据
     */
    protected abstract void initData();

}