package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.adapter.CheckAllTopAdapter;
import com.qianfeng.toplevel.bean.ColumnBean;
import com.qianfeng.toplevel.bean.StrategyBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckAllTopActivity extends AppCompatActivity {

    @BindView(R.id.gv_check_all_top)
    PullToRefreshListView mListView;
    @BindView(R.id.tv_check_all_top_title)
    TextView title;
    private ColumnBean columnBean;
    private CheckAllTopAdapter checkAllTopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_all_top);
        ButterKnife.bind(this);
        setupListView();
    }

    private void setupListView() {
        initData();
//         初始化数据
        initAdapter();
//         初始化适配 器
        bindAdapter();
//        绑定适配器
        initLister();
//         对gridview进行监听
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
          columnBean= (ColumnBean)
                    intent.getSerializableExtra("bean");
        }
    }

    private void initAdapter() {
        if ( columnBean.getData()!=null){
            checkAllTopAdapter = new CheckAllTopAdapter(this,
                    R.layout.item_expand_listview_gonglv_hearder_child,
                    columnBean.getData().getColumns());
        }

    }

    private void bindAdapter() {
      mListView.setAdapter(checkAllTopAdapter);
    }

    private void initLister() {

    }

    //   返回键
    public void backMain(View view) {
         finish();
    }
}
