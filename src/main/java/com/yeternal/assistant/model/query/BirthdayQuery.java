package com.yeternal.assistant.model.query;

import com.yeternal.assistant.common.api.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/24 16:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BirthdayQuery extends PageQuery {

    /**
     * 用户名
     */
    private String name;
}
