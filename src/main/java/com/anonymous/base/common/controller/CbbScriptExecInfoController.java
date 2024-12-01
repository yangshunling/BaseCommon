package com.anonymous.base.common.controller;

import com.anonymous.base.common.model.CbbScriptExecInfo;
import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.service.ICbbScriptExecInfoService;
import com.anonymous.base.common.utils.ResultUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: CbbScriptExecInfoController
 * @author : yangsl25774
 * @date: 2024/11/27 16:50
 */
@RestController
@RequestMapping("/cbbScriptExecInfo")
@CrossOrigin
public class CbbScriptExecInfoController {

    @Resource
    ICbbScriptExecInfoService cbbScriptExecInfoService;

    @GetMapping("/list")
    HttpResponse getCbbScriptExecInfoList() {
        Page<CbbScriptExecInfo> list = cbbScriptExecInfoService.getList();
        return ResultUtils.returnList(list.getRecords(), list.getTotal());
    }

}
