package com.yeternal.assistant.controller;

import cn.hutool.core.collection.CollUtil;
import com.yeternal.assistant.common.api.AssistantResultCode;
import com.yeternal.assistant.common.api.R;
import com.yeternal.assistant.exception.ServiceException;
import com.yeternal.assistant.model.payload.BirthdayRequest;
import com.yeternal.assistant.model.query.BirthdayQuery;
import com.yeternal.assistant.service.IBirthdayService;
import com.yeternal.assistant.util.Func;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/23 16:58
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BirthdayController {

    /**
     * 未加入用户管理 默认单用户系统
     */
    private final static int USER_ID = 0;

    private final IBirthdayService birthdayService;

    /**
     * 查询
     */
    @GetMapping
    public R getProjectList(BirthdayQuery query) {
        Func.checkPageQuery(query);
        return R.success(birthdayService.listBirthday(query));
    }

    /**
     * 新增
     */
    @PostMapping
    public R save(@RequestBody BirthdayRequest birthday) {
        birthdayService.save(birthday, USER_ID);
        return R.success();
    }

    /**
     * 删除 - 批量删除
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            birthdayService.delete(ids);
        }
        return R.success();
    }

    /**
     * 更新
     */
    @PutMapping
    public R update(@RequestParam Integer id, @RequestBody BirthdayRequest birthday) {
        if (null == id) {
            throw new ServiceException(AssistantResultCode.PRIMARY_KEY_NOT_EMPTY);
        }
        birthdayService.update(id,birthday);
        return R.success();
    }
}
