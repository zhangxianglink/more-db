package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description userMapper
 * @author zhengkai.blog.csdn.net
 * @date 2021-08-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
