package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.adapter.BannerListAdapter;
import com.qianfeng.toplevel.bean.BannerListBean;
import com.qianfeng.toplevel.utils.URLConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * /这是广告的内容有页面
 * 从条目的点击界面中跳转过来
 */

public class BannerListActivity extends AppCompatActivity {

    private int id;
    private String TAG = "wuhao";
    private List<BannerListBean.DataBean.PostsBean> itemsBeanList;

    @BindView(R.id.tv_banner_title_name)
    TextView tv_title;
//    private BannerAdapter bannerAdapter;
    @BindView(R.id.lv_banner_bottom)
    PullToRefreshListView mListView;
    private BannerListAdapter bannerListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);
        initId();
//        得到id
        initData();
//        加载数据

    }

    private void initId() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        itemsBeanList=new ArrayList<>();
    }

    private void initData() {
        OkHttpTool.newInstance().start(URLConstants.BANNER_START + id + URLConstants.BANNER_END)
                .callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        BannerListBean bannerListBean = gson.fromJson(result, BannerListBean.class);
                        initAdapter();
//        初始化适配器
                        bindAdapter();
//        绑定适配器
                        itemsBeanList.addAll(bannerListBean.getData().getPosts());
                        tv_title.setText(bannerListBean.getData().getTitle());
                        bannerListAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void bindAdapter() {
        mListView.setAdapter(bannerListAdapter);
    }

    private void initAdapter() {
        bannerListAdapter = new BannerListAdapter(this, R.layout.listview_child_item,itemsBeanList);
    }

    //    设置返回键
    public void BannerBackMain(View view) {
        finish();
    }

}
