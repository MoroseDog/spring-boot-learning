package com.jj.learning.springboot.chapter15;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter15.domain.Customer;
import com.jj.learning.springboot.chapter15.domain.CustomerMapper;

@RunWith(SpringRunner.class)
//此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter15ApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        // 新增一筆客戶
        customerMapper.insert("AAA", 20, "SYSTEM");
        // 找尋名為AAA的客戶
        Customer c = customerMapper.findByName("AAA");
        // 判斷客戶年齡是否一致
        Assert.assertEquals(20, c.getAge().intValue());
    }

}
