#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ${package}.dto.Departamento;
import ${package}.service.IDepartamentoService;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoControllerTest {

  @Mock private IDepartamentoService departamentoService;
  @InjectMocks private DepartamentoController departamentoController;

  private List<Departamento> departamentoList;

  @BeforeEach
  public void setup() throws ErrorGeneralException {
    departamentoList= new ArrayList<>();
    Departamento dto = new Departamento();
    dto.setId(1L);
    dto.setNombre("Departamento 1");
    departamentoList.add(dto);
  }

  @ParameterizedTest
  @CsvSource({"86"})
  @DisplayName("Obtener departamento por id exitoso")
  void obtenerDepartamentoIdExitoso(Long departamentoId)
          throws Exception {
    Departamento departamento =
            departamentoList.stream()
                    .filter(depto -> departamentoId.equals(depto.getId()))
                    .findAny()
                    .orElse(null);

    when(departamentoService.getDepartamentoById(departamentoId)).thenReturn(departamento);
    var departamentoResp = departamentoController.obtenerDepartamentoId(departamentoId);
    assertEquals(ResponseEntity.ok(departamento), departamentoResp);
  }

  @ParameterizedTest
  @CsvSource({"-1"})
  @DisplayName("Obtener departamento por id fallido")
  void obtenerDepartamentoIdNoExiste(Long departamentoId) throws Exception {
    when(departamentoService.getDepartamentoById(departamentoId))
            .thenThrow(
                    new Exception("No se encontró el departamento " + departamentoId));
    assertThrows(
            ElementoNoEncontradoException.class,
            () -> departamentoController.obtenerDepartamentoId(departamentoId));
    verify(departamentoService).getDepartamentoById(departamentoId);
  }

  @Test
  @DisplayName("Obtener departamentos exitoso")
  void getDepartamentosExitoso() throws Exception {
    when(departamentoService.getDepartamentos()).thenReturn(departamentoList);
    ResponseEntity<List<Departamento>>  departamentosResp = departamentoController.getDepartamentos();
    assertEquals(ResponseEntity.ok(departamentoList), departamentosResp);
  }

  @Test
  @DisplayName("Obtener departamentos fallido")
  void getDepartamentosNotFound() throws Exception {
    when(departamentoService.getDepartamentos())
            .thenThrow(new Exception("No se encontraron departamentos"));
    assertThrows(
            Exception.class, () -> departamentoController.getDepartamentos());
    verify(departamentoService).getDepartamentos();
  }
}
