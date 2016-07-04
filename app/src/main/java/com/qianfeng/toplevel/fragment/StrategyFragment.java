package com.qianfeng.toplevel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.toplevel.R;

/**
 * z这是分类页面里面的攻略fragment
 */
public class StrategyFragment extends Fragment {

    public static StrategyFragment newInstanceP(Bundle args){
        StrategyFragment fragment=new StrategyFragment();
        fragment.setArguments(args);
        return  fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strategy, container, false);
    }

}
