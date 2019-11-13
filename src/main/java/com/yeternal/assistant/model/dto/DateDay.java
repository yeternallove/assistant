package com.yeternal.assistant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 日期 包含年月日信息
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/17 9:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateDay {

    private int year;
    private int month;
    private int day;

    /**
     * 仅农历使用 闰月
     */
    private boolean leap = false;
}
