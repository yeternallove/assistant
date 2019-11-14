package com.yeternal.assistant.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.assistant.common.api.AssistantResultCode;
import com.yeternal.assistant.common.api.CommonResultCode;
import com.yeternal.assistant.common.api.PageResult;
import com.yeternal.assistant.exception.ServiceException;
import com.yeternal.assistant.mapper.BirthdayMapper;
import com.yeternal.assistant.model.entity.Birthday;
import com.yeternal.assistant.model.payload.BirthdayRequest;
import com.yeternal.assistant.model.query.BirthdayQuery;
import com.yeternal.assistant.model.vo.BirthdayVO;
import com.yeternal.assistant.service.IBirthdayService;
import com.yeternal.assistant.util.BeanConverter;
import com.yeternal.assistant.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/23 17:02
 */
@Slf4j
@Service
public class BirthdayServiceImpl extends ServiceImpl<BirthdayMapper, Birthday> implements IBirthdayService {


    @Override
    public void save(BirthdayRequest birthday, int userId) {
        QueryWrapper<Birthday> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Birthday::getUserId, userId)
                .eq(Birthday::getName, birthday.getName());
        if (count(wrapper) > 0) {
            throw new ServiceException(AssistantResultCode.SAME_NAME);
        }
        save(buildBirthday(birthday, null, userId));
    }

    @Override
    public void delete(List<Long> ids, int userId) {
        QueryWrapper<Birthday> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Birthday::getUserId, userId)
                .in(Birthday::getId, ids);
        int count = count(wrapper);
        if (count != ids.size()) {
            throw new ServiceException(CommonResultCode.REQ_REJECT);
        }
        removeByIds(ids);
    }

    @Override
    public void update(Integer id, BirthdayRequest birthday, int userId) {
        Birthday one = getById(id);
        if (userId != one.getUserId()) {
            throw new ServiceException(CommonResultCode.REQ_REJECT);
        }
        updateById(buildBirthday(birthday, id, null));
    }

    @Override
    public PageResult<BirthdayVO> listBirthday(BirthdayQuery query, int userId) {
        QueryWrapper<Birthday> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Birthday::getUserId, userId)
                .like(StrUtil.isNotBlank(query.getName()), Birthday::getName, query.getName());
        IPage<Birthday> page = page(query.page(), wrapper);
        List<BirthdayVO> list = page.getRecords().stream().map(BeanConverter::toBirthdayVO).collect(Collectors.toList());
        return PageResult.of(page.getTotal(), list);
    }

    private Birthday buildBirthday(BirthdayRequest birthdayRequest, Integer id, Integer userId) {
        DateTime now = DateUtil.date();

        Birthday birthday = new Birthday();
        birthday.setName(birthdayRequest.getName());
        birthday.setRemindConfig(birthdayRequest.getRemindConfig());

        int date = TimeUtil.getPackageTime(birthdayRequest.getBirthday());
        birthday.setBirthday(birthdayRequest.getLunar() ? -date : date);

        birthday.setNextBirthday(TimeUtil.getNextBirthday(date, now, birthdayRequest.getLunar()));
        DateTime remindTime = DateUtil.offsetDay(birthday.getNextBirthday(), -birthday.getRemindConfig());
        if (remindTime.isBeforeOrEquals(now)) {
            birthday.setRemindTime(birthday.getNextBirthday());
        } else {
            birthday.setRemindTime(remindTime);
        }

        // 新增插入
        birthday.setUserId(userId);
        // 更新插入
        birthday.setId(id);
        return birthday;
    }
}
