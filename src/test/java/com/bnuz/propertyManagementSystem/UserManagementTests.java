package com.bnuz.propertyManagementSystem;

import com.alibaba.fastjson.JSONObject;
import com.bnuz.propertyManagementSystem.model.User;
import com.google.gson.JsonObject;
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
 * @Date: 2020-03-19 22:38
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementTests {

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
    public void getUserListTest() throws Exception{
        String url = "/admin/getUserList";
        String json = null;
        Map<String,String> params = new HashMap<>();

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
    public void delUserTest() throws Exception{
        String url = "/admin/delUser";
        String json = null;
        Map<String,String> params = new HashMap<>();

        params.put("id","118");

        Map<String,Object> res = testUtil.getResult(url,params,TestUtil.GET,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

    @Test
    public void updateUserTest() throws Exception{
        String url = "/admin/updateUser";
        String json = null;
        Map<String,String> params = null;

        User user = new User();
        user.setNickname("test133322");
        user.setPassword("151515");
        user.setUsername("test1");
        user.setId(119);

        json = JSONObject.toJSONString(user);

        Map<String,Object> res = testUtil.getResult(url,json,TestUtil.POST,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }


    @Test
    public void selectUserByType() throws Exception{
        String url = "/admin/selectUserByType";
        String json = null;
        Map<String,String> params = new HashMap<>();

        params.put("ttype","1");
        params.put("content","2");
        params.put("pageNum","1");
        params.put("size","10");

        Map<String,Object> res = testUtil.getResult(url,params,TestUtil.GET,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }
}