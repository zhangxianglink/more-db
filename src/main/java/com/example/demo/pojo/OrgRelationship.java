package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * 组织关系表
 * @author xiangzhang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgRelationship {

    private Long id;
    private Integer level;
    private String parent;
    private String codeTwo;
    private String codeThree;
    private String path;
    private String name;
    /**
     * lv6拥有,母店的子店(三代编码,逗号隔开),没有为null
     */
    private String subCode;
    private String grandpar;



    protected Serializable pkVal() {
        return this.id;
    }
}
