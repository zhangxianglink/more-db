package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.entity.SysGroup;
import com.example.demo.entity.SysUserGroup;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.AuthService;
import com.example.demo.service.ISysGroupService;
import com.example.demo.service.ISysUserGroupService;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xiang.z
 * @since 2021-08-18
 * @deprecated nothing
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private ISysUserGroupService sysUserGroupService;

	@Autowired
	private ISysGroupService sysGroupService;

    @Override
	public List<UserInfo> getUserInfo(String key) {
		List<String> split = Splitter.on("|").trimResults().splitToList(key);
		String workNumber = split.get(0);
		String departmentCode = split.get(1);
		String username = split.get(2);
		List<UserInfo> userInfos = Lists.newArrayList();
		// 用户，组织 映射关系
		SysUserGroup auth = sysUserGroupService.getOne(new LambdaQueryWrapper<SysUserGroup>().eq(SysUserGroup::getUserId, workNumber));

		if (auth != null && StringUtils.isNotBlank(auth.getGroupId())) {
			List<String> auths = Splitter.on(",").trimResults().splitToList(auth.getGroupId());
			if (!CollectionUtils.isEmpty(auths)) {
				auths.forEach(code -> {
					List<String> codeSplit = Splitter.on("|").trimResults().splitToList(code);

					SysGroup relationship = sysGroupService.getOne(new LambdaQueryWrapper<SysGroup>()
							.eq(StringUtils.isNoneBlank(codeSplit.get(1)), SysGroup::getGroupType, codeSplit.get(1))
							.eq(SysGroup::getCode, codeSplit.get(0))
					);
					if (relationship != null) {
						UserInfo user = new UserInfo();
						if(relationship.getLevel() > 6){
							relationship = sysGroupService.getOne(new LambdaQueryWrapper<SysGroup>()
									.eq(SysGroup::getGroupType, relationship.getGroupType())
									.eq(SysGroup::getCode, relationship.getParent())
							);
							user.setCodeThree(codeSplit.get(0));
						}
						userInfos.add(convertUserInfo(workNumber, departmentCode, username, relationship, user));
					}
				});
			}
		}
        return userInfos;
    }

	private UserInfo convertUserInfo(String workNumber, String departmentCode, String username, SysGroup relationship, UserInfo user) {
		user.setName(relationship.getName());
		user.setCodeTwo(relationship.getCode());
		user.setLevel(relationship.getLevel());
		user.setPath(relationship.getParents());
		user.setGrandpar(relationship.getGroupType());
		user.setParent(relationship.getParent());
		user.setWorkNumber(workNumber);
		user.setThirdUserName(username);
		user.setDepartmentCode(departmentCode);
		return user;
	}

}
