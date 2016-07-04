package com.qianfeng.toplevel.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.activity.BannerActivity;
import com.qianfeng.toplevel.activity.StrategyDetailsActivity;
import com.qianfeng.toplevel.bean.CullingBean;
import com.qianfeng.toplevel.bean.FristAdvert;
import com.qianfeng.toplevel.bean.SecondAdvert;
import com.qianfeng.toplevel.utils.HttpUtil;
import com.qianfeng.toplevel.utils.IRequestCallBack;
import com.qianfeng.toplevel.utils.URLConstants;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    PullToRefreshExpandableListView mListView;
    //    头部的广告的
    private List<String> fristUrls;
    //    中部广告的
    private List<String> secondeUrls;
    private Map<String, List<CullingBean.DataBean.ItemsBean>> map = new HashMap<>();
    //    初始化数据源的 listView 的条目信息
    private List<String> dates = new ArrayList<>();
    private MyListViewAdapter adapter;
    private ProgressDialog dialog;
    private View hearderView;
    private ConvenientBanner convenientBanner;
    private View hearder2;
    private HorizontalScrollView horizontalScrollView;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private MyRecylerAdapter myRecylerAdapter;
    private List<FristAdvert.DataBean.BannersBean> firstBanner;
    private List<SecondAdvert.DataBean.SecondaryBannersBean> secondList;
    private List<CullingBean.DataBean.ItemsBean> itemsBeanList = new ArrayList<>();
    private ExpandableListView refreshableView;
    private CullingBean advert;

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
        refreshableView = mListView.getRefreshableView();
        hearderView = inflater.inflate(R.layout.listview_culling_hearder, null);
//        找到头部视图
        convenientBanner = (ConvenientBanner) hearderView.findViewById(R.id.cb_culling_top);
        hearder2 = inflater.inflate(R.layout.listview_culling_scroll_hearder2, null);
        recyclerView = (RecyclerView) hearder2.findViewById(R.id.recycler_culling_hearder);
//      初始化黄油刀的fragment
        initExpandListView();
//        改变ExpandListView
        refreshableView.addHeaderView(hearderView);
//        添加了
        refreshableView.addHeaderView(hearder2);
        initListener();
        return view;
    }

    private void initListener() {
//        设置下拉加载更多的数据 ,实验失败先将这块代码注释
//        mListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
//            @Override
//            public void onLastItemVisible() {
//                OkHttpTool.newInstance().start(advert.getData().
//                        getPaging().getNext_url()).callback(new IOKCallBack() {
//                    @Override
//                    public void success(String result) {
//                        Gson gson = new Gson();
//                       CullingBean  advert = gson.fromJson(result, CullingBean.class);
//                        CullingBean.DataBean data = advert.getData();
//                        itemsBeanList.addAll(data.getItems());
//                        setUpBottmBanner(itemsBeanList);
//                        myRecylerAdapter.notifyDataSetChanged();
//                    }
//                });
//            }
//        });
//        这是第一栏广告的鉴听事件
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FristAdvert.DataBean.BannersBean bannersBean = firstBanner.get(position);
                Intent intent = new Intent(getActivity(), BannerActivity.class);
                startActivity(intent);
            }
        });
//        这是每个条目的鉴听跳转到攻略详情页面的
        refreshableView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String groupName = dates.get(groupPosition);
                List<CullingBean.DataBean.ItemsBean> bean = map.get(groupName);
                int item_id = bean.get(childPosition).getId();
                Intent intent = new Intent(getActivity(), StrategyDetailsActivity.class);
                intent.putExtra("item_id", item_id);
                startActivity(intent);
                return true;
            }
        });
    }

    private void initExpandListView() {

        initData();
//        初始化数据源
        initAdapter();
//        初始化适配器
        bindAdapter();
//        绑定适配
        initFirstCb();
//        加载一栏的广告
        initSecondCb();
//        加载第二栏的广告
    }

    //--------------------第二栏广告的数据--------------------
    private void initSecondCb() {
        secondeUrls = new ArrayList<>();
        secondList = new ArrayList<>();
        HttpUtil.requestGet(URLConstants.URL_SECONDCB, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                SecondAdvert advert = gson.fromJson(result, SecondAdvert.class);
                SecondAdvert.DataBean dataBean = advert.getData();
                secondList.addAll(dataBean.getSecondary_banners());
                for (int i = 0; i < secondList.size(); i++) {
                    secondeUrls.add(secondList.get(i).getImage_url());
                }

                myRecylerAdapter.notifyDataSetChanged();
                //                                设置ExpandListView 点击不收缩
                refreshableView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        return true;
                    }
                });
//        让每个组都展开
                for (int i = 0; i < dates.size(); i++) {
                    refreshableView.expandGroup(i);
                }
            }
        });
        setUpRecylerView();
    }

    private void setUpRecylerView() {
//        创建一个布局的管理器
        LinearLayoutManager manager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
//        添加一个了布局管理器
        myRecylerAdapter = new MyRecylerAdapter();
        recyclerView.setAdapter(myRecylerAdapter);
    }

    //----------------
    class HeardViewHodler extends RecyclerView.ViewHolder {
        public ImageView imageView;

        //      创建一个imageView
        public HeardViewHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_secondebanner_item);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
//                这是横向的recycleView的监听事件
                public void onClick(View v) {
                    try {
                        int position = Integer.parseInt(v.getTag().toString());
                        SecondAdvert.DataBean.SecondaryBannersBean secondaryBannersBean = secondList.get(position);
                        secondaryBannersBean.getId();
                        Intent intent = new Intent(getActivity(), BannerActivity.class);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    class MyRecylerAdapter extends RecyclerView.Adapter<HeardViewHodler> {
        @Override
        public HeardViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.secondbanner_item, null);
            return new HeardViewHodler(view);
        }

        @Override
        public void onBindViewHolder(HeardViewHodler holder, int position) {
            holder.imageView.setTag(position);
            Picasso.with(getActivity()).load(secondeUrls.get(position)).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return secondeUrls == null ? 0 : secondeUrls.size();
        }
    }


    //-------------加载第一栏广告的--------------------------
    private void initFirstCb() {
        fristUrls = new ArrayList<>();
        firstBanner = new ArrayList<>();
        HttpUtil.requestGet(URLConstants.URL_FIRSTCB, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FristAdvert advert = gson.fromJson(result, FristAdvert.class);
                FristAdvert.DataBean dataBean = advert.getData();
                firstBanner.addAll(dataBean.getBanners());
                for (int i = 0; i < firstBanner.size(); i++) {
                    fristUrls.add(firstBanner.get(i).getImage_url());
                }
                setUpConvenientBanner();
            }
        });
    }

    private void setUpConvenientBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, fristUrls)
//                这个urls 是图片的地址的集合
                //设置需要切换的View
                .setPointViewVisible(true)    //设置指示器是否可见
                .setPageIndicator(new int[]{R.drawable.btn_check_disabled,
                        R.drawable.btn_check_disabled_nightmode})   //设置指示器圆点
                .startTurning(3000)     //设置自动切换（同时设置了切换时间间隔）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL); //设置指示器位置（左、中、右）
    }

    public class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
//           map 就是单个图片的地址
            Picasso.with(getActivity()).load(data).into(imageView);

        }
    }

    //---------------------下面是expandListView 的适配器--------------------
    private void bindAdapter() {
        refreshableView.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new MyListViewAdapter();
    }

    private void initData() {
        if (dates != null && !dates.isEmpty()) {
            return;
        }
//       这个if循环是为了解决，数据重复加载的问题
//       解决viewpager的数据重载的问题
        HttpUtil.requestGet(URLConstants.URL_CULLING, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                advert = gson.fromJson(result, CullingBean.class);
                CullingBean.DataBean data = advert.getData();
                itemsBeanList.addAll(data.getItems());
                setUpBottmBanner(itemsBeanList);
                myRecylerAdapter.notifyDataSetChanged();
            }
        });
    }

    //    通过对象的集合，生成一个map，对象
    private void setUpBottmBanner(List<CullingBean.DataBean.ItemsBean> itemsBeanList) {
        List<CullingBean.DataBean.ItemsBean> list = new ArrayList<>();
//        先重新new一集合
        list.add(itemsBeanList.get(0));
//        先有第一个先new一个list
        String date = returnDate(itemsBeanList.get(0).getCreated_at());
//        先有第一个date的数据
        dates.add(date);
        for (int i = 1; i < itemsBeanList.size(); i++) {
            if (date.equals(returnDate(itemsBeanList.get(i).getCreated_at()))) {
//                如果不是同一个星期就不断的加到就把bean对象加到list中去
                list.add(itemsBeanList.get(i));
//         如果第二个对象的data数据不等于
            } else {
                map.put(date, list);
//
                list.add(itemsBeanList.get(i));
                date = returnDate(itemsBeanList.get(i).getCreated_at());
//                当一个见
                dates.add(date);
                list = new ArrayList<>();
                map.put(date, list);
            }
        }
    }

    //   这是将毫秒转换成日期的方法
    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
        String now = sdf.format(new Date(time * 1000));
        return now;
    }


    //-------------------------这是expandlistview 的适配器----------------------------
    class MyListViewAdapter extends BaseExpandableListAdapter {
        //        返回分组 数目的长度
        @Override
        public int getGroupCount() {
            return map == null ? 0 : dates.size();
        }

        //      返回  每一个组的  子条目的长度
        @Override
        public int getChildrenCount(int groupPosition) {
            String key = dates.get(groupPosition);
//            得到组的 key
            List<CullingBean.DataBean.ItemsBean> childList = map.get(key);
            return childList == null ? 0 : childList.size();
        }

        //        返回每一组的数据
        @Override
        public Object getGroup(int groupPosition) {
            return dates.get(groupPosition);
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
            groupViewHolder.mLeftTxt.setText(dates.get(groupPosition));
            return view;
        }

        //       每一组  holder View
        class GroupViewHolder {
            @BindView(R.id.tv_group_left)
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
                view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_child_item, null);
                childViewHolder = new ChildViewHolder(view);
            } else {
                childViewHolder = (ChildViewHolder) view.getTag();
            }
//            通过组名来得到，当前集合位置的
            String groupName = dates.get(groupPosition);
            List<CullingBean.DataBean.ItemsBean> bean = map.get(groupName);
            Picasso.with(getActivity()).load(bean.get(childPosition).getCover_image_url()).
                    into(childViewHolder.mImageView);
//               改变图片
            childViewHolder.mTextView.setText("  " + bean.get(childPosition).getLikes_count());
//                改变文字
            childViewHolder.getmTextView.setText(bean.get(childPosition).getTitle());
            return view;
        }

        class ChildViewHolder {
            @BindView(R.id.iv_child_show)
            ImageView mImageView;
            @BindView(R.id.tv_child_show)
            TextView mTextView;
            @BindView(R.id.tv_child_jianjie)
            TextView getmTextView;

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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
