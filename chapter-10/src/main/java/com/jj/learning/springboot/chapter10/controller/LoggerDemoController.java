package com.jj.learning.springboot.chapter10.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerDemoController {

    private final Logger logger = Logger.getLogger(LoggerDemoController.class);

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String logger(@RequestParam("message") String message) {
        // 優先等級由低至高
        logger.trace("trace(追蹤):" + message);
        logger.debug("debug(調試):" + message);
        logger.info("info(信息):" + message);
        logger.warn("warn(警告):" + message);
        logger.error("error(錯誤):" + message);
        logger.fatal("fatal(致命):" + message);
        return "success";
    }

}
