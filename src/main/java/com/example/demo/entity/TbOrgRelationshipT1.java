package com.example.demo.entity;


import lombok.Data;

/**
 * <p>
 * 组织内部对应关系
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data

public class TbOrgRelationshipT1 {

    private static final long serialVersionUID = 1L;

    /**
     * 1业态 2大区域 3子公司 4事业部 5区督导 6门店
     */
    private Integer level;

    /**
     * lv1为null,上级节点
     */
    private String parent;

    /**
     * lv1,lv2为null,lv2至本lv上一级,等号分隔
     */
    private String path;

    /**
     * 二代编码
     */
    private String codeTwo;

    /**
     * lv6拥有,三代编码
     */
    private String codeThree;

    /**
     * 名称
     */
    private String name;

    /**
     * lv6拥有,母店的子店(三代编码,逗号隔开),没有为null
     */
    private String subCode;

    /**
     * 业态二代编码
     */
    private String grandpar;


}
