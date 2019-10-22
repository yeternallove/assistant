package com.yeternal.assistant.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统用户视图
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 17:23
 */
@Data
public class SysUserVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;
}
