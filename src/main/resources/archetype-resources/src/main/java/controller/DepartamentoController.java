#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.dto.Departamento;
import ${package}.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase donde se implementan servicios REST para la gestión de departamentos
 *
 * @since ${version}
 */
@RestController
@RequestMapping("departamentos")
public class DepartamentoController {

  @Autowired private IDepartamentoService iDepartamentoService;

  /**
   * Servicio para obtener departamento por su ID
   *
   * @param id Identificador único del departamento a consultar
   * @return Departamento
   * @throws Exception Error cuando no se puede obtener el departamento
   */

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Departamento> obtenerDepartamentoId(@PathVariable Long id)
          throws Exception {
    return new ResponseEntity<>(iDepartamentoService.getDepartamentoById(id), HttpStatus.OK);
  }

  /**
   * Servicio para obtener todos los departamentos
   *
   * @return Lista de departamentos
   * @throws Exception Error cuando no se pueden consultar los departamentos
   */

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Departamento>> getDepartamentos()
          throws Exception {
    return new ResponseEntity<>(iDepartamentoService.getDepartamentos(), HttpStatus.OK);
  }

}
