package com.qianfeng.toplevel.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.utils.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 精选界面 的fragment
 */
public class CullingFragment extends Fragment {

    private View view;
    @BindView(R.id.expandLv_culling)
    ExpandableListView mListView;
    private Map<String, List<String>> data = new HashMap<>();
    //    初始化数据源的 listView 的条目信息
    private List<String> groupNams = new ArrayList<>();
    private MyListViewAdapter adapter;

    private ProgressDialog dialog;
    private View hearderView;
    private ConvenientBanner convenientBanner;
    private View hearder2;
    private HorizontalScrollView horizontalScrollView;
//    初始化广告牌

    //   分组名称的集合
    //    静态工厂模式
    public static CullingFragment newInstace(Bundle args) {
        CullingFragment fragment = new CullingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_culling, container, false);
        ButterKnife.bind(this, view);
        hearderView = inflater.inflate(R.layout.listview_culling_hearder, null);
//        找到头部视图
        convenientBanner = (ConvenientBanner) hearderView.findViewById(R.id.cb_culling_top);
        hearder2 = inflater.inflate(R.layout.listview_culling_scroll_hearder2,null);
        horizontalScrollView= (HorizontalScrollView) hearder2.findViewById(R.id.sv_culling_hearder);
//      初始化黄油刀的fragment
        initExpandListView();
//        改变ExpandListView
          mListView.addHeaderView(hearderView);
          mListView.addHeaderView(hearder2);
        return view;
    }

    private void initExpandListView() {
//        dialog = new ProgressDialog(getActivity());
//        dialog.setMessage("小宝在偷懒~");
        initData();
//        初始化数据源
        initAdapter();
//        初始化适配器
        bindAdapter();
//        绑定适配器
//        设置ExpandListView 点击不收缩
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
//        让每个组都展开
        for (int i = 0; i < groupNams.size(); i++) {
            mListView.expandGroup(i);
        }
//        setUpConvenientBanner();
    }


    //    加载广告数据
//    private void setUpConvenientBanner() {
//        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
//            @Override
//            public NetworkImageHolderView createHolder() {
//                return new NetworkImageHolderView();
//            }
//           }, urls)
////                这个urls 是图片的地址的集合
//                //设置需要切换的View
//                .setPointViewVisible(true)    //设置指示器是否可见
//                .setPageIndicator(new int[]{R.mipmap.iconoff, R.mipmap.iconon})   //设置指示器圆点
//                .startTurning(5000)     //设置自动切换（同时设置了切换时间间隔）
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT); //设置指示器位置（左、中、右）
//    }
//
//    public class NetworkImageHolderView implements Holder<String> {
//        private ImageView imageView;
//        @Override
//        public View createView(Context context) {
//            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
//            imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                }
//            });
//            return imageView;
//        }
//
//        @Override
//        public void UpdateUI(Context context, int position, String data) {
////            data 就是单个图片的地址
//            ImageLoader.loadImage(context,data, imageView);
//        }
//
//    }

    private void bindAdapter() {
        mListView.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyListViewAdapter();
    }

    private void initData() {
//        dialog.show();
        if (groupNams != null && !groupNams.isEmpty()) {
            return;
        }
//       这个if循环是为了解决，数据重复加载的问题
//       解决viewpager的数据重载的问题
        for (int i = 0; i < 10; i++) {
            String Group = "龙王传说" + i;
            groupNams.add(Group);
            ArrayList<String> childData = new ArrayList<>();
            data.put(Group, childData);
            for (int j = 0; j < 10; j++) {
                childData.add("第" + j + "章");
            }
        }

    }

    class MyListViewAdapter extends BaseExpandableListAdapter {

        //        返回分组 数目的长度
        @Override
        public int getGroupCount() {
            return data == null ? 0 : groupNams.size();
        }

        //      返回  每一个组的  子条目的长度
        @Override
        public int getChildrenCount(int groupPosition) {
            String key = groupNams.get(groupPosition);
//            得到组的 key
            List<String> mList = data.get(key);
            return mList == null ? 0 : mList.size();
        }

        //        返回每一组的数据
        @Override
        public Object getGroup(int groupPosition) {
            return groupNams.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        //     每一组的适配器
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View view = convertView;
            GroupViewHolder groupViewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_group_item, null);
                groupViewHolder = new GroupViewHolder(view);
            } else {
                groupViewHolder = (GroupViewHolder) view.getTag();
            }
            groupViewHolder.mLeftTxt.setText(groupNams.get(groupPosition));
            return view;
        }

        //       每一组  holder View
        class GroupViewHolder {
            @BindView(R.id.tv_group_left)
            TextView mLeftTxt;
            @BindView(R.id.tv_group_right)
            TextView mRightTxt;

            public GroupViewHolder(View view) {
                view.setTag(this);
                ButterKnife.bind(this, view);
            }
        }

        //     每一组的子 控件的适配器
//       如何加载子控件的数据
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = convertView;
            ChildViewHolder childViewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_child_item, null);
                childViewHolder = new ChildViewHolder(view);
            } else {
                childViewHolder = (ChildViewHolder) view.getTag();
            }
            childViewHolder.mImageView.setImageResource(R.mipmap.zhangyuqi2);
            return view;
        }

        class ChildViewHolder {
            @BindView(R.id.iv_child_show)
            ImageView mImageView;

            public ChildViewHolder(View view) {
                view.setTag(this);
                ButterKnife.bind(this, view);
            }
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
