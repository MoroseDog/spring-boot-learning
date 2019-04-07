package com.jj.learning.springboot.chapter23;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter23.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter23ApplicationTests {

    @Autowired
    private RedisTemplate<String, Customer> redisTemplate;

    @Test
    public void test() throws Exception {

        // 新增/保存Customer
        Customer customer = new Customer("J.J.Huang", 18);
        redisTemplate.opsForValue().set(customer.getName(), customer);
        customer = new Customer("K.K.Huang", 28);
        redisTemplate.opsForValue().set(customer.getName(), customer);
        customer = new Customer("L.L.Huang", 38);
        redisTemplate.opsForValue().set(customer.getName(), customer);

        // 取得並比對年齡
        Assert.assertEquals(18, redisTemplate.opsForValue().get("J.J.Huang").getAge().longValue());
        Assert.assertEquals(28, redisTemplate.opsForValue().get("K.K.Huang").getAge().longValue());
        Assert.assertEquals(38, redisTemplate.opsForValue().get("L.L.Huang").getAge().longValue());

    }

}
