package com.powernode.springboot.controller;

import com.powernode.springboot.model.TStudent;
import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@RestController
@RequestMapping("/mybatis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/get")
    public TStudent getById(){
        return studentService.getById(1);
    }

    @RequestMapping("/insert")
    public Object insert(){
        return studentService.insert();
    }



}
