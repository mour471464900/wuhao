package com.qianfeng.toplevel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.Hot;
import com.qianfeng.toplevel.bean.HotContent;
import com.qianfeng.toplevel.utils.URLConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是热门的Fragment
 */
public class HotFragment extends Fragment {

    @BindView(R.id.gridview_fragment_hot)
    PullToRefreshGridView mGridView;
    private List<Hot.DataBean.ItemsBean.SeconderDataBean> dataBeanList;
    private HotAdapter hotAdapter;
    private Hot hot;

    //    实体类的集合
    public static HotFragment newInstace(Bundle args) {
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        ButterKnife.bind(this, view);
        setupGridView();
//       显示GridView
        return view;
    }

    private void setupGridView() {
        dataBeanList=new ArrayList<>();
           initData();
//         初始化数据
           initAdapter();
//         初始化适配 器
          bindAdapter();
//        绑定适配器
         initLister();
//         对gridview进行监听

    }

    private void initLister() {
//        到底部的时候让加载跟多数据
        refurbishGridview();

    }

    private void refurbishGridview() {
        mGridView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                OkHttpTool.newInstance().start(hot.getData().getPaging().getNext_url()).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson=new Gson();
                        hot = gson.fromJson(result, Hot.class);
                        List<Hot.DataBean.ItemsBean> items = hot.getData().getItems();
                        for (int i = 0; i <items.size() ; i++) {
                            dataBeanList.add(items.get(i).getData());
//                            将新的对象
                        }
                        hotAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void bindAdapter() {
       mGridView.setAdapter(hotAdapter);
    }

    private void initAdapter() {
         hotAdapter = new HotAdapter();
    }

    private void initData() {
        OkHttpTool.newInstance().start(URLConstants.URL_HOT).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                hot= gson.fromJson(result, Hot.class);
                List<Hot.DataBean.ItemsBean> items = hot.getData().getItems();
                for (int i = 0; i <items.size() ; i++) {
                    dataBeanList.add(items.get(i).getData());
                }
                hotAdapter.notifyDataSetChanged();
            }
        });
    }

//    z这是gridview 的适配器
    class HotAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataBeanList.get(position);
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
                        inflate(R.layout.gridview_hot_item, null);
                viewHolder = new ViewHolder();
                viewHolder.iv_show =
                        (ImageView) convertView.findViewById(R.id.iv_fragment_hot_show);
                viewHolder.tv_name =
                        (TextView) convertView.findViewById(R.id.tv_fragment_hot_name);
                viewHolder.tv_favorite=
                        (TextView) convertView.findViewById(R.id.tv_fragment_hot_like_count);
                viewHolder.tv_price =
                        (TextView) convertView.findViewById(R.id.tv_fragment_hot_price);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(getActivity()).load(dataBeanList.get(position).getCover_image_url())
                    .into( viewHolder.iv_show);
            viewHolder.tv_name.setText(dataBeanList.get(position).getName());
            viewHolder.tv_favorite.setText(""+dataBeanList.get(position).getFavorites_count());
            viewHolder.tv_price.setText(dataBeanList.get(position).getPrice());
            return convertView;
        }
    }

    class ViewHolder {
        ImageView iv_show;
        TextView tv_price;
        TextView tv_favorite;
        TextView tv_name;
    }
}
