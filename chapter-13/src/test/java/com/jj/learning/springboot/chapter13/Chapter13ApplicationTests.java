package com.jj.learning.springboot.chapter13;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter13.domain.Customer;
import com.jj.learning.springboot.chapter13.service.CustomerService;

@RunWith(SpringRunner.class)
//此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter13ApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() {
        // 刪除所有客戶
        customerService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        
        // 新建客戶(1)
        Customer cus = new Customer();
        cus.setId(1L);
        cus.setName("J.J.Huang");
        cus.setAge(18);
        
        customerService.create(cus);
        
        // 新建客戶(2)
        cus.setId(2L);
        cus.setName("J.J.");
        cus.setAge(28);
        
        customerService.create(cus);

        // 確認客戶數(2位)
        Assert.assertEquals(2, customerService.getAllUsers().intValue());

        // 刪除客戶
        customerService.deleteByName("J.J.Huang");

        // 確認客戶數(1位)
        Assert.assertEquals(1, customerService.getAllUsers().intValue());

    }

}
