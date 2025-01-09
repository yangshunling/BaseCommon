package com.anonymous.base.common.plugin.generator;

import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.utils.ResultUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
    import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:30:42
 */
@RestController
@RequestMapping("/sys-user")

/**
* <p>
* 用户表 接口类
* </p>
*
* @author Anonymous
* @since 2025-01-09 19:30:42
*/
public class SysUserController {

    /**
    * service
    */
    @Resource
    private ISysUserService service;

    /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @PostMapping("/insert")
    public HttpResponse insert(@Validated SysUserDTO dto) {
        return ResultUtils.object(this.service.saveOne(dto));
    }

    /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    @GetMapping
    public HttpResponse getByPk(@Validated @NotEmpty String pk) {
        return ResultUtils.object(this.service.getByPk(pk));
    }

    /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    @DeleteMapping("/{pk}")
    public HttpResponse deleteByPk(@Validated @NotEmpty @PathVariable("pk") String pk) {
        return ResultUtils.object(this.service.deleteByPk(pk));
    }

    /**
    * 分页查询
    *
    * @return BizResult
    */
    @GetMapping("/page")
    public HttpResponse page(SysUserDTO dto) {
        IPage<SysUserEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        IPage<SysUserVO> list = this.service.selectPageByDto(page, dto);
        return ResultUtils.list(list.getRecords(), list.getTotal());
    }
}
