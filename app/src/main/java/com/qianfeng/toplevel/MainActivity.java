package com.qianfeng.toplevel;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.qianfeng.toplevel.fragment.CullingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tl_main_top)
     TableLayout mTableLayout;
    @BindView(R.id.vp_main_content)
    ViewPager mViewPager;

    private  List<Fragment> fragmentList=new ArrayList<>();
//    fragment de JIHE
    private  List<String > titlsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       initData();
//    初始化数据源
      initAdapter();
//       初始化适配器
        bindAdapter();
//        绑定适配器
    }

    private void bindAdapter() {

    }

    private void initAdapter() {

    }

    private void initData() {
          initFragment();
//         初始化Fragment
        initTableList();
//       初始化tableLayout的上方的文字

    }

    private void initTableList() {

    }

    private void initFragment() {


    }
}
