package com.qianfeng.toplevel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.qianfeng.toplevel.fragment.StrategyFragment;

/**
 * Created by hao on 2016/7/8.
 * 自定义gridview
 */
public class CustomGridView extends GridView {
    public CustomGridView(Context context) {
        super(context);
    }

    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST));
//        要GridView完全展开，取消它的滚动条
    }


}
