package com.px.subject;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 * @author: px
 * @date : 2025/3/8
 */
@SpringBootApplication
@ComponentScan("com.px") //虽然能扫描到 但是想用还得引入依赖
@MapperScan("com.px.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }

}
