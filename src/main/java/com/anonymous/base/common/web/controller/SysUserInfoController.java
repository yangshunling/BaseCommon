package com.anonymous.base.common.web.controller;

import com.anonymous.base.common.web.model.dto.SysUserDTO;
import com.anonymous.base.common.web.model.request.HttpResponse;
import com.anonymous.base.common.web.service.ISysUserInfoService;
import com.anonymous.base.common.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
@RestController
@RequestMapping("/user")
public class SysUserInfoController {

    @Autowired
    ISysUserInfoService sysUserInfoService;

    /**
     * 用户注册
     *
     * @param sysUserDTO
     */
    @PostMapping("/register")
    public HttpResponse register(@RequestBody @Valid SysUserDTO sysUserDTO) {
        sysUserInfoService.userRegister(sysUserDTO);
        return ResultUtils.successForMessage("用户注册成功");
    }

    /**
     * 用户登录
     *
     * @param sysUserDTO
     */
    @PostMapping("/login")
    public HttpResponse login(@RequestBody @Valid SysUserDTO sysUserDTO) {
        return ResultUtils.objectForMessage(sysUserInfoService.userLogin(sysUserDTO), "用户登录成功");
    }

    /**
     * 用户退出
     */
    @GetMapping("/logout")
    public HttpResponse logout() {
        sysUserInfoService.userLogout();
        return ResultUtils.successForMessage("用户退出成功");
    }
}
