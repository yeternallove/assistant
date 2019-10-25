package com.yeternal.assistant.model.payload;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 *
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
    private String name;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 是否农历
     */
    private Boolean lunar = false;

    /**
     * 提前提醒时间
     */
    private Long remindConfig;
}
