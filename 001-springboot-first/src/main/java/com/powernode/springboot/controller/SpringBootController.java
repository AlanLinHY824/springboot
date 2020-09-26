package com.powernode.springboot.controller;

import com.powernode.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 这个配置对象的重点并不在于生成对象，这个对象往往没有什么业务含义，
     * 而是可以将多个配置值作为属性一次性注入，不用在类体中编写多个@Value注解
     */
    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/say")
    public @ResponseBody String say(){
        return configInfo.toString();
    }
}
