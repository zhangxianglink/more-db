package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserInfo {
	/** 组织名称 */
    private String name;
	/** 二代编码 */
    private String codeTwo;
	/** 三代编码 */
    private String codeThree;
	/** 等级 */
    private Integer level;
	/** 组织路径 */
    private String path;
	/** 工号 */
    private String workNumber;
	/** 业态 */
    private String grandpar;
	/** 外部传过来的名称 */
    private String thirdUserName;
	/** 父级 */
    private String parent;
	/** 部门编号 */
    private String departmentCode;
    /**
     * 1. 权限表
     * 2. 自有权限
     * 3. 兼职
     */
    private Integer source;

    /** 用于排序 */
    @JsonIgnore
    private String order;
}
