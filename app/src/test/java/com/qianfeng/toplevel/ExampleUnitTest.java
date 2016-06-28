package com.qianfeng.toplevel;

import com.google.gson.Gson;
import com.qianfeng.toplevel.bean.ClassifyBean;
import com.qianfeng.toplevel.bean.FristAdvert;
import com.qianfeng.toplevel.bean.SecondAdvert;
import com.qianfeng.toplevel.utils.HttpUtilNow;
import com.qianfeng.toplevel.utils.URLConstants;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void textOkHttpUtil() throws Exception {
        String name = HttpUtilNow.get(URLConstants.URL_SECONDCB);
        Gson gson = new Gson();
        SecondAdvert advert = gson.fromJson(name, SecondAdvert.class);
        SecondAdvert.DataBean dataBean = advert.getData();
        List<SecondAdvert.DataBean.SecondaryBannersBean> mlist = new ArrayList<>();
        mlist.addAll(dataBean.getSecondary_banners());
        List<String> imageurl = new ArrayList<>();
        for (int i = 0; i < mlist.size(); i++) {
            imageurl.add(mlist.get(i).getImage_url());
        }
        System.out.println(imageurl);
    }
}