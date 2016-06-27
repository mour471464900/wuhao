package com.qianfeng.toplevel.fragment;

import android.net.rtp.RtpStream;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.toplevel.R;

/**
 * 这是页面的Fragment
 *
 */
public class OtherFragment extends Fragment {

    private View view;

    public static OtherFragment newInstance(Bundle args){
        OtherFragment fragment=new OtherFragment();
         fragment.setArguments(args);
       return  fragment;
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_other, container, false);
        return view;
    }





}
