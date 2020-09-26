package com.powernode.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/26
 */
@Component
@ConfigurationProperties(prefix = "student")
public class ConfigInfo {
    private String id;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
