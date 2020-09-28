package com.powernode.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springboot.mapper.TStudentMapper;
import com.powernode.springboot.model.TStudent;
import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/28
 */
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 20000)
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentMapper tStudentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Long queryAllStudentCount() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Long queryAllStudentCount = (Long)redisTemplate.opsForValue().get("queryAllStudentCount");
        if (queryAllStudentCount==null){
            synchronized (this){
                if (queryAllStudentCount==null){
                    queryAllStudentCount= (long)tStudentMapper.countByExample(null);
                    redisTemplate.opsForValue().set("queryAllStudentCount", queryAllStudentCount,2, TimeUnit.MINUTES);
                }
            }
        }
        return queryAllStudentCount;
    }

    @Override
    public List<TStudent> queryAllStudent() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String allStudent = (String)redisTemplate.opsForValue().get("allStudent");
        if (allStudent==null){
            synchronized (this){
                if (allStudent==null){
                    try {
                        allStudent= new ObjectMapper().writeValueAsString(tStudentMapper.queryAllStudent());
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    redisTemplate.opsForValue().set("allStudent", allStudent,3,TimeUnit.MINUTES);
                }
            }
        }
        List<TStudent>  tStudents=null;
        try {
            tStudents = ( List<TStudent> )new ObjectMapper().readValue(allStudent,  List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tStudents;
    }
}
