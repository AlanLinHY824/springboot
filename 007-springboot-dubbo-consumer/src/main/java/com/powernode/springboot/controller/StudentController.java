package com.powernode.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.powernode.springboot.model.TStudent;
import com.powernode.springboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/28
 */
@RestController
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",timeout = 20000,check = false)
    private StudentService studentService;

    @RequestMapping("/queryAllStudentCount")
    public Object getCount(){
        Long aLong = studentService.queryAllStudentCount();
        return aLong;
    }

    @RequestMapping("/queryAllStudent")
    public Object queryAllStudent(){
        List<TStudent> students= studentService.queryAllStudent();
        return students;
    }

}
