#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Departamento. RUNTPROD.PA_DEPARTAME
 *
 * @since ${version}
 */
@Entity
@Table(name = "pa_departamentos", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class DepartamentoEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "idpais")
  private Long idPais;

}

