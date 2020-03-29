package com.example.testmybatis.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportResource({"classpath:/config/spring-mybatis.xml"})
@MybatisTest
@EnableTransactionManagement
@MapperScan("com.example.testmybatis.dao")
class UmsRoleMapperTest {

    @Autowired
    private Environment env;

    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void selectAll() {
        //System.out.println(env.getProperty("mybatis.project"));
        System.out.println(umsRoleMapper.selectAll());
    }

    @Test
    void updateByPrimaryKey() {
    }
}