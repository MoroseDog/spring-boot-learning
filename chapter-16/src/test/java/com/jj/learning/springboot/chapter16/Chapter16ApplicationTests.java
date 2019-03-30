package com.jj.learning.springboot.chapter16;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter16.domain.Customer;
import com.jj.learning.springboot.chapter16.domain.CustomerMapper;

@RunWith(SpringRunner.class)
// 此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter16ApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Before
    public void setUp() {
        customerMapper.deleteAllCustomer();
    }

    @Test
    @Rollback
    public void findByName() throws Exception {

        // 新增第一筆客戶，並判斷是否新增成功
        Customer c = new Customer();
        c.setAge(18);
        c.setName("J.J.");
        Assert.assertEquals(Integer.valueOf(1), customerMapper.addCustomer(c));

        // 新增第二筆客戶，並判斷是否新增成功
        c.setAge(30);
        c.setName("J.J.Huang");
        Assert.assertEquals(Integer.valueOf(1), customerMapper.addCustomer(c));

        // 找所有客戶
        List<Customer> cList = customerMapper.getAllCustomer();

        // 判斷總客戶數是否一致
        Assert.assertEquals(2, cList.size());
        
        c = customerMapper.getCustomerByName("J.J.Huang");

        // 刪除J.J.Huang By ID
        customerMapper.deleteCustomerById(c.getId());

        // 目前的客戶總數
        cList = customerMapper.getAllCustomer();

        // 判斷總客戶數是否一致
        Assert.assertEquals(1, cList.size());
    }

}
