package com.qianfeng.toplevel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianfeng.toplevel.fragment.CullingFragment;
import com.qianfeng.toplevel.fragment.GuideFragment;
import com.qianfeng.toplevel.fragment.HotFragment;
import com.qianfeng.toplevel.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rg_main)
    RadioGroup rgBottom;

    private List<Fragment> fragmentList = new ArrayList<>();
    private RadioButton[] rbChilds;
    private long exitTime;
    private int preIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
//        初始化控件
        initListener();
    }

    private void initListener() {
        rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbChilds.length; i++) {
                    if (rbChilds[i].getId() == checkedId) {
                        switchFragment(i);
                    }
                }
            }


        });
    }
//   改变Fragment 的位置

    private void switchFragment(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        Fragment preFragment = fragmentList.get(preIndex);
        if (!fragment.isAdded()) {
            transaction.hide(preFragment).add(R.id.fl_main_content, fragment);
        } else {
            transaction.hide(preFragment).show(fragment);
        }
        preIndex = position;
        transaction.commit();

    }

    private void initView() {
        rbChilds = new RadioButton[rgBottom.getChildCount()];
        for (int i = 0; i < rbChilds.length; i++) {
            rbChilds[i] = (RadioButton) rgBottom.getChildAt(i);
            rbChilds[i].setTag(i);
        }
        checkRadioButton(0);
    }

    //    检查check的位置
    private void checkRadioButton(int position) {
        for (int i = 0; i < rbChilds.length; i++) {
            if (i == position) {
                rbChilds[i].setChecked(true);
            } else {
                rbChilds[i].setChecked(false);
            }
        }
    }

    private void initData() {
        initFragment();
//         初始化Fragment
        initFragmentContent();
    }

    private void initFragmentContent() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_main_content, fragmentList.get(0));
        transaction.commit();
    }

    private void initFragment() {
        GuideFragment fragment1 = GuideFragment.newInstace(null);
        HotFragment fragment2 = HotFragment.newInstace(null);
        OtherFragment fragment3 = OtherFragment.newInstance(null);
        OtherFragment fragment4 = OtherFragment.newInstance(null);
        OtherFragment fragment5 = OtherFragment.newInstance(null);
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        fragmentList.add(fragment5);
    }

    //    设置按两次返回键 退出的效果
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
