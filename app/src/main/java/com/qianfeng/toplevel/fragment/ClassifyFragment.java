package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是分类的Fragment
 */
public class ClassifyFragment extends Fragment {

    @BindView(R.id.tablayout_classify_top)
    TabLayout mTabLayout;
    @BindView(R.id.vp_classify_bottom)
    ViewPager mViewPager;
    @BindView(R.id.tv_classify_xuanli_shengqi)
    TextView tv_classify_xuanli_shengqi;
    @BindView(R.id.tv_classify_search)
    TextView tv_classify_search;
    private List<Fragment> mFragmentList;
    private List<String> titles;
    private ViewPagerAdapter viewPagerAdapter;

    public static ClassifyFragment newInstance(Bundle args) {
        ClassifyFragment fragment = new ClassifyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        ButterKnife.bind(this, view);
        setupViewPager();
//        设置viewpager的内容
        return view;
    }

    private void setupViewPager() {
        initFragment();
//        初始化Fragment
        initTitles();
//        初始化标题
        initAdapter();
//        初始化适配器
        bindAdapter();
//        关联适配器
        initListener();
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tv_classify_xuanli_shengqi.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        tv_classify_xuanli_shengqi.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        SingleProductFragment fragment1 = SingleProductFragment.newInstance(null);
        StrategyFragment fragment2 = StrategyFragment.newInstanceP(null);
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add("攻略");
        titles.add("单品");
    }

    private void initAdapter() {
        FragmentManager manager = getChildFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(manager, mFragmentList, titles);
    }

    private void bindAdapter() {
//      设置适配器
        mViewPager.setAdapter(viewPagerAdapter);
        //        关联viewpager
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
