package com.powernode.springboot.controller;

import com.powernode.springboot.model.TStudent;
import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public TStudent getById(@PathVariable Integer id){
        return studentService.getById(id);
    }

//    @GetMapping("/{id}")
//    public TStudent getById2(@PathVariable String id){
//        return studentService.getById(Integer.parseInt(id));
//    }

    @PostMapping("/{name}/{sex}")
    public Object insert(@PathVariable String name,@PathVariable String sex){
        return studentService.insert();
    }

    @PostMapping("/{id}/{name}/{sex}")
    public Object update(@PathVariable String name,@PathVariable String sex,@PathVariable Integer id){
        return studentService.insert();
    }

    @PostMapping("/{name}/{sex}/{id}")
    public Object update1(@PathVariable String name,@PathVariable String sex,@PathVariable Integer id){
        return studentService.insert();
    }



}
