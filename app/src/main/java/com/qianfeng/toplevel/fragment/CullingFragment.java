package com.qianfeng.toplevel.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qianfeng.toplevel.R;

/**
  精选界面 的fragment
 */
public class CullingFragment extends Fragment {

    public CullingFragment newInstace(Bundle args){
        CullingFragment fragment=new CullingFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_culling, container, false);
    }


}
