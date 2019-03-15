package com.jj.learning.springboot.chapter4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String modelMap(String name, ModelMap map) {
        map.addAttribute("name", name);
        map.addAttribute("from", "com.jj");
        // 模版名稱，實際的目錄為：src/main/resources/templates/thymeleaf.html
        return "thymeleaf";
    }

    @RequestMapping(value = "/mv", method = RequestMethod.GET)
    public ModelAndView modelAndView(String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("from", "com.jj");
        // 模版名稱，實際的目錄為：src/main/resources/templates/thymeleaf.html
        mv.setViewName("thymeleaf");
        return mv;
    }

}
