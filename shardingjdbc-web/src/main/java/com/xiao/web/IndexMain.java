package com.xiao.web;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

/**
 * Created by jinwei.sun on 2017/2/24.
 *
 * @author sunjinwei
 * <p>
 * 入口文件
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiao"})
@MapperScan("com.xiao.dao.mapper")
@ImportResource({"classpath:spring-config.xml"})
public class IndexMain {

    /**
     * 用于区分是预发/生产
     */
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(IndexMain.class, args);
    }

}
