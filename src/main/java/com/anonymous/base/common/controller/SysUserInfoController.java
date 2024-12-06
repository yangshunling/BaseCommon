package com.anonymous.base.common.controller;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anonymous.base.common.service.ISysUserInfoService;

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
    public HttpResponse register(@RequestBody SysUserInfoDTO sysUserInfoDTO) {
        sysUserInfoService.userRegister(sysUserInfoDTO);
        return ResultUtils.success();
    }

    /**
     * 用户登录
     *
     * @param sysUserInfoDTO
     */
    @PostMapping("/login")
    public HttpResponse login(@RequestBody SysUserInfoDTO sysUserInfoDTO) {
        sysUserInfoService.userLogin(sysUserInfoDTO);
        return ResultUtils.success();
    }

    /**
     * 用户退出
     *
     * @param userId
     */
    @PostMapping("/logout")
    public HttpResponse logout(@RequestParam String userId) {
        sysUserInfoService.userLogout(userId);
        return ResultUtils.success();
    }
}
