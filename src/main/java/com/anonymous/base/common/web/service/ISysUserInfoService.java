package com.anonymous.base.common.web.service;

import com.anonymous.base.common.web.model.entity.SysUserEntity;
import com.anonymous.base.common.web.model.dto.SysUserDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
public interface ISysUserInfoService extends IService<SysUserEntity> {

    /**
     * 用户注册
     *
     * @param sysUserDTO 用户信息
     */
    void userRegister(SysUserDTO sysUserDTO);

    /**
     * 用户登录
     *
     * @param sysUser 用户信息
     * @return token
     */
    Map<String, Object> userLogin(SysUserDTO sysUser);

    /**
     * 用户退出
     */
    void userLogout();
}
