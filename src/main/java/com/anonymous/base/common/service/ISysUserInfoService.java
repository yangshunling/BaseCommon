package com.anonymous.base.common.service;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import org.springframework.stereotype.Service;

import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @param sysUserInfo
     */
    void userRegister(SysUserInfoDTO sysUserInfo);

    /**
     * 用户登录
     *
     * @param sysUserInfo
     * @return token
     */
    String userLogin(SysUserInfoDTO sysUserInfo);

    /**
     * 用户退出
     *
     * @param userId
     */
    void userLogout(String userId);
}
