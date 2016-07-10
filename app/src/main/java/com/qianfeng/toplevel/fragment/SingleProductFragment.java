package com.qianfeng.toplevel.fragment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.adapter.LeftAdapter;
import com.qianfeng.toplevel.adapter.RightGridViewAdapter;
import com.qianfeng.toplevel.bean.SingleProductBean;
import com.qianfeng.toplevel.utils.URLConstants;
import com.qianfeng.toplevel.widget.CustomGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是分类页面里面的单品fragment
 */
public class SingleProductFragment extends Fragment {

    @BindView(R.id.lv_sing_left_show_name)
    ListView mListView;
    @BindView(R.id.expand_listview_right_show)
    ExpandableListView mExpandableListView;
    private List<SingleProductBean.DataBean.CategoriesBean> cbList;
    private LeftAdapter leftAdapter;
    private Map<String,
            List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean>> map;
    //    这是expandlistview的map集合
    private List<String> titles;
    private RightListAdapter rightListAdapter;
    private RightGridViewAdapter rightGridViewAdapter;
    private ProgressDialog dialog;

    //
    public static SingleProductFragment newInstance(Bundle args) {
        SingleProductFragment fragment = new SingleProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_product, container, false);
        ButterKnife.bind(this, view);
//        黄油刀初始化
        initData();
//        初始化数据
        setupListView();
//        设置listview
        setupExpandableListView();
//        设置expandlistview
        return view;
    }

    private void initData() {
        cbList = new ArrayList<>();
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("吐血加载中~~~");
        dialog.show();
        OkHttpTool.newInstance().start(URLConstants.URL_SINGLE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                SingleProductBean singleProductBean = gson.fromJson(result, SingleProductBean.class);
                if (singleProductBean != null && singleProductBean.getData() != null) {  //空指针判断
                    cbList.addAll(singleProductBean.getData().getCategories());
                    leftAdapter.notifyDataSetChanged();
                    rightListAdapter.notifyDataSetChanged();
                    initMap(cbList);
//                初始化map数据
                    dialog.dismiss();//  弹窗消失
                    spreadExpandableView();
//                展开expandablelistview
                }
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

    private void initMap(List<SingleProductBean.DataBean.CategoriesBean> mList) {
        map = new HashMap<>();
        titles = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            titles.add(mList.get(i).getName());
            List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> childList
                    = new ArrayList();
            childList.addAll(mList.get(i).getSubcategories());
            map.put(mList.get(i).getName(), childList);
        }
    }

    private void setupListView() {
//        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
////        实现单选模式
        initLeftAdapter();
//        加载左边的适配器
        bindLeftAdapter();
//        绑定左边适配器
        initLeftListener();
//        左边的监听
    }

    private void initLeftListener() {
        clickListenerLeft();
//        点击监听
    }

    private void clickListenerLeft() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mExpandableListView.setSelectedGroup(position);
//                当listview 点击到那个位置的时候，ExpandableListView联动到组名
//                TextView textView = (TextView) view.findViewById(R.id.tv_item_sing_left_name);
//                View redView = view.findViewById(R.id.view_tv_item_sing_left_cursor);
//                textView.setTextColor(Color.RED);
//                redView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void bindLeftAdapter() {
        mListView.setAdapter(leftAdapter);
    }

    private void initLeftAdapter() {
        leftAdapter = new LeftAdapter(getActivity(),
                R.layout.item_lv_sing_left_show_name, cbList);
//        这个地方改使用，arrayAdapter的这样会比较好
    }

    private void setupExpandableListView() {
        initRightAdapter();
//        加载右边的适配器
        bindRightAdapter();
//        绑定右边适配器
        initRightListener();
//        右边的监听
    }

    private void initRightListener() {
        mExpandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private boolean flag;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                判断当左边滑动的时候右边是不滑动的
                if (scrollState != 0) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (flag) {
                    mListView.setSelection(firstVisibleItem);
//                     设置listview 的滑动到那个位置
                    mListView.setItemChecked(firstVisibleItem, true);
//                     设置listview 的滑动状态
                }
            }
        });

    }

    private void bindRightAdapter() {
        mExpandableListView.setAdapter(rightListAdapter);
    }

    private void initRightAdapter() {
        rightListAdapter = new RightListAdapter();
    }

    //-------------------------这是expandlistview 的适配器----------------------------
    class RightListAdapter extends BaseExpandableListAdapter {

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
//            因为只有一个子类就是GridView
            return 1;
        }

        //        返回每一组的数据
        @Override
        public Object getGroup(int groupPosition) {
            return titles.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            String groupName = titles.get(groupPosition);
            List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> bean
                    = new ArrayList<>();
            bean.addAll(map.get(groupName));
            return bean.get(childPosition);
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
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_expand_listview_show_name, null);
                groupViewHolder = new GroupViewHolder(view);
            } else {
                groupViewHolder = (GroupViewHolder) view.getTag();
            }
            groupViewHolder.mLeftTxt.setText(titles.get(groupPosition));
            return view;
        }

        //       每一组  holder View
        class GroupViewHolder {
            @BindView(R.id.tv_item_expand_listview_show_name)
            TextView mLeftTxt;

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
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_expand_listview_show_picture, null);
                childViewHolder = new ChildViewHolder(view);
            } else {
                childViewHolder = (ChildViewHolder) view.getTag();
            }
//            通过组名来得到，当前集合位置的
            String groupName = titles.get(groupPosition);
            List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> bean
                    = new ArrayList<>();
            bean.addAll(map.get(groupName));
            rightGridViewAdapter = new RightGridViewAdapter(getActivity(),
                    R.layout.item_gv_expand_listview_show_picture, bean);
            childViewHolder.gridView.setAdapter(rightGridViewAdapter);
            rightGridViewAdapter.notifyDataSetChanged();
            return view;
        }

        class ChildViewHolder {
            @BindView(R.id.gv_expand_listview_show_picture)
            CustomGridView gridView;

            //        自定义的gridvIEW 解决嵌套在listview或者srcollview的之后不展开情况
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
