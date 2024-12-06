package com.anonymous.base.common.service.impl;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import com.anonymous.base.common.mapper.SysUserInfoMapper;
import com.anonymous.base.common.service.ISysUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
@Service
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfoEntity> implements ISysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 用户注册
     *
     * @param sysUserInfo
     */
    @Override
    public void userRegister(SysUserInfoDTO sysUserInfo) {

    }

    /**
     * 用户登录
     *
     * @param sysUserInfo
     * @return
     */
    @Override
    public String userLogin(SysUserInfoDTO sysUserInfo) {
        return "";
    }

    /**
     * 用户退出
     *
     * @param userId
     */
    @Override
    public void userLogout(String userId) {

    }
}
