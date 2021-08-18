package com.example.demo.mapper;

import com.example.demo.entity.TbProtalBpmMapInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-17
 */
@Mapper
public interface TbProtalBpmMapInfoMapper extends BaseMapper<TbProtalBpmMapInfo> {

    int saveList(@Param("list") List<TbProtalBpmMapInfo> list);

    int clearTable();
}
