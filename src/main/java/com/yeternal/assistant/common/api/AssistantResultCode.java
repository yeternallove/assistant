package com.yeternal.assistant.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 模块业务代码枚举
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 15:06
 */
@Getter
@AllArgsConstructor
public enum AssistantResultCode implements IResultCode {

    /**
     * 主键不能为空
     */
    PRIMARY_KEY_NOT_EMPTY(1000, "主键不能为空");

    /**
     * code编码
     */
    private final int code;
    /**
     * 中文信息描述
     */
    private final String reasonPhrase;
}
