package com.anonymous.base.common.service;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.entity.SysUserInfoEntity;
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
public interface ISysUserInfoService extends IService<SysUserInfoEntity> {

    /**
     * 用户注册
     *
     * @param sysUserInfo 用户信息
     */
    void userRegister(SysUserInfoDTO sysUserInfo);

    /**
     * 用户登录
     *
     * @param sysUserInfo 用户信息
     * @return token
     */
    Map<String, Object> userLogin(SysUserInfoDTO sysUserInfo);

    /**
     * 用户退出
     */
    void userLogout();
}
