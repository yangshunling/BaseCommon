package ${package.Entity};

<#list table.importPackages as pkg>
    import ${pkg};
</#list>

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
* <p>
    * VO
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Data
public class ${entity}VO {

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
