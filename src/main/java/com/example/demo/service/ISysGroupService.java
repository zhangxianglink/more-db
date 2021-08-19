package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SysGroup;
import com.example.demo.pojo.OrgRelationship;

import java.util.List;

/**
 * <p>
 * 系统机构表 服务类
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
public interface ISysGroupService extends IService<SysGroup> {


    //取得子区域
    List<OrgRelationship> getChilds(String parentId, String type);

    //取得子孙区域（path用like匹配）
    List<OrgRelationship> getDescendants(String path, Integer level, String type);
    //取得子孙区域(path准确匹配)
    List<OrgRelationship> getDescendants2(String path, Integer level, String type);

    OrgRelationship getByCodeTwo(String code, String type);
    OrgRelationship getByCodeThree(String code, String type);

    List<OrgRelationship> getStores(String path,String type) ;
    List<OrgRelationship> getStores2(String path,String type) ;
//    List<SysGroup> getStores(OrgRelationship orgRelationship) ;
    List<OrgRelationship> searchStores(String keyword,String path,String type) ;
    List<OrgRelationship> searchStores2(String keyword,String path,String type) ;
    List<OrgRelationship> getByCodeTwoList(String[] CodeTwoList,String type);

    //取得所有区域，门店除外
    List<OrgRelationship> getAllAreas(String grandpar);


}
