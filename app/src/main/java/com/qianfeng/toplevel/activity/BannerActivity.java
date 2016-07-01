package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qianfeng.toplevel.R;

/**
 * /这是广告的内容有页面
 * 从条目的点击界面中跳转过来
 */

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        initData();
//
    }

    private void initData() {
        Intent intent=getIntent();
    }
}
