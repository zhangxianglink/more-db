package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SysGroup;
import com.example.demo.mapper.SysGroupMapper;
import com.example.demo.pojo.OrgRelationship;
import com.example.demo.service.ISysGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 以下代码中的转化，为了营运宝代码继续运行,
 * 真实数据关系已数据库
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements ISysGroupService {

    @Autowired
    private SysGroupMapper sysGroupMapper;

    @Override
    public List<OrgRelationship> getChilds(String parentId, String type) {
        List<SysGroup> groupList = this.list(new LambdaQueryWrapper<SysGroup>()
                .eq(SysGroup::getParent, parentId)
                .eq(SysGroup::getGroupType, type)
        );
        return convertList(groupList);
    }

    @Override
    public List<OrgRelationship> getDescendants(String path, Integer level, String type) {
        return convertList(this.list(new LambdaQueryWrapper<SysGroup>()
                .eq(SysGroup::getLevel, level)
                .eq(SysGroup::getGroupType, type)
                .likeRight(StringUtils.isNotBlank(path), SysGroup::getParents, path + "=")
        ));
    }

    @Override
    public List<OrgRelationship> getDescendants2(String path, Integer level, String type) {
        return convertList(this.list(new LambdaQueryWrapper<SysGroup>()
                .eq(SysGroup::getLevel, level)
                .eq(SysGroup::getGroupType, type)
                .eq(StringUtils.isNotBlank(path), SysGroup::getParents, path)
        ));
    }

    @Override
    public OrgRelationship getByCodeTwo(String code, String type) {
        SysGroup sysGroup = this.getOne(new LambdaQueryWrapper<SysGroup>()
                .eq(SysGroup::getCode, code)
                .eq(SysGroup::getGroupType, type)
        );
        return new OrgRelationship(Long.valueOf(sysGroup.getId()),
                sysGroup.getLevel(), sysGroup.getParent(), sysGroup.getCode(), null,
                sysGroup.getParents(), sysGroup.getName(), null, sysGroup.getGroupType());
    }

    @Override
    public OrgRelationship getByCodeThree(String code, String type) {
        OrgRelationship byCodeTwo = getByCodeTwo(code, type);
        byCodeTwo.setCodeTwo(byCodeTwo.getParent());
        byCodeTwo.setCodeThree(code);
        return byCodeTwo;
    }

    @Override
    public List<OrgRelationship> getStores(String path, String type) {
        return sysGroupMapper.getStores(path, type);
    }

    @Override
    public List<OrgRelationship> getStores2(String path, String type) {
        return sysGroupMapper.getStores2(path, type);
    }

    @Override
    public List<OrgRelationship> searchStores(String keyword, String path, String type) {
        return sysGroupMapper.searchStores(keyword,path,type);
    }

    @Override
    public List<OrgRelationship> searchStores2(String keyword, String path, String type) {
        return sysGroupMapper.searchStores2(keyword,path,type);
    }

    @Override
    public List<OrgRelationship> getByCodeTwoList(String[] codeTwoList, String type) {
        return convertList(this.list(new LambdaQueryWrapper<SysGroup>()
                .in(SysGroup::getCode,codeTwoList)
                .eq(SysGroup::getGroupType, type)
                .orderByDesc(SysGroup::getCode)
        ));
    }

    @Override
    public List<OrgRelationship> getAllAreas(String grandpar) {
        return convertList(this.list(new LambdaQueryWrapper<SysGroup>()
                .eq(SysGroup::getGroupType, grandpar)
                .ne(SysGroup::getLevel, 6)
        ));
    }


    private List<OrgRelationship> convertList(List<SysGroup> groupList) {
        ArrayList<OrgRelationship> relationships = new ArrayList<>();
        groupList.forEach(sysGroup ->
            relationships.add(new OrgRelationship(Long.valueOf(sysGroup.getId()),
                    sysGroup.getLevel(), sysGroup.getParent(), sysGroup.getCode(), null,
                    sysGroup.getParents(), sysGroup.getName(), null, sysGroup.getGroupType()))
        );
        return relationships;
    }

}
