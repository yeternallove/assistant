package com.yeternal.assistant.model.vo;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/24 16:46
 */
@Data
public class BirthdayVO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 生日，格式为yyyyMMdd转int,农历为负数 20190101
     */
    private Integer birthday;
}
