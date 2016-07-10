package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.ColumnBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hao on 2016/7/10.
 */
public class CheckAllTopAdapter extends CommonAdapter<ColumnBean.DataBean.ColumnsBean> {
    private List<ColumnBean.DataBean.ColumnsBean> list;
    private Context context;
    private int layoutId;

    public CheckAllTopAdapter(Context context, int layoutId, List<ColumnBean.DataBean.ColumnsBean> list) {
        super(context, layoutId, list);
        this.layoutId = layoutId;
        this.context = context;
        this.list = list;
    }

    @Override
    public void convert(ViewHolderM holderM, ColumnBean.DataBean.ColumnsBean bean) {
        RoundedImageView iv_icon = (RoundedImageView) holderM.getView(R.id.iv_column_banner);
        TextView tv_author = (TextView) holderM.getView(R.id.tv_column_author);
        TextView tv_title = (TextView) holderM.getView(R.id.tv_column_title);
        TextView tv_subtitle = (TextView) holderM.getView(R.id.tv_column_subtitle);
        Picasso.with(context).load(bean.
                getBanner_image_url()).into(iv_icon);
        tv_author.setText(bean.getAuthor());
        tv_title.setText(bean.getTitle());
        tv_subtitle.setText(bean.getSubtitle());
    }
}
