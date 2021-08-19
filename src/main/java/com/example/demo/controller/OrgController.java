package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据库数据迁移
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class OrgController {

    @Autowired
    private ITbOrgService orgService;

    @Autowired
    private ITbOrgCorrespondenceService orgCorrespondenceService;

    @Autowired
    private ITbSysAuthService sysAuthService;

    @Autowired
    private ITbOrgRelationshipT1Service orgRelationshipT1Service;

    @Autowired
    private ITbUserService userService;

    @Autowired
    private ISysUserGroupService sysUserGroupService;

    @Autowired
    private ISysGroupService sysGroupService;

    /**
     * 同步组织关系初始化
     */
    @GetMapping("/map")
    public void map(){
        List<TbOrgCorrespondence> correspondences = orgCorrespondenceService.list();

        Map<String, Map<String, List<TbOrgCorrespondence>>> yingyun = correspondences.stream()
                .collect(Collectors.groupingBy(TbOrgCorrespondence::getGrandpar,
                        Collectors.groupingBy(TbOrgCorrespondence::getXsCode)));
        Map<String, List<TbOrgCorrespondence>> dks = yingyun.get("010");
        Map<String, List<TbOrgCorrespondence>> ksf = yingyun.get("050");

        List<TbSysAuth> tbSysAuths = sysAuthService.list(new LambdaQueryWrapper<TbSysAuth>().eq(TbSysAuth::getStatus,true));
        Map<String, String> sauths = tbSysAuths.stream().collect(Collectors.toMap(TbSysAuth::getWorkNumber, TbSysAuth::getCode));

        List<TbUser> list = userService.list(new LambdaQueryWrapper<TbUser>()
                .isNotNull(TbUser::getDepartmentCode).ne(TbUser::getDepartmentCode,"")
                );
        list.forEach(e -> e.setDepartmentCode(e.getDepartmentCode().replace("AA","A")));

        ArrayList<SysUserGroup> arrayList = new ArrayList<>();

        for (TbUser e :list){
                // 组织内人员
                String tmp = "";
                List<TbOrgCorrespondence> list1 = dks.get(e.getDepartmentCode());
                if (list1 != null) {
                    for (TbOrgCorrespondence t :
                            list1) {
                        if (StringUtils.isNoneBlank(t.getOrgCode())) {
                            tmp = tmp + t.getOrgCode() + "|010,";
                        }
                    }
                }

                List<TbOrgCorrespondence> list2 = ksf.get(e.getDepartmentCode());
                if (list2 != null) {
                    for (TbOrgCorrespondence t :
                            list2) {
                        if (StringUtils.isNoneBlank(t.getOrgCode())) {
                            tmp = tmp + t.getOrgCode() + "|050,";
                        }
                    }
                }

                // 组织外流程
                String code = sauths.get(e.getWorkNumber());
                if (StringUtils.isNoneBlank(code)) {
                    tmp = tmp + code + ",";
                }
                if (tmp.length() > 1) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                    SysUserGroup sug = new SysUserGroup(e.getWorkNumber(), "", "xxxxxxxxxxx");
                    sug.setGroupId(tmp);
                    arrayList.add(sug);
                }
            }

        List<TbOrgRelationshipT1> tbOrgRelationshipT1s = orgRelationshipT1Service.list(new LambdaQueryWrapper<TbOrgRelationshipT1>().isNotNull(TbOrgRelationshipT1::getCodeThree));
        for (TbOrgRelationshipT1 t1:
        tbOrgRelationshipT1s) {
            arrayList.add(
                    new SysUserGroup(t1.getCodeTwo(),t1.getCodeThree() + "|" + t1.getGrandpar(),"xxxxxxxxxxx")
            );
        }
        sysUserGroupService.saveBatch(arrayList);
    }

    /**
     * 部门信息初始化
     */
    @GetMapping("/org")
    public void org(){
        // level  <= 5
        List<TbOrgRelationshipT1> t1List = orgRelationshipT1Service.list();
        // level  > 5
        List<TbOrgRelationshipT1> lowLevel = orgRelationshipT1Service.list(
                new LambdaQueryWrapper<TbOrgRelationshipT1>().isNotNull(TbOrgRelationshipT1::getCodeThree));
        List<SysGroup> orgs = new ArrayList<>();

        for (TbOrgRelationshipT1 t1:
                t1List) {
           orgs.add( SysGroup.builder().level(t1.getLevel())
                    .code(t1.getCodeTwo())
                    .name(t1.getName())
                    .parent(t1.getParent())
                    .parents(t1.getPath())
                    .parentCode(t1.getParent())
                    .groupType(t1.getGrandpar())
                    .build()
           );
        }

        for (TbOrgRelationshipT1 low:
                lowLevel) {
            // level 7 店铺2，3代码映射关系
            orgs.add( SysGroup.builder().level(7)
                    .code(low.getCodeThree())
                    .name(low.getName())
                    .parent(low.getCodeTwo())
                    .parents(low.getPath())
                    .parentCode(low.getCodeTwo())
                    .groupType(low.getGrandpar())
                    .build()
            );
            // level 8 母子店映射关系
            if (low.getSubCode() != null){
                orgs.add( SysGroup.builder().level(7)
                        .code(low.getSubCode())
                        .name(low.getName())
                        .parent(low.getCodeThree())
                        .parents(low.getPath())
                        .parentCode(low.getCodeThree())
                        .groupType(low.getGrandpar())
                        .build()
                );
            }
        }
        orgs.forEach( e -> {
            if (e.getParent() == null){
                e.setParent("000");
            }
            e.setId(IdWorker.getIdStr(Instant.now()));
            e.setStatus("0");
            e.setTenementId("xxxxxxxxxxx");
            e.setTenementName("测试租户");
        });

        sysGroupService.saveBatch(orgs);
    }
}

