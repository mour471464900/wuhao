package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.activity.BannerActivity;
import com.qianfeng.toplevel.activity.StrategyDetailsActivity;
import com.qianfeng.toplevel.bean.CullingBean;
import com.qianfeng.toplevel.bean.Hot;
import com.qianfeng.toplevel.utils.URLConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是页面的Fragment
 */
public class OtherFragment extends Fragment {

    private int id;
    //   得到网址的id
    @BindView(R.id.other_refresh_listview)
    PullToRefreshListView mListView;
    private List<CullingBean.DataBean.ItemsBean> itemsBeanList;
    private ListView listView;
    private OtherAdapter otherAdapter;
    private CullingBean cullingBean;

    public static OtherFragment newInstance(Bundle args) {
        OtherFragment fragment = new OtherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        ButterKnife.bind(this, view);

//        执行recyleview的加载
        setupRecylerView();
        return view;
    }

    private void setupRecylerView() {
        setupListView();
//        设置listview的属性
        initData();
//        准备数据源
        initAdapter();
//        初始化适配器
        bindAdapter();
//        绑定适配器
        initListener();
//        设置监听
    }

    private void setupListView() {
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
//        上啦和下拉都有作用
        listView = mListView.getRefreshableView();
//        设置下拉加载
        itemsBeanList = new ArrayList<>();
    }

    private void initListener() {
//          设置下拉刷新
        mListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                OkHttpTool.newInstance().start(cullingBean.getData().getPaging().getNext_url())
                        .callback(new IOKCallBack() {
                            @Override
                            public void success(String result) {
                                Gson gson = new Gson();
                                cullingBean = gson.fromJson(result, CullingBean.class);
//                                将culling变成全局变量，每次下拉的都重新生成了下一页的对象
                                itemsBeanList.addAll(cullingBean.getData().getItems());
//                                每次的新数据都加到itembeanlist的集合中去了
                                otherAdapter.notifyDataSetChanged();
                            }
                        });
            }
        });

//        设置的条目监听
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_id=itemsBeanList.get(position-1).getId();
                Intent intent=new Intent(getActivity(), StrategyDetailsActivity.class);
                intent.putExtra("item_id",item_id);
                startActivity(intent);
            }
        });
    }


    private void initData() {
        OkHttpTool.newInstance().start(URLConstants.URL_START + id + URLConstants.URL_END)
                .callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                    cullingBean = gson.fromJson(result, CullingBean.class);
                        itemsBeanList.addAll(cullingBean.getData().getItems());
                        otherAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void initAdapter() {
        otherAdapter = new OtherAdapter();
    }

    private void bindAdapter() {
        listView.setAdapter(otherAdapter);
    }

    class OtherAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemsBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemsBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).
                        inflate(R.layout.listview_child_item, null);
                viewHolder = new ViewHolder();
                viewHolder.imageView =
                        (ImageView) convertView.findViewById(R.id.iv_child_show);
                viewHolder.mTextView =
                        (TextView) convertView.findViewById(R.id.tv_child_show);
                viewHolder.getmTextView =
                        (TextView) convertView.findViewById(R.id.tv_child_jianjie);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(getActivity()).load(itemsBeanList.get(position).getCover_image_url())
                    .into(viewHolder.imageView);
            viewHolder.mTextView.setText("  " + itemsBeanList.get(position).getLikes_count());
            viewHolder.getmTextView.setText(itemsBeanList.get(position).getTitle());
            return convertView;
        }
    }

    class ViewHolder {
        ImageView imageView;
        TextView mTextView;
        TextView getmTextView;
    }
}
