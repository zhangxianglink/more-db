package com.example.demo.mapper;

import com.example.demo.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

}
