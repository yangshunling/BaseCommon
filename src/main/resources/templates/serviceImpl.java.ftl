package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.anonymous.base.common.web.mapper.SysDepartmentMapper;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}Entity> implements ${table.serviceName} {

    @Autowired
    ${table.mapperName} mapper;

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @Override
    public int insert(${entity}DTO dto) {
        return mapper.insert(${entity}Convertor.INSTANCE.toEntity(dto));
    }

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    @Override
    public ${entity}VO selectByPk(String pk) {
        ${entity}Entity domain = this.getById(pk);
        return ${entity}Convertor.INSTANCE.toVO(domain);
    }

   /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    @Override
    public Boolean deleteByPk(String pk) {
        return this.removeById(pk);
    }

   /**
    * 支持分页的dto条件查询
    *
    * @param dto 查询参数
    * @return IPage
    */
    @Override
    public IPage<${entity}VO> selectByPage(${entity}DTO dto) {
        // 构造参数
        QueryWrapper<${entity}Entity> queryWrapper = Wrappers.query();
        // 构造分页
        Page<${entity}Entity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        // 查询结果
        IPage<${entity}Entity> iPage = mapper.selectPage(page, queryWrapper);
        return iPage.convert(${entity}Convertor.INSTANCE::toVO);
    }
}
    </#if>
