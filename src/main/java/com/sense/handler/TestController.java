package com.sense.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
