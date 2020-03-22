package com.bnuz.propertyManagementSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2020-03-19 21:26
 * @Version 1.0
 */

@Component
@Slf4j
public class TestUtil {

    public static String POST = "post";
    public static String GET = "get";
    public static String PUT = "put";
    public static String DELETE = "delete";
    public static String PATCH = "patch";

    public Map<String,Object> getResult(String url, String json, String method,MockMvc mockMvc){
        return getResultImpl(url,json,null,method,mockMvc);
    }

    public Map<String,Object> getResult(String url,Map<String,String> params,String method,MockMvc mockMvc){
        return getResultImpl(url,null,params,method,mockMvc);
    }

    private Map<String,Object> getResultImpl(String url,String json,Map<String,String> params,String method,MockMvc mockMvc){
        Map<String,Object> result = new HashMap<>();

        MockHttpServletRequestBuilder mhsrb = choiceMethod(method,url);
        if(mhsrb == null){
            return null;
        }

        mhsrb = mhsrb.contentType(MediaType.APPLICATION_JSON_UTF8);

        if(json != null){
            mhsrb = mhsrb.content(json);
        }

        if(params != null){
            for(Map.Entry<String,String> entry : params.entrySet()){
                mhsrb = mhsrb.param(entry.getKey(),entry.getValue());
            }
        }

        try {
            MvcResult mvcResult= mockMvc.perform(mhsrb)
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();

            int status=mvcResult.getResponse().getStatus();                 //得到返回代码
            String content=mvcResult.getResponse().getContentAsString();    //得到返回结果

            result.put("status",status);
            result.put("content",content);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("TestUtil 获取结果错误！");
        }

        return result;
    }

    private MockHttpServletRequestBuilder choiceMethod(String method,String url){
        if(method.equals(GET)){
            return MockMvcRequestBuilders.get(url);
        }
        if(method.equals(POST)){
            return MockMvcRequestBuilders.post(url);
        }
        if(method.equals(DELETE)){
            return MockMvcRequestBuilders.delete(url);
        }
        if(method.equals(PUT)){
            return MockMvcRequestBuilders.put(url);
        }
        if(method.equals(PATCH)){
            return MockMvcRequestBuilders.patch(url);
        }

        return null;
    }
}