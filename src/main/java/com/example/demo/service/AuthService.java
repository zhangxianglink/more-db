package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import java.util.List;

/**
 * 授权相关
 * @author xpoll
 * @date 2019年4月17日
 */
public interface AuthService {

    /**
     * <pre>
     * 查询用户与权限 for cache
     *
     * key: 
     * 正常权限
     *   DepartmentCode | WorkNumber
     * 兼职权限
     *   DepartmentCode | Void-DepartmentCode-WorkNumber
     *   
     * </pre>
     */
    List<UserInfo> getUserInfo(String key);
}
