package com.anonymous.base.common.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Dict;
import com.anonymous.base.common.exceptions.BaseCommonException;
import com.anonymous.base.common.helper.BaseConvertHelper;
import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import com.anonymous.base.common.mapper.SysUserInfoMapper;
import com.anonymous.base.common.service.ISysUserInfoService;
import com.anonymous.base.common.utils.IdUtils;
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
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfoEntity> implements ISysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 用户注册
     *
     * @param sysUserInfoDTO 用户注册信息
     */
    @Override
    public void userRegister(SysUserInfoDTO sysUserInfoDTO) {
        // 1、查询用户名是否已存在
        QueryWrapper<SysUserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", sysUserInfoDTO.getUserName());
        SysUserInfoEntity sysUserInfoEntityResult = sysUserInfoMapper.selectOne(queryWrapper);
        // 2、如果用户名已存在，则抛出异常
        if (sysUserInfoEntityResult != null) {
            throw new BaseCommonException("用户名已存在");
        }
        // 3、如果用户名不存在，则转换DTO为Entity
        SysUserInfoEntity sysUserInfoEntity = BaseConvertHelper.INSTANCE.sysUserDtoToEntity(sysUserInfoDTO);
        // 4、插入新的用户记录
        sysUserInfoMapper.insert(sysUserInfoEntity);
    }

    /**
     * 用户登录
     *
     * @param sysUserInfoDTO 用户登录信息
     * @return
     */
    @Override
    public Map<String, Object> userLogin(SysUserInfoDTO sysUserInfoDTO) {
        // 1、查询用户
        QueryWrapper<SysUserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", sysUserInfoDTO.getUserName());
        SysUserInfoEntity sysUserInfoEntity = sysUserInfoMapper.selectOne(queryWrapper);
        // 2、检查用户是否存在
        if (sysUserInfoEntity == null) {
            throw new BaseCommonException("用户不存在");
        }
        // 3、校验密码，密码应加密存储，不直接比对明文密码
        if (!sysUserInfoEntity.getPassword().equals(sysUserInfoDTO.getPassword())) {
            throw new BaseCommonException("密码错误");
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
