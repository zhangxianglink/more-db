package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data
public class SysUser {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id_", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String passwordHash;

    private String userCode;

    /**
     * 所属组织
     */
    private String group;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 头像URL
     */
    private String headPortraitUrl;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 职称编号
     */
    private String positionId;

    /**
     * 职等id
     */
    private String gradeId;

    /**
     * 入职时间
     */
    private Date joinCompanyTime;

    /**
     * 离职时间
     */
    private Date leaveCompanyTime;

    /**
     * 状态  0：启用   1：禁用 2：锁定
     */
    private String status;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private String lastModifiedBy;

    /**
     * 修改时间
     */
    private Date lastModifiedTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 数据状态: 0：正常 1：删除
     */
    private String isDeleted;

    /**
     * 租户id
     */
    private String tenementId;

    /**
     * 租户名称
     */
    private String tenementName;

    /**
     * 版本
     */
    private Integer version;


}
