package com.powernode.springboot.service.impl;

import com.powernode.springboot.mapper.TStudentMapper;
import com.powernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentMapper tStudentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Long queryAllStudentCount() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Long queryAllStudentCount =(Long) redisTemplate.opsForValue().get("queryAllStudentCount");
        if (queryAllStudentCount==null){
            queryAllStudentCount= (long) tStudentMapper.countByExample(null);
            redisTemplate.opsForValue().set("queryAllStudentCount", queryAllStudentCount,60, TimeUnit.SECONDS);
            System.out.println("-------查询数据库---------");
            return queryAllStudentCount;
        }else {
            System.out.println("-------击中缓存---------");
            return queryAllStudentCount;
        }
    }

    @Override
    public Long queryAllStudentCount2() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Long queryAllStudentCount =(Long) redisTemplate.opsForValue().get("queryAllStudentCount");
        if (queryAllStudentCount==null){
            synchronized (this){
                queryAllStudentCount =(Long) redisTemplate.opsForValue().get("queryAllStudentCount");
                if (queryAllStudentCount==null){
                    System.out.println("-------查询数据库----------");
                    queryAllStudentCount= (long) tStudentMapper.countByExample(null);
                    redisTemplate.opsForValue().set("queryAllStudentCount", queryAllStudentCount,60, TimeUnit.SECONDS);
                }else {
                    System.out.println("--------击中缓存----------");
                }
            }
        }else {
            System.out.println("--------击中缓存----------");
        }
        return queryAllStudentCount;
    }
}
