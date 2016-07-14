package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.CullingBean;
import com.qianfeng.toplevel.bean.StrategyBean;
import com.qianfeng.toplevel.utils.URLConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这个是分类里面的
 * 攻略里面的 （品类，风格，对象）条目，点击之后的页面
 * 呈现一个出海淘，等页面的效果
 */
public class StrategyClickActivity extends AppCompatActivity {
    @BindView(R.id.lv_click_content)
    PullToRefreshListView mListView;
    @BindView(R.id.tv_click_title)
    TextView title;
    private StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean channelsBean;
    private int id;
    private CullingBean cullingBean;
    private List<CullingBean.DataBean.ItemsBean> itemsBeanList;
    private OtherAdapter otherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_clickctivityt);
        ButterKnife.bind(this);
        setupListView();
    }

    private void setupListView() {
        initData();
//         初始化数据
        initAdapter();
//         初始化适配 器
        bindAdapter();
//        绑定适配器
        initLister();
//         对gridview进行监听
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent.getSerializableExtra("bean") != null) {
            channelsBean =
                    (StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean)
                            intent.getSerializableExtra("bean");
            title.setText(channelsBean.getName()); // 设置标题
            id = channelsBean.getId();   // 得到id
        }
        initListViewData();
    }

    /**
     * 异步任务取得
     * 设置listview 的数据
     */
    private void initListViewData() {
        itemsBeanList=new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.CLICK_START+id+URLConstants.CLICK_END)
                .callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
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
       mListView.setAdapter(otherAdapter);
    }

    private void initLister() {
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
                Intent intent=new Intent(StrategyClickActivity.this, StrategyDetailsActivity.class);
                intent.putExtra("item_id",item_id);
                startActivity(intent);
            }
        });
    }

    //    返回键
    public void backMain(View view) {
        finish();
    }

//    弹窗的PopupWindow的显示
    public void PopupWindow(View view) {


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
                convertView = LayoutInflater.from(StrategyClickActivity.this).
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
            Picasso.with(StrategyClickActivity.this).
                    load(itemsBeanList.get(position).getCover_image_url())
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
