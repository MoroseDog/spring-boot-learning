package com.jj.learning.springboot.chapter38.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class Customlister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("監聽器：銷毀");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("監聽器：初始化");
    }

}
