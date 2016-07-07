package com.qianfeng.toplevel.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.qianfeng.toplevel.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.iv_search_activity_back)
    ImageView iv_back;
    @BindView(R.id.ed_search_content)
    EditText ed_search;
    @BindView(R.id.tv_search_activity_search)
    TextView tv_search;
    @BindView(R.id.recycler_search_centre)
    RecyclerView mRecyclerView;
    private List<String> titles;
    private MyRecyclerAdapter myRecyclerAdapter;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initData();

//        初始化数据源
        initSharedPrefrence();
//        初始化内部存储
        initListener();
    }

    private void initSharedPrefrence() {
        sp=getSharedPreferences("titles",MODE_PRIVATE);
//        创建一个私有的
        edit = sp.edit();
    }

    private void initListener() {
        iv_back.setOnClickListener(this);
        tv_search.setOnClickListener(this);
    }

    private void initData() {
        titles = new ArrayList<>();
        setupRecylerView();
//      设置RecylerView
        titles.add("零食");
        titles.add("手机壳");
        titles.add("双肩包");
        titles.add("零食");
        titles.add("零食");
        titles.add("零食");
        titles.add("零食");
        titles.add("连衣裙");
        titles.add("零食");
        titles.add("零食");
        titles.add("零食");
        titles.add("零食");
        titles.add("零食");

    }

    private void setupRecylerView() {
//        流式布局
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        myRecyclerAdapter = new MyRecyclerAdapter();
        mRecyclerView.setAdapter(myRecyclerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_search_activity_back:
                finish();
            break;
            case R.id.tv_search_activity_search:
                setupEditText();
            break;
        }
    }

    private void setupEditText() {
        String content=ed_search.getEditableText().toString().trim();
        if(!TextUtils.isEmpty(content)){
           titles.add(content);
            edit.putString(content,content);
            edit.commit();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myRecyclerAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_search_recycler);
        }
    }

    //创建了一个Adapter
    class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(SearchActivity.this).inflate
                    (R.layout.item_search_acitivity_recycle, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(titles.get(position));
        }

        @Override
        public int getItemCount() {
            return titles == null ? 0 : titles.size();
        }
    }

}
