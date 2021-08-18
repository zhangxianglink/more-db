package com.example.demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 组织与新声对应关系
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data

public class TbOrgCorrespondence {

    private static final long serialVersionUID = 1L;

    /**
     * 二代编码
     */
    private String orgCode;

    /**
     * 新声(源为HR系统)编码
     */
    private String xsCode;

    /**
     * 新声编码名称
     */
    private String grandpar;


}
