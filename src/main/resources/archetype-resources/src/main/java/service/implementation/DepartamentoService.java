#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.implementation;

import ${package}.dto.Departamento;
import ${package}.jpa.entity.DepartamentoEntity;
import ${package}.jpa.repository.DepartamentoRepository;
import ${package}.mapper.DepartamentoMapper;
import ${package}.service.IDepartamentoService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa las funcionalidades de la interfaz DepartamentoPersistenceOutPort
 *
 * @since ${version}
 */
@Slf4j
@Service
public class DepartamentoService implements IDepartamentoService {

  @Autowired private DepartamentoMapper departamentoMapper;
  @Autowired private DepartamentoRepository departamentoRepository;

  @Override
  public Departamento getDepartamentoById(Long id) throws Exception  {
    Optional<DepartamentoEntity> optDepartamento = departamentoRepository.findById(id);
    if (optDepartamento.isPresent()) {
      return departamentoMapper.mapToDto(optDepartamento.get());
    } else {
      log.info("No se encontró el departamento {}", id);
      throw  new Exception("Error");
    }
  }

  @Override
  public List<Departamento> getDepartamentos() throws Exception {
    List<DepartamentoEntity> departamentoEntityList = departamentoRepository.findAll();
    if (Objects.isNull(departamentoEntityList) || departamentoEntityList.isEmpty()) {
      log.info("No se encontraron departamentos");
      throw new throws Exception("No se encontraron departamentos");
    } else {
      return departamentoMapper.mapToDto(departamentoEntityList);
    }
  }
}
