package com.anonymous.base.common.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Dict;
import com.anonymous.base.common.exceptions.BaseCommonException;
import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import com.anonymous.base.common.mapper.SysUserInfoMapper;
import com.anonymous.base.common.service.ISysUserInfoService;
import com.anonymous.base.common.utils.IdUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        sysUserInfoEntity.setUserId(IdUtils.createSnowflake(1, 1));
        sysUserInfoEntity.setUserName(sysUserInfo.getUserName());
        sysUserInfoEntity.setPassword(sysUserInfo.getPassword());
        sysUserInfoEntity.setEmail(sysUserInfo.getEmail());
        sysUserInfoMapper.insert(sysUserInfoEntity);
    }

    /**
     * 用户登录
     *
     * @param sysUserInfo
     * @return
     */
    @Override
    public Dict userLogin(SysUserInfoDTO sysUserInfo) {
        QueryWrapper<SysUserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", sysUserInfo.getUserName());
        SysUserInfoEntity sysUserInfoEntity = sysUserInfoMapper.selectOne(queryWrapper);
        if (sysUserInfoEntity == null) {
            throw new BaseCommonException("用户不存在");
        }
        if (!sysUserInfoEntity.getPassword().equals(sysUserInfo.getPassword())) {
            throw new BaseCommonException("密码错误");
        }
        Dict dict = Dict.create()
                .set("userId", sysUserInfoEntity.getUserId())
                .set("token", sysUserInfoEntity.getUserId());
        return dict;
    }

    /**
     * 用户退出
     */
    @Override
    public void userLogout() {
        StpUtil.logout();
    }
}
