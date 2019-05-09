package com.jj.learning.springboot.chapter44;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter44.domain.UserRepository;
import com.jj.learning.springboot.chapter44.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter44ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 創建三個User，並驗證User總數
        userRepository.save(new User(1L, "J.J.", 30));
        userRepository.save(new User(2L, "K.K.", 40));
        userRepository.save(new User(3L, "L.L.", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 刪除一個User，再驗證User總數
        User u = userRepository.findById(2L).get();
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 刪除一個User，再驗證User總數
        u = userRepository.findByUsername("L.L.");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

    }

}
