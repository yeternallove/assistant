package com.yeternal.assistant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeternal.assistant.common.api.PageResult;
import com.yeternal.assistant.mapper.BirthdayMapper;
import com.yeternal.assistant.model.dto.DateDay;
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
        save(buildBirthday(birthday, null, userId));

    }

    @Override
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void update(Integer id, BirthdayRequest birthday) {
        updateById(buildBirthday(birthday, id, null));
    }

    @Override
    public PageResult<BirthdayVO> listBirthday(BirthdayQuery query) {
        QueryWrapper<Birthday> wrapper = new QueryWrapper<>();
        IPage<Birthday> page = page(query.page(), wrapper.lambda().like(Birthday::getName, query.getName()));
        List<BirthdayVO> list = page.getRecords().stream().map(BeanConverter::toBirthdayVO).collect(Collectors.toList());
        return PageResult.of(page.getTotal(), list);
    }

    private Birthday buildBirthday(BirthdayRequest birthdayRequest, Integer id, Integer userId) {
        Birthday birthday = new Birthday();
        birthday.setName(birthdayRequest.getName());
        birthday.setRemindConfig(birthdayRequest.getRemindConfig());
        int date;
        if (birthdayRequest.getLunar()) {
            DateDay dateDay = TimeUtil.transToLunar(birthdayRequest.getBirthday());
            date = TimeUtil.getPackageTime(dateDay);
        } else {
            date = TimeUtil.getPackageTime(birthdayRequest.getBirthday());
        }
        birthday.setBirthday(date);
        // TODO
        //  birthday.setNextBirthday();
        //  birthday.setRemindTime();

        // 新增插入
        birthday.setUserId(userId);
        // 更新插入
        birthday.setId(id);
        return birthday;
    }
}
