package com.yeternal.assistant.model.payload;

import lombok.Data;

/**
 * <p>
 * 密码
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 15:26
 */
@Data
public class PasswordRequest {
    /**
     * 原密码
     */
    private String oldPwd;

    /**
     * 新密码
     */
    private String newPwd;
}
