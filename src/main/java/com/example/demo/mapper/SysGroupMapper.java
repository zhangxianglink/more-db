package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SysGroup;
import com.example.demo.pojo.OrgRelationship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统机构表 Mapper 接口
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Mapper
public interface SysGroupMapper extends BaseMapper<SysGroup> {

    List<OrgRelationship> getStores(@Param("path") String path, @Param("type") String type);

    List<OrgRelationship> getStores2(@Param("path") String path, @Param("type") String type);

    List<OrgRelationship> searchStores(@Param("keyword")String keyword, @Param("path")String path, @Param("type")String type);

    List<OrgRelationship> searchStores2(@Param("keyword")String keyword, @Param("path")String path, @Param("type")String type);
}
