package com.jj.learning.springboot.chapter24;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter24.domain.Customer;
import com.jj.learning.springboot.chapter24.domain.CustomerRepository;

@RunWith(SpringRunner.class)
//此為測試案例，設定Port為隨機，避免了不必要的Port衝突。
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter24ApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp(){
        // 刪除所有資料
        customerRepository.deleteAll();
        // 建立1條資料
        customerRepository.save(new Customer("AAA", 10, "SYSTEM"));
    }
    
    @Test
    public void test() throws Exception {
        
        // 查詢緩存前的Cache.customers.AAA
        cacheManager.getCache("customers").get("AAA");
        
        Customer c1 = customerRepository.findByName("AAA");
        System.out.println("第一次查詢：" + c1.getAge());

        // 查詢緩存後的Cache.customers.AAA
        cacheManager.getCache("customers").get("AAA");
        
        Customer c2 = customerRepository.findByName("AAA");
        System.out.println("第二次查詢：" + c2.getAge());

    }
}
