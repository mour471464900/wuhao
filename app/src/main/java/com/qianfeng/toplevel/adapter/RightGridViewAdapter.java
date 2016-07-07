package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.SingleProductBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hao on 2016/7/7.
 */
public class RightGridViewAdapter extends
        CommonAdapter<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> {
    private Context context;
    private int layoutId;
    private List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> list;

    public RightGridViewAdapter(Context context, int layoutId,
                                List<SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean> list) {
        super(context, layoutId, list);
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }

    @Override
    public void convert(ViewHolderM holderM,
                        SingleProductBean.DataBean.CategoriesBean.SubcategoriesBean bean) {
        ImageView imageView = (ImageView)
                holderM.getView(R.id.iv_expand_listview_show_picture);
        TextView textView = (TextView
                ) holderM.getView(R.id.tv_expand_listview_show_picture);
        Picasso.with(context).load(bean.getIcon_url()).into(imageView);
        textView.setText(bean.getName());
    }
}
