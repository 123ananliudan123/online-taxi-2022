package com.mashibing.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.apipassenger.controller
 * @Date: 2023/3/31 - 03 - 31 - 10:50
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test api passenger !";
    }
}
