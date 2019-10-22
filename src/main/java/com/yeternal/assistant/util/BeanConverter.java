package com.yeternal.assistant.util;

import cn.hutool.core.bean.BeanUtil;
import com.yeternal.assistant.model.entity.SysUser;
import com.yeternal.assistant.model.payload.SysUserRequest;
import com.yeternal.assistant.model.vo.SysUserVO;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 18:08
 */
public class BeanConverter {

    //user ##################################################

    public static SysUserVO toUserVO(SysUser user) {
        SysUserVO vo = BeanUtil.toBean(user, SysUserVO.class);
        vo.setLastUpdateTime(user.getUpdateTime());
        return vo;
    }

    public static SysUser toUser(SysUserRequest userDTO) {
        return BeanUtil.toBean(userDTO, SysUser.class);
    }

}
