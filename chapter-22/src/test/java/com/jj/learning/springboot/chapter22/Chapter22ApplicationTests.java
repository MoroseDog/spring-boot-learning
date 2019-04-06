package com.jj.learning.springboot.chapter22;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter22ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {

        // 使用stringRedisTemplate，設定字符串 test = 1234
        stringRedisTemplate.opsForValue().set("test", "1234");
        
        // 取得test並比對值是否相同
        Assert.assertEquals("1234", stringRedisTemplate.opsForValue().get("test"));

    }
    
}
