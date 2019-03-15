package com.jj.learning.springboot.chapter5.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
// 此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    // 建立一個空的WebApplicationContext
    @Autowired
    private WebApplicationContext webApplicationContext;

    // 建立 MockMvc 的物件
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 使用 webApplicationContext 建立初始化 MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCustomerController() throws Exception {
        RequestBuilder request = null; 
        
        // 確認目前的Customers是否為空
        request = get("/customers/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
        
        // 新增一個Customer
        request = post("/customers/")
                .param("id", "1")
                .param("name", "jjHuang") 
                .param("age", "99");
        
        // 確認Customer是否新增成功
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
        
        // 取得目前Customer清單，確認剛剛新增的客戶是否存在
        request = get("/customers/");
        mvc.perform(request)
                .andExpect(status().isOk()) 
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"jjHuang\",\"age\":99}]")));
        
        // 根據id更新客戶資料
        request = put("/customers/1") 
                .param("name", "newJJHuang") 
                .param("age", "18");
        
        // 確認Customer是否更新成功
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
        
        // 根據id取得Customer，確認更新資料是否正確
        request = get("/customers/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"newJJHuang\",\"age\":18}]")));
        
        // 根據id刪除Customer
        request = delete("/customers/1");
        
        // 確認Customer是否刪除成功
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
        
        // 最後確認目前的Customers是否為空
        request = get("/customers/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
        
    }

}
