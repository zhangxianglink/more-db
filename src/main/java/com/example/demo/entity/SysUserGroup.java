package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统用户机构关联表
 * </p>
 *
 * @author xiang.z
 * @since 2021-08-13
 */
@Data
@NoArgsConstructor
public class SysUserGroup {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id_", type = IdType.ASSIGN_ID)
    private String id;

    public SysUserGroup(String userId, String groupId, String tenementId) {
        this.userId = userId;
        this.groupId = groupId;
        this.tenementId = tenementId;
    }

    /**
     * 用户id
     */
    private String userId;

    /**
     * 机构id
     */
    private String groupId;

    /**
     * 租户id
     */
    private String tenementId;


}
