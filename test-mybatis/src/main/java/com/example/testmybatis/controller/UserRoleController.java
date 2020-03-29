package com.example.testmybatis.controller;

import com.example.testmybatis.dao.UmsRoleMapper;
import com.example.testmybatis.model.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UmsRoleMapper userMapper;

    @GetMapping("/findAll")
    public List<UmsRole> getAll(){
        return userMapper.selectAll();
    }
}
