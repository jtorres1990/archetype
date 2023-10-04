#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ${package}.dto.Departamento;
import ${package}.jpa.entity.DepartamentoEntity;
import ${package}.jpa.repository.DepartamentoRepository;
import ${package}.mapper.DepartamentoMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

  @Spy private DepartamentoMapper departamentoMapper = Mappers.getMapper(DepartamentoMapper.class);

  @Mock private DepartamentoRepository departamentoRepository;

  @InjectMocks private DepartamentoService departamentoService;

  private List<DepartamentoEntity> departamentoEntityList;

  @BeforeEach
  public void setup() throws Exception {
    departamentoEntityList= new ArrayList<>();
    DepartamentoEntity dto = new DepartamentoEntity();
    dto.setId(23L);
    dto.setNombre("Departamento 1");
    departamentoEntityList.add(dto);
    dto.setId(86L);
    dto.setNombre("Departamento 1");
    departamentoEntityList.add(dto);
  }

  @ParameterizedTest
  @CsvSource({"86"})
  @DisplayName("Obtener departamento por id exitoso")
  void getDepartamentoByIdExitoso(Long departamentoId) throws Exception {
    DepartamentoEntity departamento =
            departamentoEntityList.stream()
                    .filter(depto -> departamentoId.equals(depto.getId()))
                    .findAny()
                    .orElse(null);

    Mockito.when(departamentoRepository.findById(departamentoId))
            .thenReturn(Optional.ofNullable(departamento));

    Departamento respuesta = departamentoService.getDepartamentoById(departamentoId);
    Assertions.assertNotNull(respuesta);
    Assertions.assertEquals(departamentoId, respuesta.getId());
  }

  @ParameterizedTest
  @CsvSource({"-1"})
  @DisplayName("Obtener departamento por id fallido")
  void getDepartamentoByIdNotFound(Long departamentoId) {
    Mockito.when(departamentoRepository.findById(departamentoId)).thenReturn(Optional.empty());
    Exception ex =
            Assertions.assertThrows(
                    Exception.class,
                    () -> departamentoService.getDepartamentoById(departamentoId));
    Assertions.assertNotNull(ex.getMessage());
    Assertions.assertEquals("Error", ex.getMessage());
  }

  @Test
  @DisplayName("Obtener departamentos exitoso")
  void getDepartamentos() throws Exception {
    Mockito.when(departamentoRepository.findAll()).thenReturn(departamentoEntityList);
    List<Departamento> respuesta = departamentoService.getDepartamentos();
    Assertions.assertEquals(departamentoEntityList.size(), respuesta.size());
  }

  @Test
  @DisplayName("Obtener departamentos fallido")
  void getDepartamentosNotFound() {
    Mockito.when(departamentoRepository.findAll()).thenReturn(Collections.emptyList());
    Exception ex =
            Assertions.assertThrows(
                    Exception.class,
                    () -> departamentoService.getDepartamentos());
    Assertions.assertNotNull(ex.getMessage());
    Assertions.assertEquals("No se encontraron departamentos", ex.getMessage());
  }
}
