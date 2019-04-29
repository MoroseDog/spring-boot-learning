package com.jj.learning.springboot.chapter39.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// 開啟Spring Security的功能
@EnableWebSecurity
// 繼承WebSecurityConfigurerAdapter，並重寫它的方法來設置一些web安全的細節
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    // BCryptPasswordEncoder實現使用廣泛支持的bcrypt算法來散列密碼。
    // 為了使它更能抵抗密碼破解，bcrypt故意放慢。
    // 與其他自適應單向函數一樣，應調整大約需要1秒鐘來驗證系統上的密碼。
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // configure(HttpSecurity http)方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 通過authorizeRequests()定義哪些URL需要被保護、哪些不需要被保護。
        // 以下代碼指定了/和/home不需要任何認證就可以訪問，其他的路徑都必須通過身份驗證。
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                // 通過formLogin()定義當需要用戶登錄時候，轉到的登錄頁面。
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 在內存中創建了一個用戶，該用戶的名稱為user，密碼為password，用戶角色為USER。
        auth
            .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    }


}
