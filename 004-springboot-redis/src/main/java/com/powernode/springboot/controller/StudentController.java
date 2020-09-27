package com.powernode.springboot.controller;

import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @GetMapping("/redis")
    public Object queryAllStudentCount(){
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.queryAllStudentCount();
                }
            });

        }
        return 7;
    }



}
