#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import ${package}.dto.Departamento;
import ${package}.jpa.entity.DepartamentoEntity;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * Mapeos entre objetos departamento
 */
@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
  Departamento mapToDto(DepartamentoEntity entidad);

  DepartamentoEntity mapToEntity(Departamento departamento);

  List<Departamento> mapToDto(List<DepartamentoEntity> departamentos);

  List<DepartamentoEntity> mapToEntity(List<Departamento> departamentos);
}
