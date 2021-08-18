package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
