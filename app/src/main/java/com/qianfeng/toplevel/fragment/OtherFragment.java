package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.activity.BannerActivity;
import com.qianfeng.toplevel.bean.CullingBean;
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
    @BindView(R.id.other_refresh_view)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.other_recycler_view)
    RecyclerView mRecyclerView;
    private List<CullingBean.DataBean.ItemsBean> itemsBeanList;
    private MyRecylerAdapter myRecylerAdapter;

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
        Log.i("wuhao", "onAttach: "+id);
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
        initRecylerViewManger();
//        设置recyclecview 的布局管理器
        initData();
//        准备数据源
        initAdapter();
//        初始化适配器
        bindAdapter();
//        绑定适配器
        initListener();
//        设置监听
    }

    private void initListener() {
//        设置
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    private void initRecylerViewManger() {
        //        创建一个布局的管理器
        LinearLayoutManager manager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }


    private void initData() {
        itemsBeanList=new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_START + id + URLConstants.URL_END)
                .callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        CullingBean cullingBean = gson.fromJson(result, CullingBean.class);
                        itemsBeanList.addAll(cullingBean.getData().getItems());
                        myRecylerAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void initAdapter() {
        myRecylerAdapter = new MyRecylerAdapter();
    }

    private void bindAdapter() {
        mRecyclerView.setAdapter(myRecylerAdapter);
    }


    class HeardViewHodler extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView mTextView;
        public TextView getmTextView;

        //      创建一个imageView
        public HeardViewHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_child_show);
            mTextView = (TextView) itemView.findViewById(R.id.tv_child_show);
            getmTextView = (TextView) itemView.findViewById(R.id.tv_child_jianjie);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
//                这是横向的recycleView的监听事件
                public void onClick(View v) {
                    try {
                        int position = Integer.parseInt(v.getTag().toString());
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
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_child_item, null);
            return new HeardViewHodler(view);
        }

        @Override
        public void onBindViewHolder(HeardViewHodler holder, int position) {
            holder.imageView.setTag(position);
            Picasso.with(getActivity()).load(itemsBeanList.get(position).getCover_image_url())
                    .into(holder.imageView);
            holder.mTextView.setText("  " + itemsBeanList.get(position).getLikes_count());
            holder.getmTextView.setText(itemsBeanList.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return itemsBeanList == null ? 0 : itemsBeanList.size();
        }
    }


}
