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

import com.google.gson.Gson;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.ClassifyBean;
import com.qianfeng.toplevel.utils.HttpUtil;
import com.qianfeng.toplevel.utils.IRequestCallBack;
import com.qianfeng.toplevel.utils.URLConstants;

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
    private  List< ClassifyBean.DataEntity.ChannelsEntity > mlist=new ArrayList<>();
//    分类对象的
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
        return  view;
    }
    private void bindAdapter() {
        mViewPager.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyViewPager(getChildFragmentManager());
    }

    private void initData() {
        HttpUtil.requestGet(URLConstants.URL_BASE, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ClassifyBean bean  =gson.fromJson(result, ClassifyBean.class);
                ClassifyBean.DataEntity dataEntity=bean.getData();
                mlist=new ArrayList<>();
                mlist.addAll(dataEntity.getChannels());
                for (int i = 0; i <mlist.size() ; i++) {
                    String title = mlist.get(i).getName();
                    titlsList.add(title);
                }
                initFragment();
//         初始化Fragment
                initTableList();
//       初始化tableLayout的上方的文字
                initAdapter();
//       初始化适配器
                bindAdapter();
//        绑定适配器
                table.setupWithViewPager(mViewPager);
            }
        });

    }

    private void initTableList() {
        for (int i = 0; i < titlsList.size(); i++) {
            //创建Tab:mTabLayout.newTab()
            //设置Tab内容:tab.setText(内容);
            table.addTab(table.newTab().setText(titlsList.get(i)));
        }
    }

    private void initFragment() {
        CullingFragment fragment1 = CullingFragment.newInstace(null);
        fragmentList.add(fragment1);
//        从第二个位置开始
        for (int i = 1; i <titlsList.size() ; i++) {
            Bundle bundle=new Bundle();
            bundle.putInt("id",mlist.get(i).getId());
            OtherFragment fragment=OtherFragment.newInstance(bundle);
            fragmentList.add(fragment);
        }
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
