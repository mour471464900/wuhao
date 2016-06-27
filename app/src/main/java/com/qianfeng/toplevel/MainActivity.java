package com.qianfeng.toplevel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import com.qianfeng.toplevel.fragment.CullingFragment;
import com.qianfeng.toplevel.fragment.OtherFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp_main_content)
    ViewPager mViewPager;
    @BindView(R.id.tl_main_top)
    TabLayout table;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titlsList = new ArrayList<>();
    private MyViewPager adapter;

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
        table.setupWithViewPager(mViewPager);
    }

    private void bindAdapter() {
        mViewPager.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyViewPager(getSupportFragmentManager());
    }

    private void initData() {
        initFragment();
//         初始化Fragment
        initTableList();
//       初始化tableLayout的上方的文字

    }

    private void initTableList() {
         titlsList.add("精选");
         titlsList.add("海淘");
         titlsList.add("送女票");
         titlsList.add("创意生活");
         titlsList.add("送基友");
    }

    private void initFragment() {
        CullingFragment fragment1 = CullingFragment.newInstace(null);
        OtherFragment fragment2 = OtherFragment.newInstance(null);
        OtherFragment fragment3 = OtherFragment.newInstance(null);
        OtherFragment fragment4 = OtherFragment.newInstance(null);
        OtherFragment fragment5 = OtherFragment.newInstance(null);
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        fragmentList.add(fragment5);
    }

    class MyViewPager extends FragmentPagerAdapter{

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
//            返回位置
        }

        @Override
        public int getCount() {
            return fragmentList==null ? 0 : fragmentList.size();
        }

//        调加table上面的名字
        @Override
        public CharSequence getPageTitle(int position) {
            return  titlsList.get(position);

        }
    }


}
