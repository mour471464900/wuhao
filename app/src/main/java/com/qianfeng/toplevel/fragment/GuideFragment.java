package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.toplevel.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
   指南的Fragment
 */
public class GuideFragment extends Fragment {

    @BindView(R.id.vp_guide_content)
    ViewPager mViewPager;
    @BindView(R.id.tl_guide_top)
    TabLayout table;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titlsList = new ArrayList<>();
    private MyViewPager adapter;

    public  static   GuideFragment newInstace(Bundle args){
        GuideFragment fragment=new GuideFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this,view);

        initData();
//    初始化数据源
        initAdapter();
//       初始化适配器
        bindAdapter();
//        绑定适配器
        table.setupWithViewPager(mViewPager);
        return  view;
    }
    private void bindAdapter() {
        mViewPager.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyViewPager(getChildFragmentManager());
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
        for (int i = 0; i < titlsList.size(); i++) {
            //创建Tab:mTabLayout.newTab()
            //设置Tab内容:tab.setText(内容);
            table.addTab(table.newTab().setText(titlsList.get(i)));
        }
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

    class MyViewPager extends FragmentStatePagerAdapter {
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
