package ${package.Service};

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}Entity> {

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    int insert(${entity}DTO dto);

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    ${entity}VO selectByPk(String pk);

   /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    Boolean deleteByPk(String pk);

   /**
    * 支持分页的dto条件查询
    *
    * @param dto 查询参数
    * @return IPage
    */
    IPage<${entity}VO> selectByPage(${entity}DTO dto);
}
</#if>
