package com.powernode.springboot.service;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
public interface StudentService {
    /**
     * springboot整合redis演示
     * redis缓存击穿现象
     * @return
     */
    Long queryAllStudentCount();

    /**
     * 解决缓存击穿现象
     * @return
     */
    Long queryAllStudentCount2();
}
