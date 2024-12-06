package com.anonymous.base.common.controller;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.service.ISysUserInfoService;
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
     * @param sysUserInfoDTO
     */
    @PostMapping("/register")
    public HttpResponse register(@RequestBody @Valid SysUserInfoDTO sysUserInfoDTO) {
        sysUserInfoService.userRegister(sysUserInfoDTO);
        return ResultUtils.success();
    }

    /**
     * 用户登录
     *
     * @param sysUserInfoDTO
     */
    @PostMapping("/login")
    public HttpResponse login(@RequestBody @Valid SysUserInfoDTO sysUserInfoDTO) {
        return ResultUtils.object(sysUserInfoService.userLogin(sysUserInfoDTO));
    }

    /**
     * 用户退出
     */
    @GetMapping("/logout")
    public HttpResponse logout() {
        sysUserInfoService.userLogout();
        return ResultUtils.success();
    }
}
