package com.yeternal.assistant.service;

import com.yeternal.assistant.common.api.PageResult;
import com.yeternal.assistant.model.payload.LoginRequest;
import com.yeternal.assistant.model.payload.PasswordRequest;
import com.yeternal.assistant.model.payload.SysUserRequest;
import com.yeternal.assistant.model.query.SysUserQuery;
import com.yeternal.assistant.model.vo.SysUserVO;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 9:09
 */
public interface IUserService {
    /**
     * 新增用户
     *
     * @param userDTO {@link SysUserRequest}
     */
    void save(SysUserRequest userDTO);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void delete(Integer id);

    /**
     * 更新用户（不支持密码修改）
     *
     * @param id      用户id
     * @param userDTO {@link SysUserRequest}
     */
    void update(Integer id, SysUserRequest userDTO);

    /**
     * 更新用户密码
     *
     * @param id          用户id
     * @param passwordDTO {@link PasswordRequest}
     */
    void updatePassword(Integer id, PasswordRequest passwordDTO);

    /**
     * 获取单个用户通过id
     *
     * @param id 用户id
     * @return {@link SysUserVO}
     */
    SysUserVO getUser(Integer id);

    /**
     * 获取用户列表
     *
     * @param userQuery {@link SysUserQuery}
     * @return {@link SysUserVO}
     */
    PageResult<SysUserVO> listUser(SysUserQuery userQuery);

    /**
     * 获取单个用户通过用户名、邮箱、手机号（符合任一条件）并校验密码
     *
     * @param loginRequest {@link LoginRequest}
     * @return 登录成功返回 {@link SysUserVO}
     */
    SysUserVO login(LoginRequest loginRequest);
}
