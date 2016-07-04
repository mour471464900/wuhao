package com.qianfeng.toplevel;

import com.google.gson.Gson;
import com.qianfeng.toplevel.OkUtils.OkHttpTool;
import com.qianfeng.toplevel.bean.ClassifyBean;
import com.qianfeng.toplevel.bean.CullingBean;
import com.qianfeng.toplevel.bean.FristAdvert;
import com.qianfeng.toplevel.bean.SecondAdvert;
import com.qianfeng.toplevel.utils.HttpUtil;
import com.qianfeng.toplevel.utils.HttpUtilNow;
import com.qianfeng.toplevel.utils.IRequestCallBack;
import com.qianfeng.toplevel.utils.URLConstants;

import org.junit.Test;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
        String name =HttpUtilNow.get(URLConstants.URL_CULLING);
        Gson gson = new Gson();
        CullingBean advert = gson.fromJson(name, CullingBean.class);
        CullingBean.DataBean data = advert.getData();
        List< CullingBean.DataBean.ItemsBean> itemsBeanList = new ArrayList<>();
        itemsBeanList.addAll(data.getItems());

        Map<String , List< CullingBean.DataBean.ItemsBean>> map=new HashMap<>();
        List< CullingBean.DataBean.ItemsBean> list = new ArrayList<>();
        list.add(itemsBeanList.get(0));
//        先有第一个先new一个list
        String date=returnDate(itemsBeanList.get(0).getCreated_at());
//        先有第一个date的数据
        List<String > dates=new ArrayList<>();
        dates.add(date);
        for (int i = 0; i <itemsBeanList.size() ; i++) {
            if ( date.equals(returnDate(itemsBeanList.get(i).getCreated_at()))){
                list.add(itemsBeanList.get(i));
//         如果第二个对象的data数据不等于
            }   else{
                map.put(date,list);
//                当出现了不相同的时候就把这个时候的将
                list.add(itemsBeanList.get(i));
                date=returnDate(itemsBeanList.get(i).getCreated_at());
//                当一个见
                dates.add(date);
                list = new ArrayList<>();
                map.put(date,list);
            }
        }
        System.out.println(map);
    }
//   这是将毫秒转换成日期的方法
    private String returnDate(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
        String date = sdf.format(new Date(time * 1000));
        return date;
    }
     private void postHttp() throws Exception{

         String s = HttpUtilNow.get(URLConstants.DETAILS_START +1043714+URLConstants.DETAILS_END);
         System.out.println(s);
     }

}