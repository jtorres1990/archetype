#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.dto.Departamento;
import java.util.List;

/**
 * Interfaz con todos los métodos disponibles para gestionar Departamentos
 *
 * @since ${version}
 */
public interface IDepartamentoService {

  /**
   * Método encargado de obtener departamento por ID
   *
   * @param id Identificador único del departamento
   * @return Información del departamento
   * @throws ElementoNoEncontradoException Error cuando no se puede obtener el departamento
   * @since ${version}
   */
  public Departamento getDepartamentoById(Long id) throws Exception ;

  /**
   * Método encargado de listar departamentos
   *
   * @return Lista de departamentos
   * @throws ElementoNoEncontradoException Error cuando no se pueden consultar los departamentos
   * @since ${version}
   */
  public List<Departamento> getDepartamentos() throws Exception ;

}
