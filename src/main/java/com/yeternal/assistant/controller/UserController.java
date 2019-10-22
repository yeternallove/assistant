package com.yeternal.assistant.controller;

import com.yeternal.assistant.common.api.R;
import com.yeternal.assistant.model.payload.PasswordRequest;
import com.yeternal.assistant.model.payload.SysUserRequest;
import com.yeternal.assistant.model.query.SysUserQuery;
import com.yeternal.assistant.service.IUserService;
import com.yeternal.assistant.util.Func;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/10/22 9:09
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    /**
     * 新增用户
     *
     * @param userDTO {@link SysUserRequest}
     * @return {@link R}
     */
    @PostMapping
    public R save(@Validated @RequestBody SysUserRequest userDTO) {
        userService.save(userDTO);
        return R.success();
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return {@link R}
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        userService.delete(id);
        return R.success();
    }

    /**
     * 更新用户信息
     *
     * @param id      用户id
     * @param userDTO {@link SysUserRequest}
     * @return {@link R}
     */
    @PutMapping("/{id}")
    public R update(@PathVariable Integer id, @Validated @RequestBody SysUserRequest userDTO) {
        userService.update(id, userDTO);
        return R.success();
    }

    /**
     * 修改用户密码
     *
     * @param passwordDTO {@link PasswordRequest}
     * @return {@link R}
     */
    @PutMapping(value = "/{id}", params = "change")
    public R changePassword(@PathVariable Integer id, @Validated @RequestBody PasswordRequest passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return R.success();
    }

    /**
     * 重置用户密码
     *
     * @param passwordDTO {@link PasswordRequest}
     * @return {@link R}
     */
    @PutMapping(value = "/{id}", params = "reset")
    public R resetPassword(@PathVariable Integer id, @Validated @RequestBody PasswordRequest passwordDTO) {
        userService.updatePassword(id, passwordDTO);
        return R.success();
    }

    /**
     * 获取单个用户详情
     *
     * @param id 用户id
     * @return {@link R}
     */
    @GetMapping("/{id}")
    public R getUser(@PathVariable Integer id) {
        return R.success(userService.getUser(id));
    }

    /**
     * 获取用户列表
     *
     * @param userQuery {@link SysUserQuery}
     * @return {@link R}
     */
    @GetMapping("/list")
    public R listUser(SysUserQuery userQuery) {
        Func.checkPageQuery(userQuery);
        return R.success(userService.listUser(userQuery));
    }
}
