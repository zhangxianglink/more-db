package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-17
 */
@Data
@NoArgsConstructor
public class TbProtalBpmMapInfo {

    private static final long serialVersionUID = 1L;

    public TbProtalBpmMapInfo(String levelType, String orgCode, String orgName, String departmentCode, String departmentName, String init) {
        this.levelType = levelType;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.init = init;
    }

    /**
     * ID
     */
    @TableId(value = "id")
    private String id;

    private String levelType;

    private String orgCode;

    private String orgName;

    private String departmentCode;

    private String departmentName;

    private String init;


}
