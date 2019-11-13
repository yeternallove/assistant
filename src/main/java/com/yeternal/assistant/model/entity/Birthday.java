package com.yeternal.assistant.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 生日相关实体类
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/21 16:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("birthday")
public class Birthday implements Serializable {

    private static final long serialVersionUID = 328994922583804051L;

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

    /**
     * 提醒配置 提前提醒毫秒数
     */
    private Integer remindConfig;

    /**
     * 下一次生日对应时间
     */
    private Date nextBirthday;

    /**
     * 下一次提醒时间
     */
    private Date remindTime;

    /**
     * 所属用户id
     */
    private Integer userId;
}
