package com.yeternal.assistant.model.payload;

import com.yeternal.assistant.model.dto.DateDay;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 生日参数
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/24 18:02
 */
@Data
public class BirthdayRequest {

    /**
     * 用户名
     */
    @NotBlank(message = "寿星名称不能为空")
    private String name;

    /**
     * 生日
     */
    private DateDay birthday;

    /**
     * 是否农历
     */
    private Boolean lunar = false;

    /**
     * 提前提醒时间
     */
    private Integer remindConfig;
}
