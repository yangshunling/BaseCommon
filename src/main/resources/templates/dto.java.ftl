package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
import com.anonymous.base.common.base.BasePageParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * DTO
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
public class ${entity}DTO extends BasePage {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
     * ${field.comment}
     */
    @JsonProperty("${field.annotationColumnName}")
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}
