package com.powernode.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.powernode.springboot.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/28
 */
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 20000)
@Component
public class StudentServiceImpl implements StudentService {
    @Override
    public Long queryAllStudentCount() {
        return 100L;
    }
}
