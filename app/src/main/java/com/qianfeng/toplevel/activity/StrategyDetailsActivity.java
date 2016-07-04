package com.qianfeng.toplevel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qianfeng.toplevel.OkUtils.IOKCallBack;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.R;
import com.qianfeng.toplevel.bean.StrategyDetailsBean;
import com.qianfeng.toplevel.utils.URLConstants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StrategyDetailsActivity extends AppCompatActivity {

    @BindView(R.id.web_view_strategy_details)
    WebView webView;
    @BindView(R.id.tv_strategy_details_normal)
    TextView tv_normal;
    @BindView(R.id.tv_strategy_details_share)
    TextView tv_share;
    @BindView(R.id.tv_strategy_details_comment)
    TextView tv_comment;
    @BindView(R.id.iv_strategy_details)
    ImageView imageView;
    private int item_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_details);
        ButterKnife.bind(this);
        initItemId();
//        初始化从外部传来的数据
         initData();
//        初始化数据源
    }

    private void initItemId() {
        Intent intent=getIntent();
        item_id=intent.getIntExtra("item_id",0);
    }
    private void initData() {
        OkHttpTool.newInstance().start(URLConstants.DETAILS_START+item_id
        +URLConstants.DETAILS_END).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                StrategyDetailsBean strategyDetailsBean =
                        gson.fromJson(result, StrategyDetailsBean.class);
                StrategyDetailsBean.DataBean dataBean=strategyDetailsBean.getData();
                setupUI(dataBean);
//                改变UI
            }
        });
    }

    private void setupUI(StrategyDetailsBean.DataBean dataBean) {
        String cover_image_url = dataBean.getCover_image_url();
        String content_url = dataBean.getContent_url();
        int comments_count = dataBean.getComments_count();
        int shares_count = dataBean.getShares_count();
        int likes_count = dataBean.getLikes_count();
//        从bean类中得到数据
//        webview自身显示，而不是调用默认浏览器
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(content_url);
//        改变webview的内容
        Picasso.with(this).load(cover_image_url).into(imageView);
//       改变图片
        tv_comment.setText(""+comments_count);
        tv_share.setText(""+shares_count);
        tv_normal.setText(""+likes_count);
//        改变地步的数字
    }

    //   按back建的功能
    public void backMain(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        webView.stopLoading();
//        webview停止加载
        webView.destroy();
//        web销毁
        super.onDestroy();
    }
}
