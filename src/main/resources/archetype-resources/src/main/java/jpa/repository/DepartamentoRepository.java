#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jpa.repository;

import ${package}.jpa.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio que contiene todas las operaciones necesarias para gestionar
 * la información de la entidad departamento
 *
 * @since ${version}
 */
@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {

}
