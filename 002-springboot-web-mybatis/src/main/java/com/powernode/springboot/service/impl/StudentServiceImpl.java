package com.powernode.springboot.service.impl;

import com.powernode.springboot.mapper.TStudentMapper;
import com.powernode.springboot.model.TStudent;
import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentMapper tStudentMapper;

    @Override
    public TStudent getById(int i) {
        return tStudentMapper.selectByPrimaryKey(i);
    }

    @Transactional
    @Override
    public Integer insert() {
        TStudent tStudent = new TStudent();
        tStudent.setName("艾米莉亚");
        tStudent.setAge(22);
        int insert = tStudentMapper.insertSelective(tStudent);
        int i=10/0;
        return insert;
    }
}
