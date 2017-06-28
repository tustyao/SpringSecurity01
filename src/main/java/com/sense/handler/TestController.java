package com.sense.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by 要 on 2017/6/20.
 */
@Controller
public class TestController {
    @GetMapping("/user")
    public String user(){
        System.out.println("TestController.user");
        return "index";
    }
    @GetMapping("/admin")
    public String admin(){
        System.out.println("TestController.admin");
        return "admin";
    }

    @GetMapping("/sys/login")

    public String login(){
        System.out.println("TestController.login");
        return "login";
    }
    @PostMapping("/sys/logout")
    public String loginout(){
        System.out.println("TestController.logout");
        return "logout";
    }

}
