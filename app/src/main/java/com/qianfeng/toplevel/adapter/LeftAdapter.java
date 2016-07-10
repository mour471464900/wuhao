package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.SingleProductBean;
import com.qianfeng.toplevel.utils.ImageLoader;
import com.qianfeng.toplevel.utils.URLConstants;

import java.util.List;

/**
 * Created by hao on 2016/7/7.
 */
public class LeftAdapter extends CommonAdapter<SingleProductBean.DataBean.CategoriesBean> {
    private Context context;
    private int layoutId;
    private List<SingleProductBean.DataBean.CategoriesBean> list;
    private View redView;
    private TextView textView;

    public LeftAdapter(Context context, int layoutId, List<SingleProductBean.DataBean.CategoriesBean> list) {
        super(context, layoutId, list);
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }

    @Override
    public void convert(ViewHolderM holderM, SingleProductBean.DataBean.CategoriesBean bean) {
        redView = holderM.getView(R.id.view_tv_item_sing_left_cursor);
        textView = (TextView) holderM.getView(R.id.tv_item_sing_left_name);
        textView.setText(bean.getName());
//        获取红色滑动条的位置
        textView.setTag(-1);
        redView.setTag(-1);
    }
}
