package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.BannerListBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by my on 2016/6/20.
 */
public class BannerListAdapter extends CommonAdapter<BannerListBean.DataBean.PostsBean> {
    private Context context;
    private int layoutId;
    private List<BannerListBean.DataBean.PostsBean> list;

    public BannerListAdapter(Context context, int layoutId, List<BannerListBean.DataBean.PostsBean> list) {
        super(context, layoutId, list);
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }

    @Override
    public void convert(ViewHolderM holderM, BannerListBean.DataBean.PostsBean bean) {
        ImageView imageView = (ImageView) holderM.getView(R.id.iv_child_show);
        TextView mTextView = (TextView) holderM.getView(R.id.tv_child_show);
        TextView getmTextView = (TextView) holderM.getView(R.id.tv_child_jianjie);
        Picasso.with(context).load(bean.getCover_image_url())
                .into(imageView);
        mTextView.setText("  " + bean.getLikes_count());
        getmTextView.setText(bean.getTitle());
    }


}
