package com.powernode.springboot.service;

import com.powernode.springboot.model.TStudent;

import java.util.List;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/28
 */
public interface StudentService {
    /**
     * 查询学生人数
     * @return
     */
    Long queryAllStudentCount();

    List<TStudent> queryAllStudent();

}
