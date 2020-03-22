package com.bnuz.propertyManagementSystem;

import com.alibaba.fastjson.JSONObject;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2020-03-19 22:12
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplaintAndSuggestionTests {
    @Autowired
    private TestUtil testUtil;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    @Before
    public void init() throws Exception{

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void createComplaintAndSuggestionSheetTest() throws Exception{
        String url = "/api/ComplaintAndSuggestion/create";
        String json = null;
        Map<String,String> params = null;

        ComplaintAndSuggestionSheet complaintAndSuggestionSheet = new ComplaintAndSuggestionSheet();

        complaintAndSuggestionSheet.setTitle("test11");
        complaintAndSuggestionSheet.setSheetType("投诉");
        complaintAndSuggestionSheet.setMessage("test");
        complaintAndSuggestionSheet.setUserNickName("789");

        json = JSONObject.toJSONString(complaintAndSuggestionSheet);

        Map<String,Object> res = testUtil.getResult(url,json,TestUtil.POST,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

    @Test
    public void queryOwnerComplaintAndSuggestionSheetByIdTest() throws Exception{
        String url = "/api/ComplaintAndSuggestion/query";
        String json = null;
        Map<String,String> params = new HashMap<>();

        params.put("userId","6");
        params.put("pageNum","1");
        params.put("size","10");

        Map<String,Object> res = testUtil.getResult(url,params,TestUtil.GET,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

    @Test
    public void delComplaintAndSuggestionSheetTest() throws Exception{
        String url = "/api/ComplaintAndSuggestion/del";
        String json = null;
        Map<String,String> params = null;

        ComplaintAndSuggestionSheet complaintAndSuggestionSheet = new ComplaintAndSuggestionSheet();

        complaintAndSuggestionSheet.setTitle("test11");
        complaintAndSuggestionSheet.setSheetType("投诉");
        complaintAndSuggestionSheet.setMessage("test");
        complaintAndSuggestionSheet.setUserNickName("789");

        json = JSONObject.toJSONString(complaintAndSuggestionSheet);


        Map<String,Object> res = testUtil.getResult(url,json,TestUtil.DELETE,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }


}