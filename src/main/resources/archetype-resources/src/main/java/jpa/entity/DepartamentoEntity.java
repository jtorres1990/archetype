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
@Table(name = "in_contrato", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class DepartamentoEntity {

  @Id
  @Column(name = "DEPARTAME_CODDPTO")
  private Long id;

  @Column(name = "DEPARTAME_NOMBRE")
  private String nombre;

  @Column(name = "DEPARTAME_PAIS_IDPAIS")
  private Long idPais;

}
