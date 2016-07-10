package com.qianfeng.toplevel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.ColumnBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by hao on 2016/7/8.
 */
public class ColumnAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<ColumnBean.DataBean.ColumnsBean> list;
    private Context context;

    public ColumnAdapter(List<ColumnBean.DataBean.ColumnsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.item_expand_listview_gonglv_hearder_child, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).
                getBanner_image_url()).into(holder.iv_icon);
        holder.tv_author.setText(list.get(position).getAuthor());
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_subtitle.setText(list.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {

    final RoundedImageView iv_icon;
    final TextView tv_author;
    final TextView tv_title;
    final TextView tv_subtitle;

    public MyViewHolder(View itemView) {
        super(itemView);
        iv_icon = (RoundedImageView) itemView.findViewById(R.id.iv_column_banner);
        tv_author = (TextView) itemView.findViewById(R.id.tv_column_author);
        tv_title = (TextView) itemView.findViewById(R.id.tv_column_title);
        tv_subtitle = (TextView) itemView.findViewById(R.id.tv_column_subtitle);

    }
}