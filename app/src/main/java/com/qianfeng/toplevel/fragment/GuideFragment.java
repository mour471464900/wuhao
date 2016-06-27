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
   指南的Fragment
 */
public class GuideFragment extends Fragment {

    public  static   GuideFragment newInstace(Bundle args){
        GuideFragment fragment=new GuideFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_guide, container, false);
    }

}
