package com.qianfeng.toplevel;

import com.google.gson.Gson;
import com.qianfeng.toplevel.bean.ClassifyBean;
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
    public void textOkHttpUtil()throws Exception {
        String   name=   HttpUtilNow.get(URLConstants.URL_BASE);
        Gson gson=new Gson();
       ClassifyBean bean  =gson.fromJson(name, ClassifyBean.class);
        ClassifyBean.DataEntity dataEntity=bean.getData();
        List< ClassifyBean.DataEntity.ChannelsEntity > mlist=new ArrayList<>();
         mlist.addAll(dataEntity.getChannels());
        List<String > titles =new ArrayList<>();
        for (int i = 0; i <mlist.size() ; i++) {
            String title = mlist.get(i).getName();
            titles.add(title);
        }
          System.out.println( titles);
    }
}