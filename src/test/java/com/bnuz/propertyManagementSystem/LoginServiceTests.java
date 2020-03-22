package com.bnuz.propertyManagementSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * @Author: Harry
 * @Date: 2020-03-19 16:07
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    @Before
    public void init() throws Exception{

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void loginTest() throws Exception {
        MvcResult mvcResult= mockMvc.perform(
                MockMvcRequestBuilders.post("/test/login2")
                        .content("{\n" +
                                "    \"username\": \"789\",\n" +
                                "    \"password\": \"fc1200c7a7aa52109d762a9f005b149abef01479\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .param("pageNum","1")
//                        .param("size","10")

//                .content("json")
        )
                // .andExpect(MockMvcResultMatchers.status().isOk())             //等同于Assert.assertEquals(200,status);
                // .andExpect(MockMvcResultMatchers.content().string("hello lvgang"))    //等同于 Assert.assertEquals("hello lvgang",content);
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status=mvcResult.getResponse().getStatus();                 //得到返回代码
        String content=mvcResult.getResponse().getContentAsString();    //得到返回结果

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

}