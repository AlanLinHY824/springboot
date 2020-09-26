package com.powernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@Controller
@RequestMapping("/springboot")
public class SpringBootController {

    @RequestMapping("/say")
    public @ResponseBody String say(){
        return "hello springboot";
    }
}
