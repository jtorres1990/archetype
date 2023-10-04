#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO Departamento donde se definen atributos a utilizar en la aplicación.
 *
 * @since ${version}
 */
@Getter
@Setter
@ToString
public class Departamento {
  private Long id;
  private String nombre;
  private Long idPais;
}
