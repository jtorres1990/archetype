#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Clase principal que permite iniciar el microservicio con el framework Spring Boot
 *
 * @since ${version}
 */
@EnableFeignClients
@SpringBootApplication
public class ${ArtifactIdCamel}Application {

  /**
   * Método principal que inicializa la aplicación Spring Boot
   *
   * @param args Argumentos de entrada para iniciar la aplicación de Spring Boot
   * @since ${version}
   */
  public static void main(String[] args) {
    SpringApplication.run(${ArtifactIdCamel}Application.class, args);
  }

}
