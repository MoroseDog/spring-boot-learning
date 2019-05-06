package com.jj.learning.springboot.chapter41.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }

    @GetMapping("/delete")
    // @RequiresPermissions("delete")
    @RequiresRoles("admin")
    public String delete() {
        return "delete";
    }

    @GetMapping("/select")
    @RequiresPermissions("select")
    public String select() {
        return "select";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("HomeController.login()");
        // 登錄失敗從request中獲取shiro處理的異常信息。
        // shiroLoginFailure:就是shiro異常類的全類名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        // 根據異常判斷錯誤類型
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "賬號不存在";
            }
            else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密碼不正確";
            }
            else {
                msg = "else >> " + exception;
            }
        }
        map.put("msg", msg);
        // 此方法不處理登錄成功,由shiro進行處理
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/login";
    }

}