package ${package.Controller};

import com.anonymous.base.common.web.model.request.HttpResponse;
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
public class ${table.controllerName} {
</#if>

    /**
    * service
    */
    @Autowired
    ${table.serviceName} service;

    /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @PostMapping("/insert")
    public HttpResponse insert(@Validated ${entity}DTO dto) {
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
    public HttpResponse select(${entity}DTO dto) {
        IPage<${entity}VO> list = service.selectByPage(dto);
        return ResultUtils.list(list.getRecords(), list.getTotal());
    }
}
    </#if>
