package com.anonymous.base.common.web.controller;

import com.anonymous.base.common.web.service.ISysDepartmentService;
import com.anonymous.base.common.utils.ResultUtils;
import com.anonymous.base.common.web.model.dto.SysDepartmentDTO;
import com.anonymous.base.common.web.model.entity.SysDepartmentEntity;
import com.anonymous.base.common.web.model.request.HttpResponse;
import com.anonymous.base.common.web.model.vo.SysDepartmentVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
    import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
@RestController
@RequestMapping("/sys-department")
public class SysDepartmentController {

    /**
    * service
    */
    @Autowired
    ISysDepartmentService service;

    /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @PostMapping("/insert")
    public HttpResponse insert(@Validated SysDepartmentDTO dto) {
        return ResultUtils.object(service.insert(dto));
    }

    /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    @GetMapping
    public HttpResponse getByPk(@Validated @NotEmpty String pk) {
        return ResultUtils.object(service.selectByPk(pk));
    }

    /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    @DeleteMapping("/{pk}")
    public HttpResponse deleteByPk(@Validated @NotEmpty @PathVariable("pk") String pk) {
        return ResultUtils.object(service.deleteByPk(pk));
    }

    /**
    * 分页查询
    *
    * @return BizResult
    */
    @GetMapping("/select")
    public HttpResponse select(SysDepartmentDTO dto) {
        IPage<SysDepartmentVO> list = service.selectByPage(dto);
        return ResultUtils.list(list.getRecords(), list.getTotal());
    }
}
