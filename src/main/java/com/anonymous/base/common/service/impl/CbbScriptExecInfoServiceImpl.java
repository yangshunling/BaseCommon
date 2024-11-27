package com.anonymous.base.common.service.impl;

import com.anonymous.base.common.model.CbbScriptExecInfo;
import com.anonymous.base.common.mapper.CbbScriptExecInfoMapper;
import com.anonymous.base.common.service.ICbbScriptExecInfoService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 脚本执行信息 服务实现类
 * </p>
 *
 * @author Anonymous
 * @since 2024-06-24 15:35:04
 */
@Service
@DS("hspbs")
public class CbbScriptExecInfoServiceImpl extends ServiceImpl<CbbScriptExecInfoMapper, CbbScriptExecInfo> implements ICbbScriptExecInfoService {

    @Resource
    private CbbScriptExecInfoMapper cbbScriptExecInfoMapper;

    @Override
    public Page<CbbScriptExecInfo> getList() {
        QueryWrapper<CbbScriptExecInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18);
        Page<CbbScriptExecInfo> pageWrapper = new Page<>();
        pageWrapper.setCurrent(1);
        pageWrapper.setSize(10);
        return cbbScriptExecInfoMapper.selectPage(pageWrapper, queryWrapper);
    }
}
