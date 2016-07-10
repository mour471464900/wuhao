package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.activity.CheckAllActivity;
import com.qianfeng.toplevel.activity.CheckAllTopActivity;
import com.qianfeng.toplevel.activity.StrategyDetailsActivity;
import com.qianfeng.toplevel.adapter.BottomChildAdapter;
import com.qianfeng.toplevel.adapter.ColumnAdapter;
import com.qianfeng.toplevel.adapter.RightGridViewAdapter;
import com.qianfeng.toplevel.bean.ColumnBean;
import com.qianfeng.toplevel.bean.SecondAdvert;
import com.qianfeng.toplevel.bean.SingleProductBean;
import com.qianfeng.toplevel.bean.StrategyBean;
import com.qianfeng.toplevel.utils.URLConstants;
import com.qianfeng.toplevel.widget.CustomGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * z这是分类页面里面的攻略fragment
 */
public class StrategyFragment extends Fragment {
    @BindView(R.id.expand_listview_gonglv_yemian)
    ExpandableListView mExpandableListView;
    private List<StrategyBean.DataBean.ChannelGroupsBean> mList;
    //    主题实体类的集合
    private Map<String,
            List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean>> map;
    //    map
    private List<String> titles;
    private BottomAdapter bottomAdapter;

    private View headView;
    private RecyclerView recyclerView;
    private List<ColumnBean.DataBean.ColumnsBean> topList;
    private ColumnAdapter columnAdapter;
    private TextView tv_button;
    private ColumnBean columnBean;

    public static StrategyFragment newInstanceP(Bundle args) {
        StrategyFragment fragment = new StrategyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_strategy, container, false);
        ButterKnife.bind(this, view);
        setupExpandableListView();
//        设置expandableListView
        setupHeadView();
//        添加头部视图
        return view;
    }

    private void setupHeadView() {
//        给listview添加头部视图
        initHeadView();
//        c初始化头部
        initHeadData();
//        加载数据
        initHeadAdapter();
//        初始化适配器
        bindHeadAdapter();
//        设监听
        initHeadListener();
    }

//    这是栏目 旁边的 ，“查看全部”的点击监听
    private void initHeadListener() {
        tv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CheckAllTopActivity.class);
                intent.putExtra("bean",columnBean);
                startActivity(intent);
            }
        });
    }

    private void initHeadView() {
        headView = LayoutInflater.from(getActivity()).
                inflate(R.layout.item_expand_listview_gonglv_hearder, null);
        recyclerView = (RecyclerView) headView.findViewById(R.id.recycler_content_head_bottom);
//        找到头部布局，以及里面的recyleview ,和上方查看全部的按钮
         tv_button =(TextView)headView.findViewById(R.id.tv_chakan_head_button);
//        这是查看全部的按钮
    }

    private void initHeadData() {
        topList = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.STRATEGY_TOP).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
               columnBean = gson.fromJson(result, ColumnBean.class);
                List<ColumnBean.DataBean.ColumnsBean> list = new
                        ArrayList<ColumnBean.DataBean.ColumnsBean>();
                list.addAll(columnBean.getData().getColumns());
                for (int i = 0; i < 12; i++) {
                    topList.add(list.get(i));
                }
                columnAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initHeadAdapter() {
        columnAdapter = new ColumnAdapter(topList, getActivity());
    }

    private void bindHeadAdapter() {
        mExpandableListView.addHeaderView(headView);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3,
                LinearLayoutManager.HORIZONTAL, false);
//        一个横向的gridview的流失布局
//        recycleview 的布局管理器
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(columnAdapter);
    }


    //    -----------------这是设置listview 的内容的
    private void setupExpandableListView() {
        initData();
//        加载数据
        initAdapter();
//        初始化适配器
        bindAdapter();
    }

    private void bindAdapter() {
        mExpandableListView.setAdapter(bottomAdapter);
    }

    private void initAdapter() {
        bottomAdapter = new BottomAdapter();
    }

    private void initData() {
        mList = new ArrayList<>();
        map = new HashMap<>();
        titles = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.STRATEGY_BOTTOM).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                StrategyBean strategyBean = gson.fromJson(result, StrategyBean.class);
                mList.addAll(strategyBean.getData().getChannel_groups());
                initMap(mList);
//                更新map
                bottomAdapter.notifyDataSetChanged();
                spreadExpandableView();
//                展开expandablelistview
            }
        });
    }

    private void spreadExpandableView() {
        //                                设置ExpandListView 点击不收缩
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
//        让每个组都展开
        for (int i = 0; i < titles.size(); i++) {
            mExpandableListView.expandGroup(i);
        }
    }

    /**
     * 将数据填入到map，和集合中
     */
    private void initMap(List<StrategyBean.DataBean.ChannelGroupsBean> mList) {
        for (int i = 0; i < mList.size(); i++) {
            List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> list = new ArrayList<>();
            list.addAll(mList.get(i).getChannels());
            map.put(mList.get(i).getName(), list);
            titles.add(mList.get(i).getName());
        }
    }

    /**
     *
     */
    //-------------------------这是expandlistview 的适配器----------------------------
    class BottomAdapter extends BaseExpandableListAdapter {

        //        返回分组 数目的长度
        @Override
        public int getGroupCount() {
            return map == null ? 0 : titles.size();
        }

        //      返回  每一个组的  子条目的长度
        @Override
        public int getChildrenCount(int groupPosition) {
            //   这是嵌套的GridView
            //  返回值必须为1，否则会重复数据
//            因为只有一个子类就是recyleview
            return 1;
        }

        //        返回每一组的数据
        @Override
        public Object getGroup(int groupPosition) {
            return titles.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
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
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_expand_listview_gonglv_top, null);
                groupViewHolder = new GroupViewHolder(view);
            } else {
                groupViewHolder = (GroupViewHolder) view.getTag();
            }
            String groupName = titles.get(groupPosition);
            List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> bean
                    = new ArrayList<>();
            bean.addAll(map.get(groupName));
            if (bean.size() <= 6) {
                groupViewHolder.mRightText.setVisibility(View.GONE);
            }else {
                groupViewHolder.mRightText.setTag(groupPosition);
            }
            groupViewHolder.mLeftTxt.setText(titles.get(groupPosition));
            return view;
        }


        //       每一组  holder View
        class GroupViewHolder implements View.OnClickListener {
            @BindView(R.id.tv_gonglv_name)
            TextView mLeftTxt;
            @BindView(R.id.tv_chakan_button)
            TextView mRightText;
            public GroupViewHolder(View view) {
                view.setTag(this);
                ButterKnife.bind(this, view);
                mRightText.setOnClickListener(this);
            }
//          这是品类，风格，以及对象，右边“查看全部” 的点击监听
            @Override
            public void onClick(View v) {
                   try{
                       int position = Integer.parseInt(v.getTag().toString());
                       Intent intent = new Intent(getActivity(),CheckAllActivity.class);
                       StrategyBean.DataBean.ChannelGroupsBean channelGroupsBean = mList.get(position);
                       intent.putExtra("bean",  channelGroupsBean);
//                       将对象传过去
                       startActivity(intent);
                   }catch (NumberFormatException e){
                       e.printStackTrace();
                   }
            }
        }

        //     每一组的子 控件的适配器
        //       如何加载子控件的数据
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = convertView;
            ChildViewHolder childViewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_expand_listview_gonglv_bottom, null);
                childViewHolder = new ChildViewHolder(view);
            } else {
                childViewHolder = (ChildViewHolder) view.getTag();
            }
//            通过组名来得到，当前集合位置的
            String groupName = titles.get(groupPosition);
            List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> bean
                    = new ArrayList<>();
            bean.addAll(map.get(groupName));
            List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> newList =
                    new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                newList.add(bean.get(i));
            }
//            保证只有六个item
            BottomChildAdapter bottomChildAdapter = new BottomChildAdapter(getActivity(),
                    R.layout.item_expand_listview_gonglv_bottom_child, newList);
            childViewHolder.gridView.setAdapter(bottomChildAdapter);
            bottomChildAdapter.notifyDataSetChanged();

            return view;
        }

        class ChildViewHolder {
            @BindView(R.id.gv_content_bottom)
            CustomGridView gridView;
            public ChildViewHolder(View view) {
                view.setTag(this);
                ButterKnife.bind(this, view);
            }
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
//            这是expandelistview的，子类点击是否有效的意思
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
