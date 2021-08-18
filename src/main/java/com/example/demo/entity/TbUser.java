package com.example.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data

public class TbUser {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 员工中文名称
     */
    private String name;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码 盐值
     */
    private String salt;

    /**
     * 员工工号
     */
    private String workNumber;

    /**
     * 性别   1：男  0：女
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 座机
     */
    private String telPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 员工状态（1：正常状态，0：冻结状态（停职），2：离职
     */
    private Integer status;

    /**
     * 员工类型（1：正式员工，2：临时员工 ）
     */
    private Integer type;

    /**
     * 所在 城市
     */
    private String city;

    /**
     * 出生日期
     */
    private String birthDate;

    /**
     * 入职时间
     */
    private String hireDate;

    /**
     * 所属组织编号
     */
    private String companyCode;

    /**
     * 所属部门
     */
    private String departmentCode;

    /**
     * 岗位编号
     */
    private String postCode;

    private String gradeCode;

    /**
     * 是否是管理员   0：否  1：是管理员  可以登录后台管理系统
     */
    private Integer ssoManger;

    /**
     * 最后登录时间
     */
    private Date lastLogin;

    /**
     * 上一次密码修改时间
     */
    private Date lastPasswordUpdateTime;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 归属事业群名称
     */
    private String buCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 部门主管
     */
    private String deptManager;

    /**
     * 部门主管名称
     */
    private String deptManagerName;

    /**
     * 二阶主管
     */
    private String viceManager;

    /**
     * 二阶主管名称
     */
    private String viceManagerName;

    /**
     * 直属主管
     */
    private String directlyManager;

    /**
     * 直属主管名称
     */
    private String directlyManagerName;

    /**
     * 试用期到期时间
     */
    private String probationEndTime;

    /**
     * 劳动合同到期时间
     */
    private String pactOverTime;

    /**
     * 二级密码
     */
    private String vicePassword;

    /**
     * 银行工资卡卡号
     */
    private String bankCard;

    /**
     * 银行工资卡开户行
     */
    private String bankBranch;


}
