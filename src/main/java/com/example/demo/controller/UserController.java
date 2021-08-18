package com.example.demo.controller;

import com.example.demo.mapper.User2Mapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description user控制器
 * @author zhengkai.blog.csdn.net
 * @date 2021-08-05
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Mapper user2Mapper;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(@RequestBody User user){
        User user2 = new User();
        BeanUtils.copyProperties(user,user2);
        user2.setName("数据源2");
        userMapper.insert(user);
        user2Mapper.insert(user2);
        return "user: " + user.getId() + ",user2: " + user2.getId();
    }



    /**
     * 查询
     */
    @PostMapping("/find")
    public Object find(int id){
        User user = userMapper.selectById(id);
        log.info("DB1: {}",user.toString());
        User user2 = user2Mapper.selectById(id);
        log.info("DB2: {}",user2.toString());
        return "over";
    }

    /**
     * 查询
     */
    @PostMapping("/find2")
    public Object find2(int id){
        User user = userMapper.selectById(id);
        log.info("DB1: {}",user.toString());
        return "over";
    }
}