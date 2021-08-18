package com.example.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

/**
 * <p>
 * 系统机构表
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysGroup {


    /**
     * ID
     */
    @TableId(value = "id_", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 上级菜单 0为顶级目录
     */
    @TableField("parent_")
    private String parent;

    /**
     * 所有父级标签
     */
    @TableField("parents_")
    private String parents;

    /**
     * 父机构code
     */
    private String parentCode;

    /**
     * 机构名称
     */
    @TableField("name_")
    private String name;

    /**
     * 机构编码
     */
    @TableField("code_")
    private String code;

    /**
     * 机构类型
     */
    @TableField("type_")
    private String type;

    /**
     * 组织类型:1  营业   0子公司后勤    2 总部后勤
     */
    private String groupType;

    /**
     * 状态  0：正常   1：禁用 2：锁定'
     */
    @TableField("status_")
    private String status;

    private Integer level;

    /**
     * 排序
     */
    @TableField("sort_")
    private Integer sort;

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
     * 乐观锁
     */
    @TableField("version_")
    private Integer version;

    /**
     * 数据状态: 0：正常 1：删除
     */
    private String isDeleted;

    /**
     * 备注
     */
    @TableField("remarks_")
    private String remarks;

    /**
     * 租户id
     */
    private String tenementId;

    /**
     * 租户名称
     */
    private String tenementName;

    private String groupDesc;


}
