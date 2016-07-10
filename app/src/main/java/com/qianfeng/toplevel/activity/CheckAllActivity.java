package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.adapter.BottomChildAdapter;
import com.qianfeng.toplevel.bean.StrategyBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckAllActivity extends AppCompatActivity {
    @BindView(R.id.gv_check_all)
    PullToRefreshGridView mGridView;
    @BindView(R.id.tv_check_all_title)
    TextView title;
    private StrategyBean.DataBean.ChannelGroupsBean channelGroupsBean;
    private BottomChildAdapter bottomChildAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_all);
        ButterKnife.bind(this);
        setupGridView();
//        设置gridview
    }

    private void setupGridView() {
        initData();
//         初始化数据
        initAdapter();
//         初始化适配 器
        bindAdapter();
//        绑定适配器
        initLister();
//         对gridview进行监听
    }

    /*
    *  数据是攻略页面传过来的
    * */
    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            channelGroupsBean =
                    (StrategyBean.DataBean.ChannelGroupsBean)
                            intent.getSerializableExtra("bean");
        }

    }

    private void initAdapter() {
        bottomChildAdapter = new BottomChildAdapter(this, R.layout.item_expand_listview_gonglv_bottom_child,
              channelGroupsBean.getChannels()  );
    }

    private void bindAdapter() {
       mGridView.setAdapter(bottomChildAdapter);
        title.setText(channelGroupsBean.getName());
    }

    private void initLister() {

    }

    //    返回键
    public void backMain(View view) {
        finish();
    }
}
