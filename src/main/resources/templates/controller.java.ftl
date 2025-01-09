package ${package.Controller};

import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.utils.ResultUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
    public class ${table.controllerName} extends ${superControllerClass} {
<#else>

/**
* <p>
* ${table.comment!} 接口类
* </p>
*
* @author ${author}
* @since ${date}
*/
public class ${table.controllerName} {
</#if>

    /**
    * service
    */
    @Resource
    private ${table.serviceName} service;

    /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @PostMapping("/insert")
    public HttpResponse insert(@Validated ${entity}DTO dto) {
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
    public HttpResponse page(${entity}DTO dto) {
        IPage<${entity}Entity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        IPage<${entity}VO> list = this.service.selectPageByDto(page, dto);
        return ResultUtils.list(list.getRecords(), list.getTotal());
    }
}
    </#if>
