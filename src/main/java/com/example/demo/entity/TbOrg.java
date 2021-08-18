package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data
public class TbOrg {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 公司编号
     */
    private String code;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 父ID
     */
    private String pCode;

    /**
     * 上一层级 名称
     */
    private String pName;

    /**
     * 公司状态  1:正常；0：非正常状态
     */
    private Integer status;

    /**
     * 组织类别编号
     */
    private String categoryCode;

    /**
     * 组织类别名称
     */
    private String categoryName;

    /**
     * 组织类型编号
     */
    private String typeCode;

    /**
     * 组织类型名称

     */
    private String typeName;

    /**
     * 所属主管
     */
    private String manageId;

    /**
     * 所属公司编号
     */
    private String companyCode;

    /**
     * 所属公司名称
     */
    private String companyName;

    /**
     * 组织所在地址
     */
    private String area;


}
