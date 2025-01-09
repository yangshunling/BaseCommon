package ${package.Entity};

import com.anonymous.base.common.base.BaseConvertor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * Convertor
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Mapper
public interface ${entity}Convertor extends BaseConvertor<${entity}VO, ${entity}DTO, ${entity}Entity> {
    ${entity}Convertor INSTANCE = Mappers.getMapper(${entity}Convertor.class);
}