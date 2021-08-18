package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 第三方权限
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data

public class TbSysAuth {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 名称
     */
    private String name;

    /**
     * 工作号码
     */
    private String workNumber;

    /**
     * 二代编码|业态
     */
    private String code;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 0 不可用 1 可用
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
