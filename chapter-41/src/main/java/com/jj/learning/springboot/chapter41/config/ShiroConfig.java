package com.jj.learning.springboot.chapter41.config;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        logger.info("啟動shiroFilter--時間是：" + new Date());
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // shiro攔截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // <!-- authc:所有url都必須認證通過才可以訪問; anon:所有url都都可以匿名訪問-->
        // <!-- 過濾鏈定義，從上向下順序執行，一般將/*​​放在最為下邊 -->

        // 配置不被攔截的資源及鏈接
        filterChainDefinitionMap.put("/static/**", "anon");
        // 退出過濾器
        filterChainDefinitionMap.put("/logout", "logout");

        // 配置需要認證權限的
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不設置默認會自動尋找Web工程根目錄下的"/login"頁面，即本文使用的login.html
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登錄成功後要跳轉的鏈接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 未授權界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    // 自定義身份認證Realm（包含用戶名密碼校驗，權限校驗等）
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    // 開啟shiro aop註解支持，不開啟的話權限驗證就會失效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    // 配置異常處理，不配置的話沒有權限後台報錯，前台不會跳轉到403頁面
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");// 資料庫異常處理
        mappings.setProperty("UnauthorizedException", "403");
        simpleMappingExceptionResolver.setExceptionMappings(mappings); // None by default
        simpleMappingExceptionResolver.setDefaultErrorView("error"); // No default
        simpleMappingExceptionResolver.setExceptionAttribute("ex"); // Default is "exception"
        return simpleMappingExceptionResolver;
    }
}
