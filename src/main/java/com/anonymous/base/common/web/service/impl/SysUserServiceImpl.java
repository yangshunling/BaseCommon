package com.anonymous.base.common.web.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.anonymous.base.common.exceptions.CommonException;
import com.anonymous.base.common.web.mapper.SysUserInfoMapper;
import com.anonymous.base.common.web.model.convertor.SysUserConvertor;
import com.anonymous.base.common.web.model.entity.SysUserEntity;
import com.anonymous.base.common.web.model.dto.SysUserDTO;
import com.anonymous.base.common.web.service.ISysUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserEntity> implements ISysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 用户注册
     *
     * @param sysUserDTO 用户注册信息
     */
    @Override
    public void userRegister(SysUserDTO sysUserDTO) {
        // 1、查询用户名是否已存在
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", sysUserDTO.getUserName());
        SysUserEntity sysUserInfoEntityResult = sysUserInfoMapper.selectOne(queryWrapper);
        // 2、如果用户名已存在，则抛出异常
        if (sysUserInfoEntityResult != null) {
            throw new CommonException("用户名已存在");
        }
        // 3、如果用户名不存在，则转换DTO为Entity
        SysUserEntity sysUserEntity = SysUserConvertor.INSTANCE.toEntity(sysUserDTO);
        // 4、插入新的用户记录
        sysUserInfoMapper.insert(sysUserEntity);
    }

    /**
     * 用户登录
     *
     * @param sysUserDTO 用户登录信息
     * @return
     */
    @Override
    public Map<String, Object> userLogin(SysUserDTO sysUserDTO) {
        // 1、查询用户
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", sysUserDTO.getUserName());
        SysUserEntity sysUserInfoEntity = sysUserInfoMapper.selectOne(queryWrapper);
        // 2、检查用户是否存在
        if (sysUserInfoEntity == null) {
            throw new CommonException("用户不存在");
        }
        // 3、校验密码，密码应加密存储，不直接比对明文密码
        if (!sysUserInfoEntity.getPassword().equals(sysUserDTO.getPassword())) {
            throw new CommonException("密码错误");
        }
        // 4、用户登录
        StpUtil.login(sysUserInfoEntity.getUserId());
        // 5、构建返回结果
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("userId", sysUserInfoEntity.getUserId());
        resultMap.put("token", StpUtil.getTokenValue());
        return resultMap;
    }

    /**
     * 用户退出
     */
    @Override
    public void userLogout() {
        StpUtil.logout();
    }
}
