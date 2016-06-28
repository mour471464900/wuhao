package com.qianfeng.toplevel.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.toplevel.R;

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
    private Map< String ,List<String>> data=new HashMap<>();
//    初始化数据源的 listView 的条目信息
   private List<String> groupNams =new ArrayList<>();
    private MyListViewAdapter adapter;

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
//      初始化黄油刀的fragment
        initExpandListView();
//        改变ExpandListView
        return view;
    }

    private void initExpandListView() {
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
        for (int i = 0; i <groupNams.size() ; i++) {
            mListView.expandGroup(i);
        }

    }

    private void bindAdapter() {
     mListView.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyListViewAdapter();
    }

    private void initData() {
        for (int i = 0; i <10 ; i++) {
            String Group="龙王传说"+i;
            groupNams.add(Group);
            ArrayList<String >  childData=new ArrayList<>();
            data.put(Group,childData);
            for(int j=0;j<10;j++){
                childData.add("第"+j+"章");
            }
        }
    }

    class MyListViewAdapter extends BaseExpandableListAdapter{

//        返回分组 数目的长度
        @Override
        public int getGroupCount() {
            return data==null ? 0 : groupNams.size();
        }
//      返回  每一个组的  子条目的长度
        @Override
        public int getChildrenCount(int groupPosition) {
            String key= groupNams.get(groupPosition);
//            得到组的 key
            List<String> mList=data.get(key);
            return mList==null ? 0 : mList.size();
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
                ButterKnife.bind(this,view);
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
                ButterKnife.bind(this,view);
            }
        }
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
