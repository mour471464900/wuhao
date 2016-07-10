package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.SingleProductBean;
import com.qianfeng.toplevel.bean.StrategyBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hao on 2016/7/8.
 */
public class BottomChildAdapter extends CommonAdapter<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> {
    private Context context;
    private int layoutId;
    private List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> list;
    public BottomChildAdapter(Context context, int layoutId, List<StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> list) {
        super(context, layoutId, list);
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }
    @Override
    public void convert(ViewHolderM holderM, StrategyBean.DataBean.ChannelGroupsBean.ChannelsBean bean) {
        ImageView icon = (ImageView) holderM.getView(R.id.iv_gonglv_child_show);
        Picasso.with(context).load(bean.getCover_image_url()).into(icon);
    }
}
