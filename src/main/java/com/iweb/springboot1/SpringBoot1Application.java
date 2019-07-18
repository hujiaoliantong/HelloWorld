package com.iweb.springboot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot1Application {
    /**
     * 注意：启动类，需要在Controller包的上一层
     * 直接使用这个启动类去启动
     * 1.若不在XxxMapper中加入注解，SpringBoot扫描不到XxxMapper,启动不起来
     * 2.目的：要能扫描到这个XxxMapper
     *  2.1 在启动类中加入mapperScan
     *  2.2 在XxxMapper接口中加入@Mapper注解，启动类中就不需要扫描了
     */
        public static void main(String[] args) {
            SpringApplication.run(SpringBoot1Application.class, args);

        }
    }


