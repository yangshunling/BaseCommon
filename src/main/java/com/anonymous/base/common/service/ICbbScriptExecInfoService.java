package com.anonymous.base.common.service;

import com.anonymous.base.common.model.CbbScriptExecInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 脚本执行信息 服务类
 * </p>
 *
 * @author Anonymous
 * @since 2024-06-24 15:35:04
 */
public interface ICbbScriptExecInfoService extends IService<CbbScriptExecInfo> {
    Page<CbbScriptExecInfo> getList();
}
