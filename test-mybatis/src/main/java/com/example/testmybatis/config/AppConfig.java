package com.example.testmybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource({"classpath:/config/spring-mybatis.xml"})
@Configuration
@EnableTransactionManagement
@MapperScan("com.example.testmybatis.dao")
public class AppConfig {
}
