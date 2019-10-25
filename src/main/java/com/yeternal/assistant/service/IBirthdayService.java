package com.yeternal.assistant.service;

import com.yeternal.assistant.common.api.PageResult;
import com.yeternal.assistant.model.entity.Birthday;
import com.yeternal.assistant.model.payload.BirthdayRequest;
import com.yeternal.assistant.model.query.BirthdayQuery;
import com.yeternal.assistant.model.vo.BirthdayVO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/23 17:01
 */
public interface IBirthdayService {

    /**
     * 新增
     *
     * @param birthday 生日信息
     * @param userId   用户id
     */
    void save(BirthdayRequest birthday, int userId);

    /**
     * 删除
     *
     * @param ids 主键数组
     */
    void delete(List<Long> ids);

    /**
     * 更新
     *
     * @param id       主键
     * @param birthday {@link Birthday}
     */
    void update(Integer id, BirthdayRequest birthday);

    /**
     * 查询
     *
     * @param query 查询条件
     * @return 查询列表
     */
    PageResult<BirthdayVO> listBirthday(BirthdayQuery query);

}
