package com.jj.learning.springboot.chapter2.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
// 此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {
    
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
    public void getDemo() throws Exception {
        // 執行請求並返回一種類型，該類型允許在結果上鍊接進一步的操作，例如asserting。
        mvc.perform(MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON))
                // 期望 回傳HttpStatus為 200
                .andExpect(status().isOk())
                // 期望 回傳的內容為"Hello World!"
                .andExpect(content().string(equalTo("Hello World!")));
    }

}
