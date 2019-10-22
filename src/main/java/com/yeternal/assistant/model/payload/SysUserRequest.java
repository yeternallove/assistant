package com.yeternal.assistant.model.payload;

import lombok.Data;


/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 15:26
 */
@Data
public class SysUserRequest {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 加密前的密码
     */
    private String password;

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
}
