#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que reúne configuraciones y objetos utilizados en el proyecto
 *
 * @since ${version}
 */
@Configuration
public class UtilidadesConfiguration {

  /**
   * Bean encargado de realizar conversiones entre objetos Java y su representación Json
   * @return Gson
   * @see <a href="https://github.com/google/gson">Gson</a>
   */
  @Bean
  public Gson gson() {
    return new Gson();
  }
}
