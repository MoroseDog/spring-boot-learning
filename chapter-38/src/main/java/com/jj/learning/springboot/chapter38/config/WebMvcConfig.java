package com.jj.learning.springboot.chapter38.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
   @Bean
   public static HandlerInterceptor getHandlerInterceptor() {
       return new CustomHandlerInterceptor();
   }
   
   @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }
   /**
    * 攔截所有請求，除了登錄，首頁，錯誤頁面
    * @param registry
    */
   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "user/login", "/index.html", "/error.html")
                .excludePathPatterns("/public/**","/resources/**");
   }

   /**
    * 靜態資源目錄放開
    * @param registry
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**", "/public/**").addResourceLocations("classpath:/resources/", "classpath:/public/");
    }
    
}
